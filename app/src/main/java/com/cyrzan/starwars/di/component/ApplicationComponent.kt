package com.cyrzan.starwars.di.component

import android.app.Application
import android.content.Context
import com.cyrzan.starwars.di.module.ActivityModule
import com.cyrzan.starwars.di.module.ApiModule
import com.cyrzan.starwars.di.module.ApplicationModule
import com.cyrzan.starwars.di.module.PreferencesModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Patryk on 03.11.2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class, PreferencesModule::class))
interface ApplicationComponent {

    fun app(): Application

    fun context(): Context

    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}