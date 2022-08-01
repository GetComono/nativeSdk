package io.comono.comonolibrary.data.remote.dto

import kotlinx.serialization.Serializable

// UPLOAD SELECTED LANDMARKS REQUEST
@Serializable
data class UploadHousesRequest(
    val requestId: String,
    val locationId: String
)