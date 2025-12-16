package com.danimota.encurtador.data.remote.service

import com.danimota.encurtador.data.remote.model.ShortenRequest
import com.danimota.encurtador.data.remote.model.ShortenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("alias")
    suspend fun shortenUrl(@Body requestBody: ShortenRequest): ShortenResponse
}