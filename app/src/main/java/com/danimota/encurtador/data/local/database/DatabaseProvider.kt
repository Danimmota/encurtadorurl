package com.danimota.encurtador.data.local.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var instance: AppDataBase? = null

    fun getInstance(context: Context): AppDataBase {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }

    private fun buildDatabase(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "encurtador_app.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
