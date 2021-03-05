package br.com.chicorialabs.calculadoradenotas.ui.activity.model

import org.junit.Assert.*
import org.junit.Test

class CalculadorTest{

    val calculador = Calculador()

    @Test
    fun deve_RetornarTrue_QuandoRecebeNotasAcimaDaNotaDeCorte(){

        val resultado = calculador.verificaNotaDeCorte(5.0, 6.0)

        println(resultado)
        assertTrue(resultado)

    }

    @Test
    fun deve_RetornarFalse_QuandoRecebeDuasNotasAbaixoDaNotaDeCorte(){

        val resultado = calculador.verificaNotaDeCorte(4.0, 3.0)

        println(resultado)
        assertFalse(resultado)

    }

    @Test
    fun deve_RetornarFalse_QuandoRecebeUmaNotaAbaixoDaNotaDeCorte(){

        val resultado = calculador.verificaNotaDeCorte(10.0, 3.0)

        println(resultado)
        assertFalse(resultado)

    }

    @Test
    fun deve_RetornarTrue_QuandoRecebeNumeroDeFaltasMenorQueOMaximo(){

        val resultado = calculador.verificaNumeroDeFaltas(10)

        assertTrue(resultado)

    }

    @Test
    fun deve_RetornarFalse_QuandoRecebeNumeroDeFaltasMaiorQueOMaximo(){

        val resultado = calculador.verificaNumeroDeFaltas(12)

        assertFalse(resultado)

    }

    @Test
    fun deve_RetornarFalse_QuandoAMediaCalculadaForMenorQueOMinino(){

        val resultado = calculador.verificaMedia(4.0, 4.0)

        assertFalse(resultado)
    }

    @Test
    fun deve_RetornarTrue_QuandoAMediaCalculadaForMaiorQueOMinino(){

        val resultado = calculador.verificaMedia(10.0, 6.0)

        assertTrue(resultado)
    }





}