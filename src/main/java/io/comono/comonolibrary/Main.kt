package io.comono.comonolibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        val verifyButton = findViewById<Button>(R.id.verifyButton)

        suspend fun main() {
            verifyButton.setOnClickListener {
                val client = HttpClient(CIO) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }

                return@setOnClickListener try {
                    val response: HttpResponse =
                        client.post("https://sandbox.comono.io/api/AutoVerify/createnewautoapprequest") {
                            contentType(ContentType.Application.Json)
                            body = CreateNewRequest()
                        }
                    println(response.status)
                    client.close()
                } catch (e: RedirectResponseException) {
                    // 3xx - Responses
                    println("Error: ${e.response.status.description}")
                    null
                } catch (e: ClientRequestException) {
                    // 4xx - Responses
                    println("Error: ${e.response.status.description}")
                    null
                } catch (e: ServerResponseException) {
                    // 5xx - Responses
                    println("Error: ${e.response.status.description}")
                    null
                } catch (e: ServerResponseException) {
                    // Other Request Errors
                    println("Error: ${e.message}")
                    null
                } as Unit

                // Notification of successful Post request
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext, SecondActivity::class.java)
            }
        }
    }
}

@Serializable
data class CreateNewRequest(
    val workitemId: String? = "AO-095734358-ECO",
    val customerName: String? = "Tobi Balogun",
    val customerEmail: String? = "boluwatobi@gmail.com",
    val branchCode: String? = "A02",
    val segmentId: String? = "ADB",
    val address: String? = "pilot crescent",
    val landmark: String? = "Shoprite Surulere",
    val state: String? = "LG",
    val lga: String? = "694",
    val createdBy: String? = "RealMg",
    val customerImage: String? = "",
    val Latitude: String? = "0",
    val Longitude: String? = "0"
)