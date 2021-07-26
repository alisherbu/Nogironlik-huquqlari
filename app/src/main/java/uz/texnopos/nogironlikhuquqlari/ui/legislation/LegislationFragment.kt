package uz.texnopos.nogironlikhuquqlari.ui.legislation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.Constants.FOR_READ
import uz.texnopos.nogironlikhuquqlari.core.Constants.TOOLBAR_TITLE
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentLegislationBinding

class LegislationFragment : Fragment(R.layout.fragment_legislation) {

    private lateinit var binding: FragmentLegislationBinding
    private lateinit var navController: NavController
    private val adapter = LegislationAdapter()
    private val viewModel by viewModel<LegislationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLegislationBinding.bind(view)
        navController = Navigation.findNavController(view)
        binding.toolbar.toolbarTitle.text=arguments?.getString(TOOLBAR_TITLE)
        binding.rvLegislation.adapter = adapter
        viewModel.getData()
        viewModel.legislation.observe(requireActivity(), {
            adapter.models = it
        })
        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString(FOR_READ, it.text)
            bundle.putString(TOOLBAR_TITLE, it.year.toString())
            navController.navigate(R.id.action_legislationFragment_to_forReadFragment, bundle)
        }
        binding.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }
}