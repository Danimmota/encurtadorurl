package com.danimota.encurtador.data.remote.model

import com.google.gson.annotations.SerializedName

data class ShortenResponse(
    @SerializedName("alias")
    val alias: String,

    @SerializedName("_links")
    val links: Links
)