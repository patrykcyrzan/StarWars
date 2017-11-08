package com.cyrzan.starwars.ui

import android.app.Activity
import android.content.Intent
import com.cyrzan.starwars.ui.main.MainActivity

/**
 * Created by Patryk on 08.11.2017.
 */

interface NavigatorApi {
    fun openMainActivity(context: Activity)
}

class Navigator : NavigatorApi {
    override fun openMainActivity(context: Activity) {
        val intent = Intent(context, MainActivity::class.java)
                .apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) }
        context.startActivity(intent)
    }
}