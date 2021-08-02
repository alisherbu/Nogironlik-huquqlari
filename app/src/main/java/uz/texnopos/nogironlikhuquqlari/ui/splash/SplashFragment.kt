package uz.texnopos.nogironlikhuquqlari.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var bind: FragmentSplashBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        bind = FragmentSplashBinding.bind(view)
        val anim=AnimationUtils.loadAnimation(requireContext(),R.anim.alpha_from_out)
        anim.startOffset=800
        anim.duration=1000
        bind.image.animation=anim
        bind.root.postDelayed({
          navController.navigate(R.id.action_splashFragment_to_mainFragment)
        },2000)
    }
}