package org.hrytsiuk.deviantart.deviantartkotlin.base.mvp

import org.hrytsiuk.deviantart.deviantartkotlin.network.RestApi

interface BaseInteractor {

    fun getRestApi(): RestApi

    fun getClientId(): Int

    fun getClientSecret(): String

    fun getTokenType(): String

}