package com.cyrzan.starwars.ui.login

import com.cyrzan.starwars.data.repository.DribbbleRepository
import com.cyrzan.starwars.model.LoginResponse
import com.cyrzan.starwars.util.TestSchedulerProvider
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


/**
 * Created by Patryk on 06.11.2017.
 */

class LoginPresenterTest {
    lateinit var presenter: LoginPresenter
    lateinit var testSchedulerProvider: TestSchedulerProvider

    @Mock lateinit var mockView: LoginContract.View
    @Mock lateinit var mockRepository: DribbbleRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        testSchedulerProvider = TestSchedulerProvider()
        presenter = LoginPresenter(mockRepository)
    }

    @Test
    fun whenUserLogin_withIncorrectData_thenShowErrorMessage() {
        // Given
        val error = "Test error"
        val single: Single<LoginResponse> = Single.create { emitter ->
            emitter.onError(Exception(error))
        }

        // When
        whenever(mockRepository.loginUser(any())).thenReturn(single)

        presenter.attachView(mockView)
        presenter.doLogin()

        testSchedulerProvider.testScheduler.triggerActions()

        // Then
        verify(mockView).showLoading()
        verify(mockView).loginFailure()
        verify(mockView).hideLoading()

    }

    @Test
    fun whenUserLogin_withCorrectData_thenKeepGoing() {
        // Given
        val loginResponse = LoginResponse()
        val single: Single<LoginResponse> = Single.create { emitter ->
            emitter.onSuccess(loginResponse)
        }

        // When
        whenever(mockRepository.loginUser()).thenReturn(single)

        presenter.attachView(mockView)
        presenter.doLogin()

        testSchedulerProvider.testScheduler.triggerActions()

        // Then
        verify(mockView).showLoading()
        verify(mockView).loginSuccess()
        verify(mockView).hideLoading()
    }
}