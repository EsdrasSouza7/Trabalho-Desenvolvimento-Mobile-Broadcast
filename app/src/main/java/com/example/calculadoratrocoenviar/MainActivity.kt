package com.example.calculadoratrocoenviar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

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
        val pago = findViewById<EditText>(R.id.editTextNumberDecimal)
        val total = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val btn = findViewById<Button>(R.id.btnenviar)

        btn.setOnClickListener {
            val vpago = pago.text.toString().toFloat()
            val vtotoal = total.text.toString().toFloat()
            enviar(vpago, vtotoal)
        }

    }
    private fun enviar(valoPago: Float, valorTotal: Float){
        val intent = Intent("com.exemplo.TRANSACAO_CONCLUIDA")
        intent.putExtra("valor_pago", 100.0)
        intent.putExtra("valor_total", 75.0)
        sendBroadcast(intent)
    }
}