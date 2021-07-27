package uz.texnopos.nogironlikhuquqlari.ui.legislation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Legislation

class LegislationViewModel(private val dao: Dao): ViewModel() {

    private var mutableLegislation: MutableLiveData<List<Legislation>> = MutableLiveData()
    val legislation: LiveData<List<Legislation>> get() = mutableLegislation

    fun getData(){
        CoroutineScope(Dispatchers.Main).launch {
            mutableLegislation.value= withContext(Dispatchers.IO){ dao.getAllLegislation()}
        }
    }

}