package com.alvarosct02.moviesdemo.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ItemSeparatorDecoration(
    private val middleSpacePx: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        (parent.layoutManager as? LinearLayoutManager)?.let {
            if (it.orientation == LinearLayoutManager.HORIZONTAL) {
                outRect.right = middleSpacePx
            }
        }
    }
}
