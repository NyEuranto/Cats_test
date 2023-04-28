package com.cats.mabanquetest.datamanager.service.account

import com.cats.mabanquetest.datamanager.model.Bank
import com.cats.mabanquetest.datamanager.service.common.DataResponse
import retrofit2.Response

interface IAccountService {
    suspend fun getAllBankList(): Response<List<Bank>>
    suspend  fun getBanksFromAssets(): DataResponse<List<Bank>>
}