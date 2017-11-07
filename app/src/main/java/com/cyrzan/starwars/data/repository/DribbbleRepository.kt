package com.cyrzan.starwars.data.repository

import com.cyrzan.starwars.data.remote.DribbbleApi
import com.cyrzan.starwars.data.remote.DribbbleAuth
import com.cyrzan.starwars.model.LoginResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Patryk on 06.11.2017.
 */

@Singleton
class DribbbleRepository
@Inject constructor(private val dribbbleAuth: DribbbleAuth, private val dribbbleApi: DribbbleApi) {

    fun loginUser(): Single<LoginResponse> {
        return dribbbleAuth.loginUser("")
    }
}