package uz.texnopos.nogironlikhuquqlari.ui.settings

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import dev.b3nedikt.app_locale.AppLocale
import org.koin.android.ext.android.inject
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.Constants.LATIN
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val settings: Settings by inject()
    private lateinit var bind: FragmentSettingsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentSettingsBinding.bind(view)
        bind.toolbar.toolbarTitle.text=getString(R.string.settings)
        bind.autoComplete.setText(if (AppLocale.desiredLocale==LATIN) "Lotin" else "Кирилл" )
        val adapter=ArrayAdapter(requireContext(),R.layout.item_spinner_locale, listOf("Lotin","Кирилл"))
        bind.autoComplete.setAdapter(adapter)
        bind.autoComplete.setOnItemClickListener { parent, view, position, id ->
            AppLocale.desiredLocale=AppLocale.supportedLocales[position]
            bind.toolbar.toolbarTitle.text=getString(R.string.settings)
        }















        bind.text.textSize = settings.textSize
        bind.currentSize.text = settings.textSize.toInt().toString()
        bind.increment.onClick {
            if (settings.textSize < 40) {
                settings.textSize += 2f
                bind.text.textSize = settings.textSize
                bind.currentSize.text = settings.textSize.toInt().toString()
            }
        }
        bind.decrement.onClick {
            if (settings.textSize > 16) {
                settings.textSize -= 2f
                bind.text.textSize = settings.textSize
                bind.currentSize.text = settings.textSize.toInt().toString()
            }
        }
        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }


}