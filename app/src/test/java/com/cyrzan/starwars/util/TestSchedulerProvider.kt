package com.cyrzan.starwars.util

import io.reactivex.schedulers.TestScheduler

/**
 * Created by Patryk on 06.11.2017.
 */

class TestSchedulerProvider() : SchedulerProvider {

    val testScheduler: TestScheduler = TestScheduler()

    override fun uiScheduler() = testScheduler
    override fun ioScheduler() = testScheduler
}