package com.cyrzan.starwars.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Patryk on 06.11.2017.
 */

class LoginResponse {

    @SerializedName("access_token")
    val token: String? = null

    @SerializedName("token_type")
    val tokenType: String? = null

    @SerializedName("created_at")
    val createdAt: Long? = null
}