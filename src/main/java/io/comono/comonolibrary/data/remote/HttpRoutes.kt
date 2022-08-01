package io.comono.comonolibrary.data.remote

object HttpRoutes {
    private const val BASE_URL = "https://sandbox.comono.io"
    const val ENDPOINTONE = "$BASE_URL/api/AutoVerify/createnewautoapprequest"
    const val ENDPOINTTWO = "$BASE_URL/api/AutoVerify/GetLandmarkImages/Co-6295961"
    const val ENDPOINTTHREE = "$BASE_URL/api/AutoVerify/UploadSelectedLandmarks"
    const val ENDPOINTFOUR = "$BASE_URL/api/AutoVerify/GetHouseImages/Co-6295961"
    const val ENDPOINTFIVE = "$BASE_URL/api/AutoVerify/UploadSelectedHouses"
}