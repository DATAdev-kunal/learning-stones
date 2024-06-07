package com.example.blackcoffersampleapp.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackcoffersampleapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class SearchViewModel: ViewModel() {
	private val _searchText = MutableStateFlow("")
	val searchText = _searchText.asStateFlow()
	
	private val _isSearching = MutableStateFlow("")
	val isSearching = _isSearching.asStateFlow()
	
	private val _persons = MutableStateFlow(profiles)
	
	val persons = searchText
		.combine(_persons){text, persons ->
			if(text.isBlank()){
				persons
			}else{
				persons.filter {
					it.doesMatchSearchQuery(text)
				}
			}
		}
		.stateIn(
			viewModelScope,
			SharingStarted.WhileSubscribed(500),
			_persons.value
		)
	fun onSearchTextChange(text: String){
		_searchText.value = text
	}
}

data class Profile(
		@DrawableRes val imageResourceId: Int,
		@StringRes val name: Int,
		val age: Int,
		@StringRes val hobbies: Int,
		@StringRes val location: Int,
		@StringRes val profession: Int
){
	fun doesMatchSearchQuery(query: String): Boolean{
		val matchingCombinations = listOf(
			"$name"
		)
		return matchingCombinations.any{
			it.contains(query, ignoreCase = true)
		}
	}
}

val profiles = listOf(
	Profile(R.drawable.android, R.string.profile_name1, 51, R.string.profile_description1, R
		.string.profile_location1, R.string.profile_profession1),
	Profile(R.drawable.android, R.string.profile_name2, 36, R.string.profile_description2, R
		.string.profile_location2, R.string.profile_profession2),
	Profile(R.drawable.android, R.string.profile_name3, 24, R.string.profile_description3, R
		.string.profile_location3, R.string.profile_profession3),
	Profile(R.drawable.android, R.string.profile_name4, 18, R.string.profile_description4, R
		.string.profile_location4, R.string.profile_profession4),
	Profile(R.drawable.android, R.string.profile_name5, 28, R.string.profile_description5, R
		.string.profile_location5, R.string.profile_profession5),
	Profile(R.drawable.android, R.string.profile_name6, 44, R.string.profile_description6, R
		.string.profile_location6, R.string.profile_profession6),
	Profile(R.drawable.android, R.string.profile_name7, 38, R.string.profile_description7, R
		.string.profile_location7, R.string.profile_profession7),
	Profile(R.drawable.android, R.string.profile_name8, 29, R.string.profile_description8, R
		.string.profile_location8, R.string.profile_profession8),
	Profile(R.drawable.android, R.string.profile_name9, 23, R.string.profile_description9, R
		.string.profile_location9, R.string.profile_profession9)
)