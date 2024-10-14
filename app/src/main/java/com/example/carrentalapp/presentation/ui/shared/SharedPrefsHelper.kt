package com.example.carrentalapp.presentation.ui.shared

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsHelper(context: Context){
    private val sharedPreferences : SharedPreferences =
        context.getSharedPreferences( "prefs", Context.MODE_PRIVATE)
    fun setString(key: String, value: String){
        sharedPreferences.edit().putString(key, value).apply()
    }
    fun getString(key: String, defaultValue: String): String{
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
    fun setBoolean(key: String, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
    fun getBoolean(key: String, defaultValue: Boolean): Boolean{
        return  sharedPreferences.getBoolean(key, defaultValue) ?: defaultValue
    }


}