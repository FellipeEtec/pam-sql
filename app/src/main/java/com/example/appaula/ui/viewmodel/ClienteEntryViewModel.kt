package com.example.appaula.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appaula.data.model.ClienteState
import com.example.appaula.data.model.toCliente
import com.example.appaula.data.repository.ClientesRepository

class ClienteEntryViewModel(private val clientesRepository: ClientesRepository) : ViewModel() {
    var clienteState by mutableStateOf(ClienteState())
        private set

    fun updateUiState(clienteUiState: ClienteState) {
        clienteState = clienteUiState
    }

    suspend fun saveCliente() {
        clientesRepository.insertCliente(clienteState.toCliente())
    }
}
