package org.hrytsiuk.deviantart.deviantartkotlin.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RestApi {

    companion object {
        private const val BASE_URL: String = "https://www.deviantart.com/"
    }

    val pictureApi: PictureApi

    init {
        val pictureClientBuilder = createClientBuilder()
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(pictureClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        pictureApi = retrofit.create(PictureApi::class.java)
    }

    private fun createClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
    }
}