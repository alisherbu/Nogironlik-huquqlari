package uz.texnopos.nogironlikhuquqlari.ui.author

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentAuthorBinding


class AuthorFragment : Fragment(R.layout.fragment_author) {
    lateinit var bind: FragmentAuthorBinding
    lateinit var navController: NavController
    private val adapter = ExpandableAdapter()
    private val viewModel by viewModel<AuthorViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentAuthorBinding.bind(view)
        viewModel.getAuthorInfo()
        bind.toolbar.toolbarTitle.text=getString(R.string.about_owner)
        bind.recyclerView.adapter = adapter
        bind.recyclerView.setHasFixedSize(true)
        viewModel.authorInfo.observe(requireActivity(), {
            adapter.models = it
        })
        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }

}