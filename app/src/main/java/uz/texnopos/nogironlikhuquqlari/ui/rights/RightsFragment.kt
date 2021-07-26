package uz.texnopos.nogironlikhuquqlari.ui.rights

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
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentRightsBinding

class RightsFragment : Fragment(R.layout.fragment_rights) {
    private lateinit var bind: FragmentRightsBinding
    private lateinit var navController: NavController
    private val adapter = RightsAdapter()
    private val viewModel by viewModel<RightViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentRightsBinding.bind(view)
        bind.toolbar.toolbarTitle.text=getString(R.string.rights)
        navController = Navigation.findNavController(view)
        bind.rvRights.adapter = adapter
        viewModel.getAllRights()
        viewModel.rights.observe(requireActivity(), {
            adapter.models = it
        })
        val bundle = Bundle()
        adapter.itemOnClick {
            bundle.putString(TOOLBAR_TITLE, it.title)
            if (it.id == 1) {
                navController.navigate(R.id.action_rightsFragment_to_legislationFragment,bundle)
            } else {
                bundle.putString(FOR_READ, it.text)
                navController.navigate(R.id.action_rightsFragment_to_forReadFragment, bundle)
            }
        }
        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }

}