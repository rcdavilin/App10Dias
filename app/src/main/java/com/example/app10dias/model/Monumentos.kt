package com.example.app10dias.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class Monumentos(
    @StringRes val monumentoTitulo: Int,
    @StringRes val monumentoInfo: Int,
    @DrawableRes val imageMonumento: Int,
    @DrawableRes val imageMonumento1: Int,
    @DrawableRes val imageMonumento2: Int

)