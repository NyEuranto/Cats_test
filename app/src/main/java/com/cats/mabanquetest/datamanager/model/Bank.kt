package com.cats.mabanquetest.datamanager.model

import com.google.gson.annotations.SerializedName


data class Bank(
    @SerializedName("name") val name: String,
    @SerializedName("accounts") val accounts: List<Account>,
    @SerializedName("isCA") val isCreditAgricole: Int,
    )