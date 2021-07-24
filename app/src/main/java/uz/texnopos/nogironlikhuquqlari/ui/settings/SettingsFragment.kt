package uz.texnopos.mehrtilsimi.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import uz.texnopos.mehrtilsimi.R
import uz.texnopos.mehrtilsimi.core.Constants.TEXT_SIZE
import uz.texnopos.mehrtilsimi.core.getSharedPreferences
import uz.texnopos.mehrtilsimi.core.onClick
import uz.texnopos.mehrtilsimi.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val settings:Settings by inject()
    private lateinit var bind:FragmentSettingsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind= FragmentSettingsBinding.bind(view)
        bind.text.textSize= settings.textSize
        bind.currentSize.text=settings.textSize.toInt().toString()
        bind.increment.onClick {
          if (settings.textSize<40) {
              settings.textSize += 2f
              bind.text.textSize = settings.textSize
              bind.currentSize.text = settings.textSize.toInt().toString()
          }
        }
        bind.decrement.onClick {
            if (settings.textSize>16) {
                settings.textSize -= 2f
                bind.text.textSize = settings.textSize
                bind.currentSize.text = settings.textSize.toInt().toString()
            }
        }
    }


}