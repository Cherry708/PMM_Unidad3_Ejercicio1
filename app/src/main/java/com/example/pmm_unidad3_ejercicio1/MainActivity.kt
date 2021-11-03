package com.example.pmm_unidad3_ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnOperacion = findViewById<Spinner>(R.id.spnOperacion)
        val adaptador = ArrayAdapter.createFromResource(
            this, R.array.listaOperaciones, android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnOperacion.adapter = adaptador
        spnOperacion.onItemSelectedListener
    }

    override fun onItemSelected(item: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        //An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
        if (item?.selectedItemPosition == 0){
            Toast.makeText(this,"Prs", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}