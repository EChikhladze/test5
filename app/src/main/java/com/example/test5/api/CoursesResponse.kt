package com.example.test5.api

import com.example.test5.common.ActiveCourse
import com.example.test5.common.NewCourse
import com.squareup.moshi.Json

data class CoursesResponse(
    @Json(name = "new_courses") val newCourses: List<NewCourse>,
    @Json(name = "active_courses") val activeCourses: List<ActiveCourse>
)
