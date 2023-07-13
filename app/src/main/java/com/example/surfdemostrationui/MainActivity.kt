package com.example.surfdemostrationui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.example.surfdemostrationui.adapters.SurfProjectsRecyclerViewAdapter
import com.example.surfdemostrationui.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding by Delegates.notNull()
    private val isError: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.run {
            toolbar.textViewHello.text = getString(R.string.hello_emoji, "Никита")
            projectsRecyclerView.isVisible = !isError
            errorLayout.root.isVisible = isError
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.let {
            it.projectsRecyclerView.adapter = SurfProjectsRecyclerViewAdapter()
            it.projectsRecyclerView.addItemDecoration(SurfProjectItemDecorator())
        }
    }
}