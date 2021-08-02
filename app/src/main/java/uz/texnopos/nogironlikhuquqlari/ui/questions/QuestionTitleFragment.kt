package uz.texnopos.nogironlikhuquqlari.ui.questions

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
import uz.texnopos.nogironlikhuquqlari.databinding.FragmentQuestionTitleBinding

class QuestionTitleFragment : Fragment(R.layout.fragment_question_title) {

    private lateinit var binding: FragmentQuestionTitleBinding
    private val adapter: QuestionsAdapter = QuestionsAdapter()
    private val viewModel: QuestionsViewModel by viewModel()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuestionTitleBinding.bind(view)
        navController = Navigation.findNavController(view)
        binding.rvQuestions.adapter = adapter
        binding.toolbar.toolbarTitle.text = getString(R.string.questions)
        viewModel.questions.observe(requireActivity(), {
            adapter.models = it
        })

        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString(FOR_READ, it.text)
            bundle.putString(TOOLBAR_TITLE, it.title)
            navController.navigate(R.id.action_questionsFragment_to_forReadFragment, bundle)
        }
        binding.toolbar.back.onClick {
            requireActivity().onBackPressed()
        }
    }
}