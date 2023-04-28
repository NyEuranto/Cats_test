package com.cats.mabanquetest.datamanager.repository.account

import com.cats.mabanquetest.datamanager.model.Bank

interface IAccountRepository {
    suspend fun getBankList(): List<Bank>
}