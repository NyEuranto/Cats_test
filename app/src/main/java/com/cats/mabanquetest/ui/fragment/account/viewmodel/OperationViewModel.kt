package com.cats.mabanquetest.ui.fragment.account.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cats.mabanquetest.datamanager.model.Account
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OperationViewModel @Inject constructor(
) : ViewModel() {
    val account = MutableLiveData<Account>()

    fun setAccountValue(accountValue : Account){
        account.postValue(accountValue)
    }
}