package net.asgeri.atl29may.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.asgeri.atl29may.api.ProductRepository
import net.asgeri.atl29may.model.ProductResponse
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private var _data = MutableLiveData<List<ProductResponse>>()
    val data: LiveData<List<ProductResponse>> get() = _data

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading


    fun getData() {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = productRepository.getProducts()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()?.let {
                            if (it.isNotEmpty()) {
                                _data.value = it
                                _loading.value = false
                            }
                        }
                    }

                }
            } catch (e: Exception) {
                Log.e("xeta", e.localizedMessage.toString())
            }
        }
    }

    fun addProductLocal(productResponse: ProductResponse){
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.addProductLocal(productResponse)
        }
    }


}