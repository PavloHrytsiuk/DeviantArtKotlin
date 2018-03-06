package org.hrytsiuk.deviantart.deviantartkotlin.core.modules

import org.hrytsiuk.deviantart.deviantartkotlin.base.mvp.BasePresenter

interface PicturePresenter : BasePresenter<PictureView> {
    fun fetchPictures(accessToken: String, limit: Int)

    fun fetchAccessToken()
}