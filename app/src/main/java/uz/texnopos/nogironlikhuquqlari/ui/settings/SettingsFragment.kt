package uz.texnopos.nogironlikhuquqlari.ui.settings

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import dev.b3nedikt.app_locale.AppLocale
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.Constants.CYRIL
import uz.texnopos.nogironlikhuquqlari.core.Constants.LATIN
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentSettingsBinding
import uz.texnopos.nogironlikhuquqlari.di.dataModule

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var bind: FragmentSettingsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentSettingsBinding.bind(view)
        bind.toolbar.toolbarTitle.text = getString(R.string.settings)
        bind.text.text = getString(R.string.lorem)
        bind.autoComplete.setText(if (AppLocale.desiredLocale == CYRIL) "Кирилл" else "Lotin")
        val adapter =
            ArrayAdapter(requireContext(), R.layout.item_spinner_locale, listOf("Lotin", "Кирилл"))
        bind.autoComplete.setAdapter(adapter)
        bind.autoComplete.setOnItemClickListener { parent, view, position, id ->
            getKoin().unloadModules(listOf(dataModule))
            getKoin().loadModules(listOf(dataModule))
            AppLocale.desiredLocale = AppLocale.supportedLocales[position]
            bind.toolbar.toolbarTitle.text = getString(R.string.settings)
            bind.text.text = getString(R.string.lorem)
        }

        bind.text.textSize = Settings.textSize
        bind.currentSize.text = Settings.textSize.toInt().toString()
        bind.increment.onClick {
            if (Settings.textSize < 40) {
                Settings.textSize += 2f
                bind.text.textSize = Settings.textSize
                bind.currentSize.text = Settings.textSize.toInt().toString()
            }
        }
        bind.decrement.onClick {
            if (Settings.textSize > 16) {
                Settings.textSize -= 2f
                bind.text.textSize = Settings.textSize
                bind.currentSize.text = Settings.textSize.toInt().toString()
            }
        }
        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }


}