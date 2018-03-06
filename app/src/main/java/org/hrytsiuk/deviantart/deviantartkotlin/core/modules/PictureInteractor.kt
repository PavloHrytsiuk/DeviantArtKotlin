package org.hrytsiuk.deviantart.deviantartkotlin.core.modules

import io.reactivex.Observable
import org.hrytsiuk.deviantart.deviantartkotlin.base.DeviantArtInteractor
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture

abstract class PictureInteractor : DeviantArtInteractor() {

    abstract fun fetchAccessToken(): Observable<String>

    abstract fun fetchPictures(accessToken: String,
                               limit: Int): Observable<List<Picture>>
}