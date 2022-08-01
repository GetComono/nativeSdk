package io.comono.comonolibrary.data.remote.dto

import kotlinx.serialization.Serializable

// CREATE NEW REQUEST
@Serializable
data class VerificationRequest(
    val workitemId: String,
    val customerName: String,
    val customerEmail: String,
    val branchCode: String,
    val segmentId: String,
    val address: String,
    val landmark: String,
    val state: String,
    val lga: String,
    val createdBy: String,
    val customerImage: String,
    val Latitude: String,
    val Longitude: String
)