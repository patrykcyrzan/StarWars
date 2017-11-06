package com.cyrzan.starwars.di.module

import android.app.Application
import android.content.Context
import com.cyrzan.starwars.util.AppSchedulerProvider
import com.cyrzan.starwars.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Patryk on 03.11.2017.
 */

@Singleton
@Module
class ApplicationModule(var app: Application) {

    @Provides
    @Singleton
    fun provideApp(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}