package com.example.app10dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Monumentos (
    @StringRes val monumentoTitulo: Int,
    @StringRes val monumentoInfo: Int,
    @DrawableRes val imageMonumento: Int
)