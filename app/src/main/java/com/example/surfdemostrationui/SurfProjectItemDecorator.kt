package com.example.surfdemostrationui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SurfProjectItemDecorator : RecyclerView.ItemDecoration() {

    private val space = 30

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        outRect.top = space
    }
}