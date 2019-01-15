package com.fortoxsecurity.trikiappfortox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numUser = 1
    private var matrix = Array(3) { IntArray(3) { 0 } }

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

        if (validarFilas(numUser) || validarColumnas(numUser)
            || validarDiagonal(numUser) || validarDiagonalInversa(numUser)
        ) {
            imprimirGanador(numUser)
            desHabilitarBotones()
        }

        if (numUser == 1) {
            boton.clickUsuario1()
        } else {
            boton.clickUsuario2()
        }

    }

    private fun validarDiagonalInversa(numUser: Int): Boolean {
        val tam = matrix.size - 1
        var tmpContador = 0

        for ((indice2, indice) in (tam downTo 0).withIndex()) {

            if (matrix[indice][indice2] == numUser) {
                tmpContador++
            }

        }

        if (tmpContador == 3) {
            return true
        }

        return false
    }

    private fun validarDiagonal(numUser: Int): Boolean {

        val tam = matrix.size
        var tmpContador = 0

        for (indice in 0 until tam) {

            if (matrix[indice][indice] == numUser) {
                tmpContador++
            }

        }

        if (tmpContador == 3) {
            return true
        }

        return false


    }

    private fun validarColumnas(numUser: Int): Boolean {
        val tam = matrix.size
        var tmpContador: Int

        for (col in 0 until tam) {
            tmpContador = 0
            for (row in 0 until tam) {
                if (matrix[row][col] != numUser) {
                    break
                }

                tmpContador++
            }

            if (tmpContador == 3) {
                return true
            }
        }

        return false
    }

    private fun validarFilas(numUser: Int): Boolean {

        val tam = matrix.size
        var tmpContador: Int

        for (row in 0 until tam) {
            tmpContador = 0
            for (col in 0 until tam) {
                if (matrix[row][col] != numUser) {
                    break
                }

                tmpContador++
            }

            if (tmpContador == 3) {
                return true
            }
        }

        return false
    }

    private fun imprimirGanador(numUser: Int) {
        txtGanador.text = "El ganador es $numUser"
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

        txtGanador.text = ""

        numUser = 1
    }

    fun desHabilitarBotones() {
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false
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
