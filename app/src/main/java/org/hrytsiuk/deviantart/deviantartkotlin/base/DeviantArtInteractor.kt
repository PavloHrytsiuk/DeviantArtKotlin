package org.hrytsiuk.deviantart.deviantartkotlin.base

import org.hrytsiuk.deviantart.deviantartkotlin.base.mvp.BaseInteractor
import org.hrytsiuk.deviantart.deviantartkotlin.network.RestApi


abstract class DeviantArtInteractor : BaseInteractor {

    companion object {
        const val TOKEN_TYPE = "client_credentials"
        const val CLIENT_SECRET = "8734c1b097f205b3c2679876943ae58b"
        const val CLIENT_ID = 7231
    }

    override fun getRestApi(): RestApi {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClientId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClientSecret(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTokenType(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}