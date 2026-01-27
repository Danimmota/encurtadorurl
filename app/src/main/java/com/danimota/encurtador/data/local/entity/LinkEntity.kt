package com.danimota.encurtador.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "links")
data class LinkEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val alias: String,
    val originalUrl: String,
    val shortUrl: String,
    val createdAt: Long

)