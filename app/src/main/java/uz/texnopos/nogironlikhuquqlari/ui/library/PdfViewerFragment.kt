package uz.texnopos.mehrtilsimi.ui.library

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.mehrtilsimi.R
import uz.texnopos.mehrtilsimi.databinding.FragmentPdfViewerBinding

class PdfViewerFragment:Fragment(R.layout.fragment_pdf_viewer) {
    private lateinit var bind:FragmentPdfViewerBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind= FragmentPdfViewerBinding.bind(view)
        navController=Navigation.findNavController(view)
        val bookName=arguments?.getString("book_name")
        bind.pdfView.fromAsset("$bookName.pdf").load()

        bind.pdfView.fromAsset("$bookName.pdf").onPageChange { page, pageCount ->

        }
    }
}