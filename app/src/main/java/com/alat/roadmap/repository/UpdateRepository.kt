package com.alat.roadmap.repository



class UpdateRepository {

    fun sendPasswordUpdateRequest(email: String, newPassword: String): String {
        return try {
            "success"
        } catch (e: Exception) {
            "error"
        }
    }

}