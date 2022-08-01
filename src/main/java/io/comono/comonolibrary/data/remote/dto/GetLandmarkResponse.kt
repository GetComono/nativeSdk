package io.comono.comonolibrary.data.remote.dto

import kotlinx.serialization.Serializable

// GET LANDMARK IMAGES RESPONSE
@Serializable
data class GetLandmarkResponse(
    val status: String,
    val requestId: String,
    val message: String
)