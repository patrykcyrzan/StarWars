package com.cyrzan.starwars.di.component

import com.cyrzan.starwars.di.module.ActivityModule
import com.cyrzan.starwars.ui.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by Patryk on 03.11.2017.
 */

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(loginActivity: LoginActivity)
}