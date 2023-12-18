package com.example.test5.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test5.api.CoursesResponse
import com.example.test5.databinding.ItemActiveCourseBinding

class ActiveCoursesRecyclerAdapter(private val courses: CoursesResponse) :
    RecyclerView.Adapter<ActiveCoursesRecyclerAdapter.ActiveCoursesViewHolder>() {

    private var isNewCoursesRecyclerSetUp = false

    inner class ActiveCoursesViewHolder(private val binding: ItemActiveCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            if (!isNewCoursesRecyclerSetUp) {
                with(binding.recyclerNewCourses) {
                    visibility = View.VISIBLE
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = NewCoursesRecyclerAdapter(courses.newCourses)
                }
                isNewCoursesRecyclerSetUp = true
            } else {
                with(binding) {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCoursesViewHolder {
        return ActiveCoursesViewHolder(
            ItemActiveCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = courses.activeCourses.size

    override fun onBindViewHolder(holder: ActiveCoursesViewHolder, position: Int) {
        holder.bind()
    }
}