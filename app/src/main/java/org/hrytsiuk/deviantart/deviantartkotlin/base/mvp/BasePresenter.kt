package org.hrytsiuk.deviantart.deviantartkotlin.base.mvp

interface BasePresenter<in T : BaseView> {

    fun onDestroy()

    fun attachView(view: T)
}