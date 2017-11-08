package com.cyrzan.starwars.ui.main

import com.cyrzan.starwars.data.repository.DribbbleRepository
import com.cyrzan.starwars.util.SchedulerProvider
import javax.inject.Inject

/**
 * Created by Patryk on 08.11.2017.
 */

class MainPresenter @Inject constructor(private val repository: DribbbleRepository, private val schedulerProvider: SchedulerProvider) : MainContract.Presenter {

    override var view: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }


}