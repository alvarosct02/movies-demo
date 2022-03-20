package com.alvarosct02.moviesdemo.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:isVisible")
fun View.isViewVisible(flag: Boolean) {
    this.isVisible = flag
}

@BindingAdapter("app:imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url?.isEmpty() == true) return
//    ImageUtils.loadImage(
//        url,
//        this,
//        this.context
//    )
}

@BindingAdapter("app:items")
fun <T> RecyclerView.setItems(items: List<T>?) {
    items?.let {
        (this.adapter as? ListAdapter<T, *>)?.submitList(items.toList())
    }
}
