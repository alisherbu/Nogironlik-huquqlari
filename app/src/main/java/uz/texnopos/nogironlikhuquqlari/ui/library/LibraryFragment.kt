package uz.texnopos.nogironlikhuquqlari.ui.library

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.data.entities.Book
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment(R.layout.fragment_library) {
    private lateinit var bind: FragmentLibraryBinding
    private lateinit var navController: NavController
    private val adapter = LibraryAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentLibraryBinding.bind(view)
        navController = Navigation.findNavController(view)
        bind.rvBooks.setHasFixedSize(true)
        bind.rvBooks.adapter = adapter
        bind.toolbar.toolbarTitle.text = getString(R.string.books)
        setData()
        adapter.itemOnClick {
            val bundle = Bundle()
            bundle.putString("book_name", it)
            navController.navigate(R.id.action_libraryFragment_to_pdfViewerFragment, bundle)
        }
        bind.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }

    fun setData() {
        val books = mutableListOf<Book>()
        for (i in 1..8) {
            books.add(Book("book_$i"))
        }
        adapter.models = books
    }
}