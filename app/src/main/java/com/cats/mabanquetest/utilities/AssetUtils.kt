package com.cats.mabanquetest.utilities

import android.content.Context
import java.io.IOException

object AssetUtils {
     fun getJsonDataFromAsset(context: Context, filename : String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}