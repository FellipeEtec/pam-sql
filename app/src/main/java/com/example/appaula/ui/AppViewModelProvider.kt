package com.example.appaula.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appaula.EmpresaApplication
import com.example.appaula.ui.viewmodel.ClienteEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ClienteEntryViewModel(empresaApplication().container.clientesRepository)
        }
    }
}

fun CreationExtras.empresaApplication(): EmpresaApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as EmpresaApplication)
