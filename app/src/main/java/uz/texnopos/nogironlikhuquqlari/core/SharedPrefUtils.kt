package uz.texnopos.nogironlikhuquqlari.core

import android.content.Context
import android.content.SharedPreferences
import uz.texnopos.nogironlikhuquqlari.App.Companion.getAppInstance
import uz.texnopos.nogironlikhuquqlari.core.Constants.myPreferences

class SharedPrefUtils {
    private val mSharedPreferences: SharedPreferences = getAppInstance()
        .getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
    private var mSharedPreferencesEditor: SharedPreferences.Editor = mSharedPreferences.edit()

    init {
        mSharedPreferencesEditor.apply()
    }

    fun setValue(key: String, value: Any?) {
        when (value) {
            is Int? -> {
                mSharedPreferencesEditor.putInt(key, value!!).apply()
            }
            is Float? -> {
                mSharedPreferencesEditor.putFloat(key, value!!).apply()
            }
            is String? -> {
                mSharedPreferencesEditor.putString(key, value!!).apply()
            }
            is Long? -> {
                mSharedPreferencesEditor.putLong(key, value!!).apply()
            }
            is Boolean? -> {
                mSharedPreferencesEditor.putBoolean(key, value!!).apply()
            }
        }
    }

    fun getFloatValue(key: String, defaultValue: Float): Float {
        return mSharedPreferences.getFloat(key,defaultValue)
    }
    fun getBooleanValue(key:String,defaultValue: Boolean):Boolean{
        return mSharedPreferences.getBoolean(key,defaultValue)
    }

    fun clear() {
        mSharedPreferencesEditor.clear().apply()
    }
}