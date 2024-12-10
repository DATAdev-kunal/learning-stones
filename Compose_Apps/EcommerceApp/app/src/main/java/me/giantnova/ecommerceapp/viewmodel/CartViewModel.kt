package me.giantnova.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import me.giantnova.ecommerceapp.data.models.CartItem
import me.giantnova.ecommerceapp.data.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    private val _totalPrice = MutableStateFlow(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice.asStateFlow()

    fun addToCart(product: Product) {
        val existingItem = _cartItems.value.find { it.product.id == product.id }

        if (existingItem != null) {
            _cartItems.update { currentItems ->
                currentItems.map {
                    if (it.product.id == product.id)
                        it.copy(quantity = it.quantity + 1)
                    else
                        it
                }
            }
        } else {
            _cartItems.update { it + CartItem(product) }
        }
        calculateTotalPrice()
    }

    fun removeFromCart(product: Product) {
        _cartItems.update { currentItems ->
            currentItems.filter { it.product.id != product.id }
        }
        calculateTotalPrice()
    }

    fun updateQuantity(product: Product, quantity: Int) {
        _cartItems.update { currentItems ->
            currentItems.map {
                if (it.product.id == product.id)
                    it.copy(quantity = quantity)
                else
                    it
            }
        }
        calculateTotalPrice()
    }

    private fun calculateTotalPrice() {
        _totalPrice.value = _cartItems.value.sumOf {
            it.product.price * it.quantity
        }
    }

    fun clearCart() {
        _cartItems.value = emptyList()
        _totalPrice.value = 0.0
    }
}