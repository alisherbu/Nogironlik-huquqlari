package uz.texnopos.mehrtilsimi.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.mehrtilsimi.R
import uz.texnopos.mehrtilsimi.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding.btnIdeaAuthor.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_authorFragment)
        }

        binding.btnRights.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_rightsFragment)
        }

        binding.btnQuestions.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_questionsFragment)
        }

        binding.btnLibrary.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_libraryFragment)
        }

        binding.btnSettings.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_settingsFragment)
        }


        binding.btnGoToSite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mehrtilsimi.blogspot.com/"))
            startActivity(intent)
        }
    }

}