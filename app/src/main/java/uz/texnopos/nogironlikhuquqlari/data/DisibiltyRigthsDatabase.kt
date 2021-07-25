package uz.texnopos.nogironlikhuquqlari.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Author
import uz.texnopos.nogironlikhuquqlari.data.entities.Legislation
import uz.texnopos.nogironlikhuquqlari.data.entities.Question
import uz.texnopos.nogironlikhuquqlari.data.entities.Right

@Database(entities = [Question::class, Author::class, Right::class, Legislation::class], version = 2)
abstract class DisibiltyRigthsDatabase: RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: DisibiltyRigthsDatabase
        fun getInstance(context: Context) : DisibiltyRigthsDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, DisibiltyRigthsDatabase::class.java,
                    "latin2.db")
                    .createFromAsset("latin2.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

    abstract fun dao(): Dao
}