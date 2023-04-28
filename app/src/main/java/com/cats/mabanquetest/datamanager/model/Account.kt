package com.cats.mabanquetest.datamanager.model

import com.google.gson.annotations.SerializedName

data class Account (
    @SerializedName("order") val order: Int,
    @SerializedName("id") val id: String,
    @SerializedName("holder") val holder: String,
    @SerializedName("role") val role: Int,
    @SerializedName("contract_number") val contractNumber: String,
    @SerializedName("label") val label: String,
    @SerializedName("product_code") val productCode: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("operations") val operations: List<Operation>
    )