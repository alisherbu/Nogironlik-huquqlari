package uz.texnopos.nogironlikhuquqlari.ui.settings

import uz.texnopos.nogironlikhuquqlari.core.Constants.FIRST_LAUNCH
import uz.texnopos.nogironlikhuquqlari.core.Constants.TEXT_SIZE
import uz.texnopos.nogironlikhuquqlari.core.getSharedPreferences

class Settings {
    companion object {
        var textSize: Float
            set(value) = getSharedPreferences().setValue(TEXT_SIZE, value)
            get() = getSharedPreferences().getFloatValue(TEXT_SIZE, 20f)

        var firstLaunched: Boolean
            set(value) = getSharedPreferences().setValue(FIRST_LAUNCH, value)
            get() = getSharedPreferences().getBooleanValue(FIRST_LAUNCH, true)
    }

}