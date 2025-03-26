package com.example.calculadoradigital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mariuszgromada.math.mxparser.Expression

@Composable
fun CalcDigital(calculo: Calculo){
    var visor by remember {mutableStateOf("")}
    var resultado by remember { mutableStateOf("") }
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = 170.dp,bottom = 16.dp),
                text = "${calculo.visor}"
            )

            Text(
                modifier = Modifier.padding(start = 170.dp,bottom = 16.dp),
                text = "${calculo.resultado}"
            )

            Row {
                Button(onClick = {calculo.visor = "${calculo.visor}1"}) {
                    Text(text = "1")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}2"}) {
                    Text(text = "2")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}3"}) {
                    Text(text = "3")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}+"}) {
                    Text(text = "+")
                }
            }
            Row {
                Button(onClick = {calculo.visor = "${calculo.visor}4"}) {
                    Text(text = "4")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}5"}) {
                    Text(text = "5")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}6"}) {
                    Text(text = "6")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}-"}) {
                    Text(text = "-")
                }
            }
            Row {
                Button(onClick = {calculo.visor = "${calculo.visor}7"}) {
                    Text(text = "7")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}8"}) {
                    Text(text = "8")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}9"}) {
                    Text(text = "9")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}*"}) {
                    Text(text = "*")
                }
            }
            Row {
                Button(onClick = {
                    calculo.visor = ""
                    calculo.resultado = ""
                }) {
                    Text(text = "C")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}0"}) {
                    Text(text = "0")
                }
                Button(onClick = {
                    var resultadoFinal = Expression(calculo.visor).calculate()
                    calculo.resultado = resultadoFinal.toString()
                }) {
                    Text(text = "=")
                }
                Button(onClick = {calculo.visor = "${calculo.visor}/"}) {
                    Text(text = "/")
                }
            }

        }
    }

}


@Composable
fun CalcView(calculadora: Calculo, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalcDigital(calculadora)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CalcDigitalView() {
    val calculadora = Calculo("","")
    CalcView(calculadora)
}