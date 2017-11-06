package com.cyrzan.starwars.ui.base


/**
 * Created by Patryk on 03.11.2017.
 */


open class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    override var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}