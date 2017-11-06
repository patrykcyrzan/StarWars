package com.cyrzan.starwars.ui.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.cyrzan.starwars.BR

/**
 * Created by Patryk on 06.11.2017.
 */

data class LoginViewModel(
        private var _username: String,
        private var _password: String
) : BaseObservable() {

    var username: String
        @Bindable get() = _username
        set(value) {
            _username = username
            notifyPropertyChanged(BR.username)
        }

    var password: String
        @Bindable get() = _password
        set(value) {
            _password = password
            notifyPropertyChanged(BR.password)
        }
}