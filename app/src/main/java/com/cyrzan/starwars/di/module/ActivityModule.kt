package com.cyrzan.starwars.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by Patryk on 03.11.2017.
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}