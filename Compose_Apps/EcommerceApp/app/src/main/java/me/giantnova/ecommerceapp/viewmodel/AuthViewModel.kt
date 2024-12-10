package me.giantnova.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.giantnova.ecommerceapp.data.models.User
import me.giantnova.ecommerceapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = userRepository.login(username, password)
            result.onSuccess { user ->
                _isLoggedIn.value = true
                _currentUser.value = user
                _loginError.value = null
            }.onFailure {
                _isLoggedIn.value = false
                _loginError.value = "Login failed. Please check your credentials."
            }
        }
    }

    fun register(user: User) {
        viewModelScope.launch {
            val result = userRepository.register(user)
            result.onSuccess { registeredUser ->
                _isLoggedIn.value = true
                _currentUser.value = registeredUser
                _loginError.value = null
            }.onFailure {
                _loginError.value = "Registration failed. Please try again."
            }
        }
    }

    fun logout() {
        _isLoggedIn.value = false
        _currentUser.value = null
    }
}