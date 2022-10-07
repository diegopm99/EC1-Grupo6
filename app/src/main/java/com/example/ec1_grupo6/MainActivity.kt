package com.example.ec1_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ec1_grupo6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btncalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        prestamos()
    }

    private fun prestamos() {

        var prestamo = binding.txvprestamo.text.toString().toDouble()
        var cuota =0.0
        var n_cuotas=""
        var interes=0.0

        if (prestamo > 5000 ){
            n_cuotas = "cobra en 3 cuotas"
            cuota = prestamo /3
        }else if (prestamo < 1000 ){
            n_cuotas = "cobra en 1 cuota"
            cuota = prestamo
        }else if (prestamo > 2000 && prestamo < 3000){
            n_cuotas = "cobra en 2 cuotas"
            cuota = prestamo /2
        }else{
            n_cuotas = "cobra en 5 cuotas"
            cuota = prestamo/5
        }

        if (prestamo < 4000){
            interes =0.12
        }
        else{
            interes =  0.10
        }

        cuota= cuota+ (cuota * interes)
        binding.txvmonto.text = "Se  $n_cuotas y el monto de las cuotas es : $cuota"
    }
}