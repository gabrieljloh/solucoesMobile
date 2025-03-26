package com.example.calculadoradigital

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Calculo(
    visor: String,
    resultado: String

) {
    var visor by mutableStateOf(visor)
    var resultado by mutableStateOf(resultado)
}