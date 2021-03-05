package br.com.chicorialabs.calculadoradenotas.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.chicorialabs.calculadoradenotas.R
import br.com.chicorialabs.calculadoradenotas.ui.activity.model.Calculador
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculador = Calculador()

        main_calcular_btn.setOnClickListener {

            try {
                val nota1: Double = main_nota_1_edt.text.toString().toDouble()
                val nota2: Double = main_nota_2_edt.text.toString().toDouble()
                val faltas: Int = Integer.parseInt(main_faltas_edt.text.toString())
                val resultado = calculador.avalia(nota1, nota2, faltas)

                mostraResultado(main_resultado, resultado,
                    calculador.media(nota1, nota2), faltas)

            } catch (e: NumberFormatException) {
                e.printStackTrace()
                main_resultado.text = ""
            }

        }

        configuraBtnLimparCampos()
    }

    private fun mostraResultado(textView: TextView, resultado: Boolean, media: Double, faltas: Int) {
        if (resultado) {
            textView.text = resources.getString(R.string.aprovado,
                media.toString(), faltas)
            textView.setTextColor(
                ContextCompat
                    .getColor(this, R.color.textoAprovadoColor)
            )
        } else {
            textView.text = resources.getString(R.string.reprovado,
                media.toString(), faltas)
            textView.setTextColor(
                ContextCompat
                    .getColor(this, R.color.textoReprovadoColor)
            )
        }
    }

    private fun configuraBtnLimparCampos() {
        main_limpar_btn.setOnClickListener {
            main_nota_1_edt.text.clear()
            main_nota_2_edt.text.clear()
            main_faltas_edt.text.clear()
            main_resultado.text = ""
        }
    }
}