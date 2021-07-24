package uz.texnopos.mehrtilsimi.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.texnopos.mehrtilsimi.data.dao.Dao
import uz.texnopos.mehrtilsimi.data.entities.Author

class AuthorViewModel(private val dao:Dao):ViewModel() {

    private var _authorInfo=MutableLiveData<List<Author>>()
    val authorInfo:LiveData<List<Author>> =_authorInfo
    fun getAuthorInfo(){
        _authorInfo.value=dao.getAuthorInfo()
    }
}