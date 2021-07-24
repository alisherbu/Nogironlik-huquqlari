package uz.texnopos.mehrtilsimi.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.texnopos.mehrtilsimi.data.dao.Dao
import uz.texnopos.mehrtilsimi.data.entities.Question

class QuestionsViewModel(private val dao: Dao): ViewModel() {

    private var mutableQuestions: MutableLiveData<List<Question>> = MutableLiveData()
    val questions: LiveData<List<Question>>
    get() = mutableQuestions

    fun getData(){
        mutableQuestions.value = dao.getAllQuestions()
    }
}