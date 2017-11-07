package com.cyrzan.starwars.ui.login

import android.databinding.BaseObservable

/**
 * Created by Patryk on 06.11.2017.
 */

data class LoginViewModel(
        var isLoading: Boolean = false,
        var isWebViewVisible: Boolean = false
) : BaseObservable()