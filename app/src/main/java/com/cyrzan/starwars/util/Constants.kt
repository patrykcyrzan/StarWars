package com.cyrzan.starwars.util

import com.cyrzan.starwars.BuildConfig

/**
 * Created by Patryk on 06.11.2017.
 */

object Constants {

    const val CLIENT_ID = BuildConfig.CLIENT_ID

    const val AUTH_URL = BuildConfig.DRIBBBLE_AUTH + "?client_id=$CLIENT_ID&scope=public+write"
}