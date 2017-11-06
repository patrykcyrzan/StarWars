package com.cyrzan.starwars.di.module

import com.cyrzan.starwars.BuildConfig
import com.cyrzan.starwars.data.remote.DribbbleApi
import com.cyrzan.starwars.data.remote.DribbbleAuth
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Patryk on 06.11.2017.
 */

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideDribbbleApiService(gson: Gson, okHttpClient: OkHttpClient): DribbbleApi {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BuildConfig.DRIBBBLE_API)
                .build()
        return retrofit.create(DribbbleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDribbbleAuthService(gson: Gson, okHttpClient: OkHttpClient): DribbbleAuth {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BuildConfig.DRIBBBLE_AUTH)
                .build()
        return retrofit.create(DribbbleAuth::class.java)
    }
}