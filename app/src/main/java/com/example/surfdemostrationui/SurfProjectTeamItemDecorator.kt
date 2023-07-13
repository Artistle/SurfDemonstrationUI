package com.example.surfdemostrationui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SurfProjectTeamItemDecorator : RecyclerView.ItemDecoration() {

    private val offsetLeft: Int = -30

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        for (n in 1..parent.childCount) {
            if (n > 1) {
                outRect.set(offsetLeft, 0, 0, 0)
            }
        }
    }
}