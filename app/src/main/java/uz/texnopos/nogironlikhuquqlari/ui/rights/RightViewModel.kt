package uz.texnopos.mehrtilsimi.ui.rights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.texnopos.mehrtilsimi.data.dao.Dao
import uz.texnopos.mehrtilsimi.data.entities.Right

class RightViewModel(private val dao: Dao):ViewModel() {
    private var _rights= MutableLiveData<List<Right>>()
    val rights: LiveData<List<Right>> =_rights
    fun getAllRights(){
        _rights.value=dao.getAllRights()
    }
}