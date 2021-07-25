package uz.texnopos.nogironlikhuquqlari.ui.questions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    private lateinit var binding: FragmentQuestionsBinding
    private val adapter: QuestionsAdapter = QuestionsAdapter()
    private val viewModel: QuestionsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuestionsBinding.bind(view)
        binding.toolbar.toolbarTitle.text=getString(R.string.questions)
        binding.rvQuestions.adapter = adapter

//        viewModel.getData()

        binding.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }

}
