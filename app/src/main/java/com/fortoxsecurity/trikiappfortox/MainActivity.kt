package com.fortoxsecurity.trikiappfortox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numUser = 1
    private var matrix = Array(3, { IntArray(3, { 0 }) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { clickUsuario(it) }
        btn2.setOnClickListener {
            clickUsuario(it)
        }
        btn3.setOnClickListener { clickUsuario(it) }
        btn4.setOnClickListener { clickUsuario(it) }
        btn5.setOnClickListener { clickUsuario(it) }
        btn6.setOnClickListener { clickUsuario(it) }
        btn7.setOnClickListener { clickUsuario(it) }
        btn8.setOnClickListener { clickUsuario(it) }
        btn9.setOnClickListener { clickUsuario(it) }

        btnReiniciar.setOnClickListener { reiniciarJuego() }

        reiniciarJuego()

    }

    private fun clickUsuario(view: View) {

        val boton = view as Button
        setMatrixUsuario(boton.id, numUser)
        // validar filas

        if (numUser == 1) {
            boton.clickUsuario1()
        } else {
            boton.clickUsuario2()
        }
    }

    private fun setMatrixUsuario(id: Int, numUser: Int) {

        when (id) {
            btn1.id -> matrix[0][0] = numUser
            btn2.id -> matrix[0][1] = numUser
            btn3.id -> matrix[0][2] = numUser
            btn4.id -> matrix[1][0] = numUser
            btn5.id -> matrix[1][1] = numUser
            btn6.id -> matrix[1][2] = numUser
            btn7.id -> matrix[2][0] = numUser
            btn8.id -> matrix[2][1] = numUser
            btn9.id -> matrix[2][2] = numUser
        }
    }

    private fun reiniciarJuego() {

        for (row in 0 until matrix.size) {
            for (col in 0 until matrix.size) {
                matrix[row][col] = 0
            }
        }

        btn1.reiniciar()
        btn2.reiniciar()
        btn3.reiniciar()
        btn4.reiniciar()
        btn5.reiniciar()
        btn6.reiniciar()
        btn7.reiniciar()
        btn8.reiniciar()
        btn9.reiniciar()

        numUser = 1
    }

    fun Button.clickUsuario1() {
        this.text = "O"
        this.setTextColor(getColor(R.color.colorBlanco))
        this.isEnabled = false
        numUser = 2
    }

    fun Button.clickUsuario2() {
        this.text = "X"
        this.setTextColor(getColor(R.color.colorAccent))
        this.isEnabled = false
        numUser = 1
    }

    fun Button.reiniciar() {
        this.text = ""
        this.isEnabled = true
    }

}
