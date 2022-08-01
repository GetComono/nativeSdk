package io.comono.comonolibrary.data.remote

import io.comono.comonolibrary.data.remote.dto.*
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

// API SERVICES
interface VerificationService {

    suspend fun createNewRequest(verificationRequest: VerificationRequest): VerificationResponse?

    suspend fun getLandmarkImages(): List<GetLandmarkResponse>

    suspend fun uploadSelectedLandmarks(uploadLandmarkRequest: UploadLandmarkRequest): UploadLandmarkResponse?

    suspend fun getHouseImages(): List<GetHousesResponse>

    suspend fun uploadSelectedHouses(uploadHousesRequest: UploadHousesRequest): UploadHousesResponse?

    companion object {
        fun create(): VerificationService {
            return VerificationServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}