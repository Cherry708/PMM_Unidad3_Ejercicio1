package com.example.pmm_unidad3_ejercicio1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spnOperacion = findViewById<Spinner>(R.id.spnOperacion)

        val adaptador = ArrayAdapter.createFromResource(
            this, R.array.listaOperaciones, android.R.layout.simple_spinner_item)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnOperacion.adapter = adaptador

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val etNumber0 = findViewById<EditText>(R.id.etNumero0)
        val etNumber1 = findViewById<EditText>(R.id.etNumero1)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)


        btnCalcular.setOnClickListener {

            val number0 = etNumber0.text.toString().toInt()
            val number1 = etNumber1.text.toString().toInt()
            when(spnOperacion.selectedItemPosition) {
                0 -> tvResultado.setText("${number0 + number1}")
                1 -> tvResultado.setText("${number0 - number1}")
                2 -> tvResultado.setText("${number0 * number1}")
                3 -> tvResultado.setText("${number0 / number1}")
            }
        }

    }
}