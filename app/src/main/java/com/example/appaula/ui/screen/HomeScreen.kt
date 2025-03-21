package com.example.appaula.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appaula.ui.AppViewModelProvider
import com.example.appaula.ui.viewmodel.ClienteEntryViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
        Column(
            modifier = modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "App Cadastro",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace
                )
            }

            HorizontalDivider(thickness = 2.dp)

            ClienteEntryBody()
        }
}

@Composable
fun ClienteEntryBody(
    modifier: Modifier = Modifier,
    viewModel: ClienteEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            InputArea(
                value = viewModel.clienteState.nome,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(nome = it))
                },
                "Nome"
            )
            InputArea(
                value = viewModel.clienteState.endereco,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(endereco = it))
                },
                "Endereço"
            )
            InputArea(
                value = viewModel.clienteState.bairro,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(bairro = it))
                },
                "Bairro"
            )
            InputArea(
                value = viewModel.clienteState.cep,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(cep = it))
                },
                "CEP"
            )
            InputArea(
                value = viewModel.clienteState.cidade,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(cidade = it))
                },
                "Cidade"
            )
            InputArea(
                value = viewModel.clienteState.estado,
                onValueChange = {
                    viewModel.updateUiState(viewModel.clienteState.copy(estado = it))
                },
                "Estado"
            )
        }

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.saveCliente()
                }
            },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun InputArea(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        )
    )
}