package com.cyrzan.starwars.data.repository

import com.cyrzan.starwars.data.local.UserPreferencesImpl
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
@Inject constructor(private val dribbbleAuth: DribbbleAuth, private val dribbbleApi: DribbbleApi, private val userPreferencesImpl: UserPreferencesImpl) {

    fun loginUser(code: String): Single<LoginResponse> {
        return dribbbleAuth.loginUser(code)
    }

    fun saveUserToken(token: String?) {
        userPreferencesImpl.saveUserToken(token)
    }

    fun getUsetToken(): String {
        return userPreferencesImpl.token
    }
}