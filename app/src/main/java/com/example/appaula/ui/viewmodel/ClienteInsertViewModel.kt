package com.example.appaula.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appaula.data.model.ClienteState
import com.example.appaula.data.model.toCliente
import com.example.appaula.data.repository.ClientesRepository

class ClienteInsertViewModel(private val clientesRepository: ClientesRepository) : ViewModel() {
    var clienteState by mutableStateOf(ClienteState())
        private set

    fun updateUiState(clienteUiState: ClienteState) {
        clienteState = clienteUiState
    }

    suspend fun saveCliente(): Boolean {
        if (!verifySaveable()) {
            return false
        }

        clientesRepository.insertCliente(clienteState.toCliente())
        return true
    }

    fun verifySaveable(): Boolean {
        return clienteState.nome !== ""
    }
}
