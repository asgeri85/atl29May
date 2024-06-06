package net.asgeri.atl29may.api

import net.asgeri.atl29may.local.LocalDao
import net.asgeri.atl29may.model.local.WordEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService,
    val localDao: LocalDao
) {

    suspend fun getProducts() = productService.getAllProducts()

    fun addWordEntity(wordEntity: WordEntity) = localDao.addWord(wordEntity)

    suspend fun getLocalData() = localDao.getWords()

}