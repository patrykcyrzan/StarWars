package com.cyrzan.starwars.ui.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.cyrzan.starwars.BR

/**
 * Created by Patryk on 06.11.2017.
 */

data class LoginViewModel(
        private var _isLoading: Boolean
) : BaseObservable() {

    var isLoading: Boolean
        @Bindable get() = _isLoading
        set(value) {
            _isLoading = isLoading
            notifyPropertyChanged(BR.loading)
        }
}