package org.hrytsiuk.deviantart.deviantartkotlin.core.modules

import io.reactivex.Observable
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture
import org.hrytsiuk.deviantart.deviantartkotlin.network.model.AccessTokenWrapper
import org.hrytsiuk.deviantart.deviantartkotlin.network.model.PictureWrapper

class PictureInteractorImpl : PictureInteractor() {
    override fun fetchAccessToken(): Observable<String> {
        return getRestApi().pictureApi.fetchAccessToken(getTokenType(), getClientId(), getClientSecret()).map(AccessTokenWrapper::accessToken)
    }

    override fun fetchPictures(accessToken: String, limit: Int): Observable<List<Picture>> {
        return getRestApi().pictureApi.fetchPictures(accessToken, limit).map(PictureWrapper::results)

    }
}