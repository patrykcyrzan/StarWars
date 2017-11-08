package com.cyrzan.starwars.ui.main

import com.cyrzan.starwars.ui.base.BaseContract

/**
 * Created by Patryk on 08.11.2017.
 */

interface MainContract {

    interface View : BaseContract.View{
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadImages()
    }
}