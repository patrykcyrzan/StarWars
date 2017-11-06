package com.cyrzan.starwars.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Patryk on 06.11.2017.
 */

class AppSchedulerProvider : SchedulerProvider {

    override fun ioScheduler() = Schedulers.io()
    override fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}