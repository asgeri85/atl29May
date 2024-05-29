package net.asgeri.atl29may.api

import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) {

    suspend fun getProducts() = productService.getAllProducts()

}