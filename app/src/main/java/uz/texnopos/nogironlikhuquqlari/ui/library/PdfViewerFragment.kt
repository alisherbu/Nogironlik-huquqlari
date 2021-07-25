package uz.texnopos.nogironlikhuquqlari.ui.library

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.shockwave.pdfium.PdfDocument.Bookmark
import com.shockwave.pdfium.PdfDocument.Meta
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentPdfViewerBinding

class PdfViewerFragment : Fragment(R.layout.fragment_pdf_viewer),
    OnPageChangeListener, OnLoadCompleteListener {
    private lateinit var bind: FragmentPdfViewerBinding
    private lateinit var navController: NavController
    private val TAG = "simple_name"
    var pageNumber = 0
    private lateinit var bookName: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentPdfViewerBinding.bind(view)
        navController = Navigation.findNavController(view)
        bookName = arguments?.getString("book_name")!!
        bind.pdfView.fromAsset("$bookName.pdf")
            .defaultPage(pageNumber)
            .onPageChange(this)
            .enableAnnotationRendering(true)
            .onLoad(this)
            .scrollHandle(DefaultScrollHandle(requireContext()))
            .load();

    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber = page
        bind.tvTitle.text = String.format("%s / %s", page + 1, pageCount)
    }

    override fun loadComplete(nbPages: Int) {
        val meta: Meta = bind.pdfView.documentMeta
        Log.e(TAG, "title = " + meta.title)
        Log.e(TAG, "author = " + meta.author)
        Log.e(TAG, "subject = " + meta.subject)
        Log.e(TAG, "keywords = " + meta.keywords)
        Log.e(TAG, "creator = " + meta.creator)
        Log.e(TAG, "producer = " + meta.producer)
        Log.e(TAG, "creationDate = " + meta.creationDate)
        Log.e(TAG, "modDate = " + meta.modDate)

        printBookmarksTree(bind.pdfView.tableOfContents, "-")
    }

    private fun printBookmarksTree(tree: List<Bookmark>, sep: String) {
        for (b in tree) {
            Log.e(TAG, String.format("%s %s, p %d", sep, b.title, b.pageIdx))
            if (b.hasChildren()) printBookmarksTree(b.children, "$sep-")
        }
    }
}