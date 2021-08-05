package uz.texnopos.nogironlikhuquqlari.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dev.b3nedikt.app_locale.AppLocale
import org.koin.android.ext.android.getKoin
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentSplashBinding
import uz.texnopos.nogironlikhuquqlari.di.dataModule
import uz.texnopos.nogironlikhuquqlari.ui.settings.Settings

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var bind: FragmentSplashBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        bind = FragmentSplashBinding.bind(view)
        val anim1 = AnimationUtils.loadAnimation(requireContext(), R.anim.alpha_from_out2)
        val anim2 = AnimationUtils.loadAnimation(requireContext(), R.anim.alpha_from_out2)
        anim1.startOffset = 800
        bind.image.animation = anim1

        bind.latinCard.onClick {
            try {
                setLocale(0)
            } catch (e: Exception) {
            }
        }
        bind.kirillCard.onClick {
            try {
                setLocale(1)
            } catch (e: Exception) {
            }
        }
            bind.root.postDelayed({
                if (Settings.firstLaunched){
                    bind.locale.visibility = View.VISIBLE
                    bind.locale.animation = anim2
                }
               else navController.navigate(R.id.action_splashFragment_to_mainFragment)
            }, 2000)
    }

    private fun setLocale(position: Int) {
        getKoin().unloadModules(listOf(dataModule))
        getKoin().loadModules(listOf(dataModule))
        AppLocale.desiredLocale = AppLocale.supportedLocales[position]
        Settings.firstLaunched = false
        navController.navigate(R.id.action_splashFragment_to_mainFragment)
    }
}