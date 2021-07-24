package uz.texnopos.mehrtilsimi.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.texnopos.mehrtilsimi.data.entities.Author
import uz.texnopos.mehrtilsimi.data.entities.Question
import uz.texnopos.mehrtilsimi.data.entities.Right

@Dao
interface Dao {
    @Query("SELECT * FROM savol_javoblar")
    fun getAllQuestions(): List<Question>
    @Query("SELECT * FROM goya_muallifi")
    fun getAuthorInfo():List<Author>
    @Query("SELECT * FROM huquqlar")
    fun getAllRights():List<Right>
}