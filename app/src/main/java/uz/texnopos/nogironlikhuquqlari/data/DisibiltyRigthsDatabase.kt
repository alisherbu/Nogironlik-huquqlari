package uz.texnopos.nogironlikhuquqlari.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.nogironlikhuquqlari.data.dao.Dao
import uz.texnopos.nogironlikhuquqlari.data.entities.Author
import uz.texnopos.nogironlikhuquqlari.data.entities.Question
import uz.texnopos.nogironlikhuquqlari.data.entities.Right

@Database(entities = [Question::class, Author::class, Right::class], version = 1)
abstract class
DisibiltyRigthsDatabase: RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: DisibiltyRigthsDatabase
        fun getInstance(context: Context) : DisibiltyRigthsDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, DisibiltyRigthsDatabase::class.java,
                    "latin.db")
                    .createFromAsset("latin.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

    abstract fun dao(): Dao
}