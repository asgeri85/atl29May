package net.asgeri.atl29may.api

import net.asgeri.atl29may.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductResponse>>

}