package br.com.chicorialabs.calculadoradenotas.ui.activity.model

class Calculador {

    fun verificaMedia(nota1: Double, nota2: Double): Boolean {
        val media = media(nota1, nota2)
        return media >= 6.0
    }

    fun media(nota1: Double, nota2: Double) = ((nota1 + nota2) / 2)

    fun verificaNumeroDeFaltas(faltas: Int): Boolean {
        return faltas <= 10
    }

    fun verificaNotaDeCorte(vararg notas: Double): Boolean {
        var resultado = true
        for(nota in notas){
            resultado = nota >= 5.0
        }
        return resultado
    }

    fun avalia(nota1: Double, nota2: Double, faltas: Int): Boolean {
        return verificaMedia(nota1, nota2) &&
                verificaNotaDeCorte(nota1, nota2) &&
                verificaNumeroDeFaltas(faltas)
    }



}