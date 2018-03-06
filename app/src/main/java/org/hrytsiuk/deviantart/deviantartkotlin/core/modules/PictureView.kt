package org.hrytsiuk.deviantart.deviantartkotlin.core.modules

import org.hrytsiuk.deviantart.deviantartkotlin.base.mvp.BaseView
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture

interface PictureView : BaseView {

    fun saveAccessToken(accessToken: String)

    fun loadPictures(pictures: List<Picture>)
}