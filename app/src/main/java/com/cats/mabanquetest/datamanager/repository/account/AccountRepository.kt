package com.cats.mabanquetest.datamanager.repository.account

import com.cats.mabanquetest.datamanager.model.Bank
import com.cats.mabanquetest.datamanager.service.account.AccountService
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountService: AccountService
) : IAccountRepository {
     override suspend fun getBankList(): List<Bank> {
        val response = accountService.getAllBankList()
        if (response.isSuccessful) {
            val body = response.body()
            return body ?: listOf()
        } else {
            val assetResponse = accountService.getBanksFromAssets()
            return assetResponse?.data!!
        }
    }
}