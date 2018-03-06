package org.hrytsiuk.deviantart.deviantartkotlin.network.model

import com.google.gson.annotations.SerializedName

data class AccessTokenWrapper(
        @SerializedName("access_token") val accessToken: String) {
}