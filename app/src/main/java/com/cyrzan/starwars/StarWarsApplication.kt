package com.cyrzan.starwars

import android.app.Application
import com.cyrzan.starwars.di.component.ApplicationComponent
import com.cyrzan.starwars.di.component.DaggerApplicationComponent
import com.cyrzan.starwars.di.module.ApplicationModule

/**
 * Created by Patryk on 03.11.2017.
 */

class StarWarsApplication : Application() {

    companion object {
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}

