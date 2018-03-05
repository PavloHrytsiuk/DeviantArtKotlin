package org.hrytsiuk.deviantart.deviantartkotlin.network

import io.reactivex.Observable
import org.hrytsiuk.deviantart.deviantartkotlin.network.model.AccessTokenWrapper
import org.hrytsiuk.deviantart.deviantartkotlin.network.model.PictureWrapper
import retrofit2.http.GET
import retrofit2.http.Query


interface PictureApi {

    @GET("api/v1/oauth2/browse/hot")
    fun fetchPictures(@Query("access_token") token: String,
                      @Query("limit") limit: Int): Observable<PictureWrapper>

    @GET("oauth2/token")
    fun fetchAccessToken(@Query("grant_type") type: String,
                         @Query("client_id") id: Int,
                         @Query("client_secret") secret: String): Observable<AccessTokenWrapper>
}