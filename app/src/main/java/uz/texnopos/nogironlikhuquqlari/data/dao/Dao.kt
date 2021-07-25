package uz.texnopos.nogironlikhuquqlari.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.texnopos.nogironlikhuquqlari.data.entities.Author
import uz.texnopos.nogironlikhuquqlari.data.entities.Legislation
import uz.texnopos.nogironlikhuquqlari.data.entities.Question
import uz.texnopos.nogironlikhuquqlari.data.entities.Right

@Dao
interface Dao {

    @Query("SELECT * FROM savol_javoblar")
    fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM goya_muallifi")
    fun getAuthorInfo():List<Author>

    @Query("SELECT * FROM huquqlar")
    fun getAllRights():List<Right>

    @Query("SELECT * FROM qonunchilik_sohalari")
    fun getAllLegislation():List<Legislation>

}