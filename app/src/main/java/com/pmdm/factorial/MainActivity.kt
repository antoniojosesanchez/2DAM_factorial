package com.pmdm.factorial

/**
 * Antonio José Sánchez Bujaldón
 * Programación de Aplicaciones Multimedia y de Dispositivos Móviles
 * curso 2021|22
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.pmdm.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    //private lateinit var resultado: TextView
    //private lateinit var valor: EditText
    //private lateinit var boton: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //resultado = findViewById(R.id.resultado)

        binding.botonCalcular.setOnClickListener {

            // recuperamos el valor del campo
            var texto = binding.valor.text

            if (texto.isNotEmpty())
            {
                // parseamos y convertimos a entero
                var numero = Integer.parseInt(texto.toString())

                // calculamos y mostramos el resultado si el valor es positivo
                if (numero >= 0) {
                    binding.resultado.text = factorial(numero).toString()
                    return@setOnClickListener
                }
            }

            // Mostramos un error en caso de que el campo esté vacío
            // o tenga un valor negativo.
            Snackbar.make(it, R.string.msg_error, Snackbar.LENGTH_LONG)
                    .show()
        }

    }

    /**
     * Calcula el factorial de un número
     * @param n
     * @return
     */
    private fun factorial(n: Int): Int
    {
        var fac: Int = 1
        var num = n

        while(num > 1)
        {
            fac *= num
            num--
        }

        return fac
    }
}












