package uz.texnopos.nogironlikhuquqlari.ui.settings

import android.content.Context
import uz.texnopos.nogironlikhuquqlari.core.Constants.TEXT_SIZE
import uz.texnopos.nogironlikhuquqlari.core.getSharedPreferences

class Settings(private val context: Context) {
    var textSize: Float
        set(value) = getSharedPreferences().setValue(TEXT_SIZE, value)
        get() = getSharedPreferences().getFloatValue(TEXT_SIZE, 20f)
}