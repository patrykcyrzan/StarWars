package com.cyrzan.starwars.ui.base


/**
 * Created by Patryk on 03.11.2017.
 */

interface BaseContract {

    interface View

    interface Presenter<V : BaseContract.View> {

        val view: V?

        val isViewAttached: Boolean

        fun attachView(view: V)

        fun detachView()
    }
}