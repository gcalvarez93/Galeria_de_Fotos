package com.gcadev.galeriadefotos

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Llamamos al botón creado en el XML
        val boton: Button
        boton = findViewById(R.id.button)
        boton.setOnClickListener { //Creamos un fragment y llamamos al DialogFragment
            val manager = supportFragmentManager
            val galeria = DialogFragmentGaleria()
            galeria.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.transparente)
            galeria.show(manager, "")
        }
    }
}