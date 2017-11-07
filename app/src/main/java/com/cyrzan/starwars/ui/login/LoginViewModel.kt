package com.cyrzan.starwars.ui.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by Patryk on 06.11.2017.
 */

class LoginViewModel : BaseObservable() {

    @get:Bindable
    var isLoading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @get:Bindable
    var isWebViewVisible: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.webViewVisible)
        }

}