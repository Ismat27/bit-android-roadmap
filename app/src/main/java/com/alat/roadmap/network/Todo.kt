package com.alat.roadmap.network

data class Todo(
    val userId: Int,
    val id: String,
    val title: String,
    val completed: Boolean
)
