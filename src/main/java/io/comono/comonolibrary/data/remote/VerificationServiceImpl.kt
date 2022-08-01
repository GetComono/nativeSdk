package io.comono.comonolibrary.data.remote

import io.comono.comonolibrary.data.remote.dto.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class VerificationServiceImpl(
    private val client:HttpClient
) : VerificationService {
    override suspend fun createNewRequest(verificationRequest: VerificationRequest): VerificationResponse? {
        return try {
            client.post<VerificationResponse> {
                url(HttpRoutes.ENDPOINTONE)
                contentType(ContentType.Application.Json)
                body = verificationRequest
            }
        } catch(e: RedirectResponseException) {
            // 3xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // Other Request Errors
            println("Error: ${e.message}")
            null
        }
    }

    override suspend fun getLandmarkImages(): List<GetLandmarkResponse> {
        return try {
            client.get {
                url(HttpRoutes.ENDPOINTTWO)
                contentType(ContentType.Application.Json)
                body = GetLandmarkResponse
            }
        } catch(e: RedirectResponseException) {
            // 3xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // Other Request Errors
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun uploadSelectedLandmarks(uploadLandmarkRequest: UploadLandmarkRequest): UploadLandmarkResponse? {
        return try {
            client.post {
                url(HttpRoutes.ENDPOINTTHREE)
                contentType(ContentType.Application.Json)
                body = uploadLandmarkRequest
            }
        } catch(e: RedirectResponseException) {
            // 3xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // Other Request Errors
            println("Error: ${e.message}")
            null
        }
    }

    override suspend fun getHouseImages(): List<GetHousesResponse> {
        return try {
            client.get {
                url(HttpRoutes.ENDPOINTFOUR)
                contentType(ContentType.Application.Json)
                body = GetHousesResponse
            }
        } catch(e: RedirectResponseException) {
            // 3xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - Responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // Other Request Errors
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun uploadSelectedHouses(uploadHousesRequest: UploadHousesRequest): UploadHousesResponse? {
        return try {
            client.post {
                url(HttpRoutes.ENDPOINTFIVE)
                contentType(ContentType.Application.Json)
                body = uploadHousesRequest
            }
        } catch(e: RedirectResponseException) {
            // 3xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx - Responses
            println("Error: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // Other Request Errors
            println("Error: ${e.message}")
            null
        }
    }
}