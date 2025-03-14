package com.example.appaula.data

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

@Database(entities = [Cliente::class], version = 1, exportSchema = false)
abstract class EmpresaDatabase : RoomDatabase() {
    abstract fun clientDao(): ClienteDao

    companion object {
        @Volatile
        private var Instance: EmpresaDatabase? = null

        fun getDatabase(context: Context): EmpresaDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, EmpresaDatabase::class.java, "empresa")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
