package uz.texnopos.nogironlikhuquqlari.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Author

class AuthorViewModel(private val dao: Dao):ViewModel() {

    private var _authorInfo:MutableLiveData<List<Author>> =MutableLiveData()
    val authorInfo:LiveData<List<Author>> get() =_authorInfo
    fun getAuthorInfo(){
        CoroutineScope(Dispatchers.Main).launch {
            _authorInfo.value= withContext(Dispatchers.IO) { dao.getAuthorInfo() }
        }
    }
}