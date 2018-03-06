package org.hrytsiuk.deviantart.deviantartkotlin.core.modules

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class PicturePresenterImpl : PicturePresenter {

    private lateinit var view: PictureView
    private val interactor: PictureInteractor = PictureInteractorImpl()
    private var disposable: Disposable = Disposables.empty()

    override fun fetchPictures(accessToken: String, limit: Int) {
        disposable = interactor.fetchPictures(accessToken, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.loadPictures(it) },
                        { Log.d("TAG", "onThrow: ${it.localizedMessage}") })
    }

    override fun fetchAccessToken() {
        disposable = interactor.fetchAccessToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.saveAccessToken(it) },
                        { Log.d("TAG", "Access Throwable:" + it.localizedMessage) })
    }

    override fun onDestroy() {
        disposable.dispose()
    }

    override fun attachView(view: PictureView) {
        this.view = view
    }

}