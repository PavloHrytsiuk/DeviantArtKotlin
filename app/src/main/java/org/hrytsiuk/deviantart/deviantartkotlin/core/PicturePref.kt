package org.hrytsiuk.deviantart.deviantartkotlin.core

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PicturePref(context: Context) {

    private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveStringData(data: String, name: String) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(name, data).apply()
    }

    fun loadStringData(name: String): String {
        return preferences.getString(name, "")
    }

    fun deleteStringData(name: String) {
        preferences.edit().remove(name).apply()
    }
}