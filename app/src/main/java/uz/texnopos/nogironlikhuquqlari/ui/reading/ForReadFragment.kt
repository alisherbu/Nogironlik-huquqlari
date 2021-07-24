package uz.texnopos.nogironlikhuquqlari.ui.reading

import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentForReadBinding

class ForReadFragment : Fragment(R.layout.fragment_for_read) {
    private lateinit var bind: FragmentForReadBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentForReadBinding.bind(view)
        navController = Navigation.findNavController(view)
        val title = arguments?.getString("toolbar_title")
        val text = arguments?.getString("for_read")
        bind.tvTitle.text = if (title!!.length > 20) "${title.substring(0, 20)}..." else title
        bind.tvText.text = HtmlCompat.fromHtml(text!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}