package com.danimota.encurtador.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danimota.encurtador.data.local.entity.LinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLink(link: LinkEntity)

    @Query("SELECT * FROM links ORDER BY id DESC LIMIT 5")
    fun getAllLinks(): Flow<List<LinkEntity>>

}