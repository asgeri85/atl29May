package net.asgeri.atl29may.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import net.asgeri.atl29may.api.ProductRepository
import net.asgeri.atl29may.model.ProductResponse
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    val favoriteList = MutableLiveData<List<ProductResponse>>()

    fun getLocalProducts() {
        viewModelScope.launch {
            productRepository.getAllLocalProducts().collectLatest { data ->
                favoriteList.value = data
            }
        }
    }
}