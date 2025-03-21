package com.example.appaula

import android.app.Application
import com.example.appaula.data.AppContainer
import com.example.appaula.data.AppDataContainer

class EmpresaApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
