package com.example.gamenumber

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        generarNumeros()

    }

    private fun generarNumeros() {
        val btnIzq = findViewById<Button>(R.id.btnizquierda)
        val btnDer = findViewById<Button>(R.id.btnderecha)

        var num1: Int
        var num2: Int
        do {
            num1 = (0..9).random()
            num2 = (0..9).random()
        } while (num1 == num2)

        btnIzq.text = num1.toString()
        btnDer.text = num2.toString()

        btnIzq.setBackgroundColor(Color.GRAY)
        btnDer.setBackgroundColor(Color.GRAY)

        btnIzq.setOnClickListener { validarSeleccion(it) }
        btnDer.setOnClickListener { validarSeleccion(it) }
    }

    fun validarSeleccion(view: View) {
        val btnIzq = findViewById<Button>(R.id.btnizquierda)
        val btnDer = findViewById<Button>(R.id.btnderecha)
        val btnSeleccionado = view as Button

        val num1 = btnIzq.text.toString().toInt()
        val num2 = btnDer.text.toString().toInt()
        val seleccionado = btnSeleccionado.text.toString().toInt()

        if (seleccionado == maxOf(num1, num2)) {
            btnSeleccionado.setBackgroundColor(Color.GREEN)
        } else {
            btnSeleccionado.setBackgroundColor(Color.RED)
        }

        btnIzq.postDelayed({ generarNumeros() }, 1000)
    }
}
