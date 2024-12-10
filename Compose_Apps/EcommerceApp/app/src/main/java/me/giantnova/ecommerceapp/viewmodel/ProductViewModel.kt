package me.giantnova.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.giantnova.ecommerceapp.data.models.Product
import me.giantnova.ecommerceapp.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _currentPage = MutableStateFlow(1)
    private val currentPage: StateFlow<Int> = _currentPage.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Product>>(emptyList())
    val searchResults: StateFlow<List<Product>> = _searchResults.asStateFlow()

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()

    fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = productRepository.getProducts(currentPage.value)
            result.onSuccess { newProducts -> if (newProducts.isNotEmpty()) {
                _products.value += newProducts
                _currentPage.value++
            }
            }
            _isLoading.value = false
        }
    }

    fun searchProducts(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = productRepository.searchProducts(query)
            result.onSuccess { searchResults ->
                _searchResults.value = searchResults
            }
            _isLoading.value = false
        }
    }

    fun getProductDetails(productId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = productRepository.getProductDetails(productId)
            result.onSuccess { product ->
                _selectedProduct.value = product
            }
            _isLoading.value = false
        }
    }

    fun sortProducts(sortBy: SortType) {
        _products.value = when (sortBy) {
            SortType.PRICE_LOW_TO_HIGH -> _products.value.sortedBy { it.price }
            SortType.PRICE_HIGH_TO_LOW -> _products.value.sortedByDescending { it.price }
            SortType.RATING -> _products.value.sortedByDescending { it.rating.rate }
        }
    }

    enum class SortType {
        PRICE_LOW_TO_HIGH,
        PRICE_HIGH_TO_LOW,
        RATING
    }
}