package com.example.surfdemostrationui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.surfdemostrationui.databinding.SurfProjectTeamEtcBinding
import com.example.surfdemostrationui.databinding.SurfProjectsTeamEmptyItemBinding
import com.example.surfdemostrationui.databinding.SurfProjectsTeamItemBinding

class SurfProjectTeamRecyclerViewAdapter(
    private val employeeList: ArrayList<Int> = arrayListOf()
) :
    RecyclerView.Adapter<SurfProjectTeamViewHolder>() {
    private val countShowEmployee: Int = 3


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurfProjectTeamViewHolder {
        val binding = SurfProjectsTeamItemBinding.inflate(LayoutInflater.from(parent.context))

        return when(viewType) {
            0 -> {
                SurfProjectTeamViewHolder.ViewHolderEmployeeEmpty(
                    SurfProjectsTeamEmptyItemBinding.inflate(LayoutInflater.from(parent.context))
                )
            }

            1 -> {
                SurfProjectTeamViewHolder.ViewHolderEmployeeCount(
                    SurfProjectTeamEtcBinding.inflate(LayoutInflater.from(parent.context))
                )
            }

            else -> {
                SurfProjectTeamViewHolder.ViewHolderEmployee(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (employeeList.isEmpty()) {
            return 0
        } else if (position == countShowEmployee) {
            return 1
        }
        return 2
    }

    override fun getItemCount(): Int {
        if (employeeList.size > 4) {
            return 4
        } else if (employeeList.isEmpty()) {
            return 1
        }
        return employeeList.size
    }
    override fun onBindViewHolder(holder: SurfProjectTeamViewHolder, position: Int) {
        if (holder is SurfProjectTeamViewHolder.ViewHolderEmployeeCount) {
            holder.bind(employeeList.size - countShowEmployee)
        }
    }
}

sealed class SurfProjectTeamViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    class ViewHolderEmployee(private val binding: SurfProjectsTeamItemBinding) : SurfProjectTeamViewHolder(binding)
    class ViewHolderEmployeeCount(private val binding: SurfProjectTeamEtcBinding) : SurfProjectTeamViewHolder(binding) {

        fun bind(count: Int) {
            binding.projectCountEmployee.text = "+$count"
        }
    }
    class ViewHolderEmployeeEmpty(private val binding: SurfProjectsTeamEmptyItemBinding) : SurfProjectTeamViewHolder(binding)
}