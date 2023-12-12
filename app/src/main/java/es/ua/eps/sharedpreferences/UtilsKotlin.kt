package es.ua.eps.sharedpreferences

import android.util.Base64

object UtilsKotlin {
    fun encrypt(input:String?) : String {
        return Base64.encodeToString(input?.toByteArray(), Base64.DEFAULT)
    }

    fun decrypt(input: String?): String {
        return String(Base64.decode(input?.toByteArray(), Base64.DEFAULT))
    }
}