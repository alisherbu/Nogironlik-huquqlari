package uz.texnopos.nogironlikhuquqlari.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        navController = Navigation.findNavController(view)



        binding.btnIdeaAuthor.setOnClickListener {
            try {
                navController.navigate(R.id.action_mainFragment_to_authorFragment)
            } catch (e: Exception) {
            }
        }

        binding.btnRights.setOnClickListener {
            try {
                navController.navigate(R.id.action_mainFragment_to_rightsFragment)
            } catch (e: Exception) {
            }
        }

        binding.btnQuestions.setOnClickListener {
            try {
                navController.navigate(R.id.action_mainFragment_to_questionsFragment)
            } catch (e: Exception) {
            }
        }

        binding.btnLibrary.setOnClickListener {
            try {
                navController.navigate(R.id.action_mainFragment_to_libraryFragment)
            } catch (e: Exception) {
            }
        }

        binding.btnSettings.setOnClickListener {
            try {
                navController.navigate(R.id.action_mainFragment_to_settingsFragment)
            } catch (e: Exception) {
            }
        }

        binding.btnGoToSite.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://mehrtilsimi.blogspot.com/"))
            try {
                startActivity(intent)
            } catch (e: Exception) {
            }
        }

    }

}