package net.asgeri.atl29may.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.asgeri.atl29may.model.ProductResponse

@Dao
interface ProductDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProductLocal(productResponse: ProductResponse)

    @Query("SELECT * FROM table_product")
    suspend fun getLocalProducts(): List<ProductResponse>

}