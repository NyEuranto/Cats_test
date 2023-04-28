package com.cats.mabanquetest.datamanager.service.account

import android.content.Context
import com.cats.mabanquetest.datamanager.model.Bank
import com.cats.mabanquetest.datamanager.service.ApiService
import com.cats.mabanquetest.datamanager.service.common.DataResponse
import com.cats.mabanquetest.utilities.AssetUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import javax.inject.Inject

class AccountService  @Inject constructor(
    private val apiService: ApiService,
    private val context: Context
) : IAccountService {
    override suspend fun getAllBankList(): Response<List<Bank>> {
        return apiService.getAllBanks()
    }

    override suspend fun getBanksFromAssets(): DataResponse<List<Bank>> {
        val gson = Gson()
        val bankList = object : TypeToken<List<Bank>>() {}.type
        val banks: List<Bank> = gson.fromJson(AssetUtils.getJsonDataFromAsset(context,""), bankList)
        return DataResponse.success(banks)
    }
}
