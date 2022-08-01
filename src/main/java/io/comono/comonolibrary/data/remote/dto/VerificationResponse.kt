package io.comono.comonolibrary.data.remote.dto

import kotlinx.serialization.Serializable

// CREATE NEW REQUEST RESPONSE
@Serializable
data class VerificationResponse(
    val status: String,
    val requestId: String,
    val message: String
)