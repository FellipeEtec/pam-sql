package com.example.appaula.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.appaula.data.model.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    // Unificação de Insert e Update (upsert)
//    @Upsert
//    suspend fun upsert(cliente: Cliente)

    // Funções com código SQL padrão
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cliente: Cliente)

    @Update
    suspend fun update(cliente: Cliente)

    @Delete
    suspend fun delete(cliente: Cliente)

    // Funções com código SQL customizado
    @Query("SELECT * from clientes WHERE id = :id")
    fun getCliente(id: Int): Flow<Cliente>

    @Query("SELECT * from clientes ORDER BY id ASC")
    fun getAllClientes(): Flow<List<Cliente>>
}
