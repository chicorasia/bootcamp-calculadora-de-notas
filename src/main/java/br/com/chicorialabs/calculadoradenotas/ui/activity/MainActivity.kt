package br.com.chicorialabs.calculadoradenotas.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

                if(resultado){
                    main_resultado.text = resources.getText(R.string.aprovado)
                    main_resultado.setTextColor(Color.GREEN)
                } else {
                    main_resultado.text = resources.getText(R.string.reprovado)
                    main_resultado.setTextColor(Color.RED)
                }

            } catch (e: NumberFormatException){
                e.printStackTrace()
            }

        }

        main_limpar_btn.setOnClickListener {
            main_nota_1_edt.text.clear()
            main_nota_2_edt.text.clear()
            main_faltas_edt.text.clear()
        }



    }
}