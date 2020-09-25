package com.alvarengadev.alvaflix.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.layoutHorizontal(): RecyclerView.LayoutManager {
    val layoutManagerHorizontal = LinearLayoutManager(context)
    layoutManagerHorizontal.orientation = LinearLayoutManager.HORIZONTAL
    return layoutManagerHorizontal
}