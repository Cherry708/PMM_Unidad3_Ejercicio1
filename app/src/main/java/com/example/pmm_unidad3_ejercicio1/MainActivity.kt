package com.example.pmm_unidad3_ejercicio1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spnOperacion = findViewById<Spinner>(R.id.spnOperacion)

        val adaptador = ArrayAdapter.createFromResource(
            this, R.array.listaOperaciones, android.R.layout.simple_spinner_item
        )

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnOperacion.adapter = adaptador

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val etNumber0 = findViewById<EditText>(R.id.etNumero0)
        val etNumber1 = findViewById<EditText>(R.id.etNumero1)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        btnCalcular.isEnabled = false

        etNumber0.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                btnCalcular.isEnabled = s.toString().isNotEmpty()

            }
        })
        etNumber1.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                btnCalcular.isEnabled = s.toString().isNotEmpty()
            }
        })

        btnCalcular.setOnClickListener {
            if (etNumber0.text.toString() != "" && etNumber1.text.toString() != "") {
                val number0 = etNumber0.text.toString().toInt()
                val number1 = etNumber1.text.toString().toInt()
                when (spnOperacion.selectedItemPosition) {
                    0 -> tvResultado.text = "${number0+number1}"
                    1 -> tvResultado.text = "${number0-number1}"
                    2 -> tvResultado.text = "${number0*number1}"
                    3 -> tvResultado.text = "${number0/number1}"
                }
            }
        }
    }
}