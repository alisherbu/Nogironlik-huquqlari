package uz.texnopos.nogironlikhuquqlari.ui.rights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Right

class RightViewModel(private val dao: Dao):ViewModel() {
    private var _rights:MutableLiveData<List<Right>> = MutableLiveData()
    val rights: LiveData<List<Right>> =_rights
    fun getAllRights(){
        CoroutineScope(Dispatchers.Main).launch {
            _rights.value= withContext(Dispatchers.IO){ dao.getAllRights() }
        }
    }
}