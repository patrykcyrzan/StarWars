package com.cyrzan.starwars.util

import io.reactivex.Scheduler

/**
 * Created by Patryk on 06.11.2017.
 */

interface SchedulerProvider {
    fun uiScheduler(): Scheduler
    fun ioScheduler(): Scheduler
}