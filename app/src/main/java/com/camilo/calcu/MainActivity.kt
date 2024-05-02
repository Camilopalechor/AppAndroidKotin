package com.camilo.calcu

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    //Variables globalesssss
    var oper: Int = 0
    var numero: Double = 0.0
    var numero2: Double = 0.0
    lateinit var txtnumerouno: TextView
    lateinit var txtnum: TextView
    lateinit var  delete:Button
    lateinit var  result:Button
    lateinit var porcen:Button
    //************************
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtnumerouno = findViewById(R.id.TxtNumeroResult)
        txtnum = findViewById(R.id.TxtNumero)
        delete= findViewById(R.id.BtnBorrar)
        result = findViewById(R.id.BtnResultado)
        porcen= findViewById(R.id.BtnPorcentaje)

    }

    fun capturarDigito(view: View){
        //val  txtnum:TextView = findViewById(R.id.TxtNumero)
        var num:String = txtnum.text.toString()

        if (num == "0.0") {
            num = ""
        }

        when(view.id){
            R.id.BtnCero -> txtnum.setText(num+"0")
            R.id.BtnUno -> txtnum.setText(num+"1")
            R.id.BtnDos -> txtnum.setText(num+"2")
            R.id.BtnTres -> txtnum.setText(num+"3")
            R.id.BtnCuatro -> txtnum.setText(num+"4")
            R.id.BtnCinco -> txtnum.setText(num+"5")
            R.id.BtnSeis -> txtnum.setText(num+"6")
            R.id.BtnSiete -> txtnum.setText(num+"7")
            R.id.BtnOcho -> txtnum.setText(num+"8")
            R.id.BtnNueve -> txtnum.setText(num+"9")
            R.id.BtnPunto -> txtnum.setText(num+".")
        }

    }

    fun operacion(view: View){
        numero = txtnum.text.toString().toDoubleOrNull() ?: 0.0
        var num_text : String = txtnum.text.toString()
        //Esta linea es para limpiar los parametros del numero de abajo
        txtnum.setText("")

        when(view.id){
            R.id.BtnSuma ->{
                txtnumerouno.setText(num_text+"+")
                oper=1
            }
            R.id.BtnResta ->{
                txtnumerouno.setText(num_text+"-")
                oper=2
            }
            R.id.BtnMulti ->{
                txtnumerouno.setText(num_text+"*")
                oper=3
            }

            R.id.BtnDivision ->{
                txtnumerouno.setText(num_text+"/")
                oper=4
            }

            R.id.BtnPorcentaje ->{
                txtnumerouno.setText(num_text+"%")
                oper=5
            }
            R.id.BtnRaiz->{
                txtnumerouno.setText(num_text+"R")
                oper=6
            }

        }
    }

    fun resultado(view: View){
        result.setOnClickListener {
            var resp:Double = 0.0
            //var verificar:Double =0.0
            when(oper){
                1-> resp = sumar()
                2-> resp = resta()
                3-> resp = multi()
                4-> resp = divi()
                5-> resp = porcen()
                6-> resp = raizCuadrada()


            }

             txtnum.setText(resp.toString())

            txtnumerouno.setText("")
        }
    }

    fun sumar(): Double {
        numero2 = txtnum.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = numero + numero2
        return resultado
    }

    fun resta(): Double {
        numero2 = txtnum.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = numero - numero2
        return resultado
    }

    fun multi(): Double {
        numero2 = txtnum.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = numero * numero2
        return resultado
    }
    fun divi(): Double {
        numero2 = txtnum.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = numero / numero2
        return resultado
    }


    fun porcen(): Double {
        var resultado = numero / 100
        return resultado
    }

    fun raizCuadrada(): Double {
        return sqrt(numero)
    }


    fun borrar(view: View){
        delete.setOnClickListener {
           txtnumerouno.setText("")
            txtnum.setText("")
            numero = 0.0
            numero2 = 0.0
        }
    }
}

