package com.example.fordreams.UnivData

import androidx.annotation.StringRes

data class UnivInfo(
    @StringRes var universityName: Int,
    @StringRes var ownerShip: Int,
    @StringRes var estYear: Int,
    @StringRes var location: Int,
    @StringRes var website: Int
)
