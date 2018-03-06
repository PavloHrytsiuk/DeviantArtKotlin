package org.hrytsiuk.deviantart.deviantartkotlin.core

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.hrytsiuk.deviantart.deviantartkotlin.R
import org.hrytsiuk.deviantart.deviantartkotlin.base.BaseActivity
import org.hrytsiuk.deviantart.deviantartkotlin.base.OnItemClickListener
import org.hrytsiuk.deviantart.deviantartkotlin.core.adapter.PictureAdapter
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture
import org.hrytsiuk.deviantart.deviantartkotlin.core.modules.PicturePresenter
import org.hrytsiuk.deviantart.deviantartkotlin.core.modules.PicturePresenterImpl
import org.hrytsiuk.deviantart.deviantartkotlin.core.modules.PictureView

class MainActivity : BaseActivity(), PictureView, OnItemClickListener {

    companion object {
        const val ACCESS_TOKEN: String = "Access token"
        const val CLICKED_PICTURE: String = "Pictures list"
    }

    private val presenter: PicturePresenter = PicturePresenterImpl()
    private lateinit var preferences: PicturePref
    private lateinit var pictures: List<Picture>
    private lateinit var adapter: PictureAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        preferences = PicturePref(this)
        linearLayoutManager = LinearLayoutManager(this)
        pictureRecycle.layoutManager = linearLayoutManager
        presenter.fetchAccessToken()
    }

    override fun saveAccessToken(accessToken: String) {
        preferences.saveStringData(accessToken, ACCESS_TOKEN)
        presenter.fetchPictures(accessToken, 120)
    }

    override fun loadPictures(pictures: List<Picture>) {
        adapter = PictureAdapter(pictures, this)
        pictureRecycle.adapter = adapter
        this.pictures = pictures
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, PictureDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(CLICKED_PICTURE, pictures[position])
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
