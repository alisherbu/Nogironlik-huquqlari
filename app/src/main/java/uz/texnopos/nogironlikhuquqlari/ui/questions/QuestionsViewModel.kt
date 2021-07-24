package uz.texnopos.nogironlikhuquqlari.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Question

class QuestionsViewModel(private val dao: Dao): ViewModel() {

    private var mutableQuestions: MutableLiveData<List<Question>> = MutableLiveData()
    val questions: LiveData<List<Question>>
    get() = mutableQuestions

    fun getData(){
        mutableQuestions.value = dao.getAllQuestions()
    }
}