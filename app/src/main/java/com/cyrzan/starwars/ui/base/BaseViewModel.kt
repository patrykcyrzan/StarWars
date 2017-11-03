package com.cyrzan.starwars.ui.base

import android.arch.lifecycle.ViewModel

/**
 * Created by Patryk on 03.11.2017.
 */

class BaseViewModel<V : BaseContract.View, P : BaseContract.Presenter<V>> : ViewModel() {

    private var presenter: P? = null

    override fun onCleared() {
        super.onCleared()
        presenter = null
    }
}