package me.giantnova.ecommerceapp.data.models

data class User(
    val id: Int? = null,
    val email: String,
    val username: String,
    val password: String,
    val name: Name? = null,
    val address: Address? = null,
    val phone: String? = null
)

data class Name(
    val firstname: String,
    val lastname: String
)

data class Address(
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String,
    val geolocation: GeoLocation
)

data class GeoLocation(
    val lat: String,
    val long: String
)