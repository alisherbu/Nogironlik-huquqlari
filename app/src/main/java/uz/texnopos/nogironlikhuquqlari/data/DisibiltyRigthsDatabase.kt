package uz.texnopos.nogironlikhuquqlari.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.nogironlikhuquqlari.R
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
            Log.d("database","database calling")
//            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, DisibiltyRigthsDatabase::class.java,
                    context.getString(R.string.database))
                    .createFromAsset(context.getString(R.string.database))
                    .build()
//            }
            return INSTANCE
        }
    }

    abstract fun dao(): Dao
}