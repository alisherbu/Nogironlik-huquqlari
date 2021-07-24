package uz.texnopos.nogironlikhuquqlari.ui.rights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Right

class RightViewModel(private val dao: Dao):ViewModel() {
    private var _rights= MutableLiveData<List<Right>>()
    val rights: LiveData<List<Right>> =_rights
    fun getAllRights(){
        _rights.value=dao.getAllRights()
    }
}