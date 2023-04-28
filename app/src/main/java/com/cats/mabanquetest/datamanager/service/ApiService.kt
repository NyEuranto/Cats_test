package com.cats.mabanquetest.datamanager.service

import com.cats.mabanquetest.datamanager.model.Bank
import retrofit2.Response;
import retrofit2.http.GET;

interface ApiService {

    @GET("banks.json")
    suspend fun getAllBanks() : Response<List<Bank>>
}