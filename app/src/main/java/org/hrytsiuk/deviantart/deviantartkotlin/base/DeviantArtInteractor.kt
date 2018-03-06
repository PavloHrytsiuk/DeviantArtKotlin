package org.hrytsiuk.deviantart.deviantartkotlin.base

import org.hrytsiuk.deviantart.deviantartkotlin.base.mvp.BaseInteractor
import org.hrytsiuk.deviantart.deviantartkotlin.network.RestApi


abstract class DeviantArtInteractor : BaseInteractor {

    companion object {
        const val TOKEN_TYPE = "client_credentials"
        const val CLIENT_SECRET = "8734c1b097f205b3c2679876943ae58b"
        const val CLIENT_ID = 7231
    }

    private val api: RestApi = RestApi()

    override fun getRestApi(): RestApi {
        return api
    }

    override fun getClientId(): Int {
        return CLIENT_ID
    }

    override fun getClientSecret(): String {
        return CLIENT_SECRET
    }

    override fun getTokenType(): String {
        return TOKEN_TYPE
    }
}