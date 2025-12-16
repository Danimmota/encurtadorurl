package com.danimota.encurtador.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danimota.encurtador.data.local.dao.LinkDAO
import com.danimota.encurtador.data.local.entity.LinkEntity

@Database(
    entities = [LinkEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun linkDAO(): LinkDAO
}