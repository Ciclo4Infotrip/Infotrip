package com.karendamore.jardin.data

import com.karendamore.jardin.model.Jardin
import retrofit2.http.GET

interface ApiService {

    @GET("Ciclo4Infotrip/Infotrip/jardin")
    suspend fun getJardin(): Jardin

}