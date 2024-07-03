package net.asgeri.atl29may.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import net.asgeri.atl29may.local.ProductDAO
import net.asgeri.atl29may.model.ProductResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService,
    private val productDAO: ProductDAO
) {

    suspend fun getProducts() = productService.getAllProducts()

    fun addProductLocal(productResponse: ProductResponse) =
        productDAO.addProductLocal(productResponse)

    suspend fun getAllLocalProducts() = flow {
        try {
            val response = productDAO.getLocalProducts()

            emit(response)
        } catch (e: Exception) {
            Log.e("xeta", e.localizedMessage.toString())
        }
    }.flowOn(Dispatchers.IO)
}