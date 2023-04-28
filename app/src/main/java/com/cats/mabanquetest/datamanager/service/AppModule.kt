package com.cats.mabanquetest.datamanager.service

import android.content.Context
import com.cats.mabanquetest.datamanager.repository.account.AccountRepository
import com.cats.mabanquetest.datamanager.service.account.AccountService
import com.cats.mabanquetest.datamanager.service.account.IAccountService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val baseUrl = "https://cdf-test-mobile-default-rtdb.europe-west1.firebasedatabase.app/"
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpclient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpclient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideAccountsService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideAccountService(apiService: ApiService, @ApplicationContext context: Context) = AccountService(apiService, context)

    @Singleton
    @Provides
    fun provideAccountRepository(
        accountService: AccountService
    ) =  AccountRepository(accountService)
}