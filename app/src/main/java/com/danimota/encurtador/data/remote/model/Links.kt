package com.danimota.encurtador.data.remote.model

import com.google.gson.annotations.SerializedName

class Links (
    @SerializedName("self")
    val self: String,

    @SerializedName("short")
    val short: String
)

