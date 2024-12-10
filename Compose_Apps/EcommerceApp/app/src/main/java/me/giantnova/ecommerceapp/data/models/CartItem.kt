package me.giantnova.ecommerceapp.data.models

data class CartItem(
    val product: Product,
    var quantity: Int = 1
)