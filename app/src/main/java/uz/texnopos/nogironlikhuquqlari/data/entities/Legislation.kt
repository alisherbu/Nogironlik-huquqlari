package uz.texnopos.nogironlikhuquqlari.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qonunchilik_sohalari")
data class Legislation(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "year") var year: String,
    @ColumnInfo(name = "text") var text: String
)