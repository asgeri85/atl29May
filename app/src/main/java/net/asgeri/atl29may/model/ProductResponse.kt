package net.asgeri.atl29may.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_product")
data class ProductResponse(
    @SerializedName("creationAt")
    val creationAt: String,
    @SerializedName("description")
    val description: String,
    @PrimaryKey
    @ColumnInfo("product_id")
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)