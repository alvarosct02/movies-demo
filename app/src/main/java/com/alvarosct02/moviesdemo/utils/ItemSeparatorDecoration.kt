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
        val position: Int = parent.getChildAdapterPosition(view)
        val isLastItem = parent.adapter?.let { it.itemCount - 1 == position } ?: false

        (parent.layoutManager as? LinearLayoutManager)?.let {
            if (it.orientation == LinearLayoutManager.HORIZONTAL) {
                if (!isLastItem) {
                    outRect.right = middleSpacePx
                }
            }
        }
    }
}
