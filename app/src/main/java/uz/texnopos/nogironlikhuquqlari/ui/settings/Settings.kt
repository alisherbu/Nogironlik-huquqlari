package uz.texnopos.nogironlikhuquqlari.ui.settings

import uz.texnopos.nogironlikhuquqlari.core.Constants.TEXT_SIZE
import uz.texnopos.nogironlikhuquqlari.core.getSharedPreferences

class Settings {
    companion object{
        var textSize: Float
            set(value) = getSharedPreferences().setValue(TEXT_SIZE, value)
            get() = getSharedPreferences().getFloatValue(TEXT_SIZE, 20f)
    }

}