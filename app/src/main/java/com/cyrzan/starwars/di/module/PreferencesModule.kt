package com.cyrzan.starwars.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cyrzan.starwars.data.local.UserPreferencesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Patryk on 08.11.2017.
 */

@Module
class PreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesUserPreferences(sharedPreferences: SharedPreferences): UserPreferencesImpl {
        return UserPreferencesImpl(sharedPreferences)
    }
}