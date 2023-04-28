package com.cats.mabanquetest.ui.fragment.account.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cats.mabanquetest.datamanager.model.Bank
import com.cats.mabanquetest.datamanager.repository.account.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository
): ViewModel() {
    val bankList = MutableLiveData<List<Bank>>()
    val errorMessage = MutableLiveData<String>()
    var cabankList =  MutableLiveData<List<Bank>>()
    var otherbankList = MutableLiveData<List<Bank>>()

    var job: Job? = CoroutineScope(Dispatchers.IO).launch {
        val banks = accountRepository.getBankList()
        withContext(Dispatchers.Main) {
            if (banks != null) {
                bankList.postValue(banks)
                cabankList.postValue(banks.filter { it -> it.isCreditAgricole == 1 }.sortedBy { it.name })
                otherbankList.postValue(banks.filter { it -> it.isCreditAgricole != 1 }.sortedBy { it.name })
            } else {
                onError("Can't reach data")
            }
        }
    }



    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}