package com.example.test5.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test5.common.IconType
import com.example.test5.common.NewCourse
import com.example.test5.databinding.ItemActiveCourseBinding
import com.example.test5.databinding.ItemNewCourseBinding

class NewCoursesRecyclerAdapter(private val newCourses: List<NewCourse>) :
    RecyclerView.Adapter<NewCoursesRecyclerAdapter.NewCoursesViewHolder>() {

    inner class NewCoursesViewHolder(private val binding: ItemNewCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val course = newCourses[adapterPosition]
            with(binding) {
                itemLayout.setBackgroundColor(Color.parseColor("#${course.mainColor}"))
                tvDuration.text = "${course.duration} min"
                tvTitle.text = course.title
                tvQuestion.text = course.question
                when (course.iconType) {
                    IconType.CARD -> iconCard.visibility = View.VISIBLE
                    IconType.SETTINGS -> iconSettings.visibility = View.VISIBLE
                    else -> {}
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCoursesViewHolder {
        return NewCoursesViewHolder(
            ItemNewCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = newCourses.size

    override fun onBindViewHolder(holder: NewCoursesViewHolder, position: Int) {
        holder.bind()
    }
}