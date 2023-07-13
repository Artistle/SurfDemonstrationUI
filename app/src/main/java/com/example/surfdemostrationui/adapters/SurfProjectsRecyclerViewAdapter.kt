package com.example.surfdemostrationui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surfdemostrationui.SurfProjectTeamItemDecorator
import com.example.surfdemostrationui.databinding.SurfProjectItemBinding
import kotlin.random.Random

class SurfProjectsRecyclerViewAdapter: RecyclerView.Adapter<SurfProjectsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SurfProjectItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class ViewHolder(private val binding: SurfProjectItemBinding): RecyclerView.ViewHolder(binding.root) {

        private val randomCountEmployee = Random.nextInt(0,10)
        private val listEmployee = arrayListOf<Int>()


        fun bind() {
            for (n in 1..randomCountEmployee) {
                listEmployee.add(n)
            }
            val adapter = SurfProjectTeamRecyclerViewAdapter(listEmployee)
            binding.recyclerView.addItemDecoration(SurfProjectTeamItemDecorator())
            binding.recyclerView.adapter = adapter
        }
    }
}