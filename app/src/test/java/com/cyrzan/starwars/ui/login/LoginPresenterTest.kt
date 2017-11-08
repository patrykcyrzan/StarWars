package com.cyrzan.starwars.ui.login

import com.cyrzan.starwars.data.repository.DribbbleRepository
import com.cyrzan.starwars.model.LoginResponse
import com.cyrzan.starwars.util.TestSchedulerProvider
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner


/**
 * Created by Patryk on 06.11.2017.
 */

@RunWith(RobolectricTestRunner::class)
class LoginPresenterTest {
    lateinit var presenter: LoginPresenter
    lateinit var testSchedulerProvider: TestSchedulerProvider

    @Mock lateinit var mockView: LoginContract.View
    @Mock lateinit var mockRepository: DribbbleRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        testSchedulerProvider = TestSchedulerProvider()
        presenter = LoginPresenter(mockRepository, testSchedulerProvider)
    }

    @Test
    fun whenUserLogin_thenShowWebView() {
        // When
        presenter.attachView(mockView)
        presenter.doLogin()

        // Then
        verify(mockView).showLoading()
        verify(mockView).showWebView()
        verifyNoMoreInteractions(mockView)
    }

    @Test
    fun whenUserIsOnLoginPage_withNullUrl_thenHideLoading() {
        // When
        presenter.attachView(mockView)
        presenter.handleUrl(null)

        // Then
        verify(mockView).hideLoading()
        verifyNoMoreInteractions(mockView)
    }

    @Test
    fun whenUserIsCorrectLogged_withUrlWithCodeParam_thenGetAccessToken() {
        // Given
        val url = "https://test.com/StarWars?code=71275f1952ee0339be54bf90f60a109e8e09fbe2ea32295292486328e40cc0a6"

        val loginResponse = LoginResponse()
        val single: Single<LoginResponse> = Single.create { emitter ->
            emitter.onSuccess(loginResponse)
        }

        // When
        whenever(mockRepository.loginUser(any())).thenReturn(single)
        presenter.attachView(mockView)
        presenter.handleUrl(url)

        // Then
        verify(mockView).hideLoading()
        verify(mockView).showLoading()
        verify(mockRepository).loginUser(any())
    }

    @Test
    fun whenUserIsCorrectLogged_withUrlWithoutCodeParam_thenLoginFailure() {
        // Given
        val url = "http://your-application.com/callback?error=invalid_redirect_uri&error_description=The+redirect+uri+included+is+not+valid.&state=xyz"

        // When
        presenter.attachView(mockView)
        presenter.handleUrl(url)

        // Then
        verify(mockView).hideLoading()
        verify(mockView).loginFailure()
        verifyNoMoreInteractions(mockView)
    }
}