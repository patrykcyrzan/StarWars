package com.cyrzan.starwars.data.remote

import com.cyrzan.starwars.BuildConfig
import com.cyrzan.starwars.model.LoginResponse
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Patryk on 06.11.2017.
 */

interface DribbbleAuth {

    @POST("/token")
    fun loginUser(@Query("code") authCode: String,
                  @Query("client_id") clientId: String = BuildConfig.CLIENT_ID,
                  @Query("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET): Single<LoginResponse>
}