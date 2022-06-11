package uz.texnopos.nogironlikhuquqlari.ui.reading

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.Constants.FOR_READ
import uz.texnopos.nogironlikhuquqlari.core.Constants.TOOLBAR_TITLE
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentForReadBinding
import uz.texnopos.nogironlikhuquqlari.ui.settings.Settings

class ForReadFragment : Fragment(R.layout.fragment_for_read) {

    private lateinit var bind: FragmentForReadBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentForReadBinding.bind(view)
        navController = Navigation.findNavController(view)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            bind.tvText.justificationMode = JUSTIFICATION_MODE_INTER_WORD
//        }
        val title = arguments?.getString(TOOLBAR_TITLE)
        val text = arguments?.getString(FOR_READ)
        val fromHtml = HtmlCompat.fromHtml(text!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
        bind.toolbar.toolbarTitle.text =
            if (title!!.length > 20) "${title.substring(0, 20)}..." else title
        bind.tvText.textSize = Settings.textSize
        bind.tvText.text = fromHtml
        bind.tvText.movementMethod = LinkMovementMethod.getInstance()

        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }
}