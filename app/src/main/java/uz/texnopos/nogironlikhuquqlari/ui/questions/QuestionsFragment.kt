package uz.texnopos.mehrtilsimi.ui.questions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.texnopos.mehrtilsimi.R
import uz.texnopos.mehrtilsimi.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    private lateinit var binding: FragmentQuestionsBinding
    private val adapter: QuestionsAdapter = QuestionsAdapter()
    private val viewModel: QuestionsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuestionsBinding.bind(view)
        binding.rvQuestions.adapter = adapter
//        viewModel.getData()
    }

}
