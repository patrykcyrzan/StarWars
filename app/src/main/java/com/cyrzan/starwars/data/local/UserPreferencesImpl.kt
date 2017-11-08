package com.cyrzan.starwars.data.local

import android.content.SharedPreferences

/**
 * Created by Patryk on 08.11.2017.
 */

class UserPreferencesImpl constructor(val sharedPreferences: SharedPreferences){

    private val USER_PREFERENCES = "user_pref"
    private val USER_TOKEN = "user_token"

    val token: String
    get() = sharedPreferences.getString(USER_TOKEN, null)

    fun saveUserToken(token: String?){
        sharedPreferences.put {
            putString(USER_TOKEN, token)
        }
    }

    private inline fun SharedPreferences.put(body: SharedPreferences.Editor.() -> Unit) {
        val editor = this.edit()
        editor.body()
        editor.apply()
    }
}