package com.cyrzan.starwars.data.repository

import com.cyrzan.starwars.model.LoginResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Patryk on 06.11.2017.
 */

class DribbbleRepository
@Inject constructor() {

    fun loginUser(): Single<LoginResponse> {
        return Single.just(LoginResponse())
    }
}