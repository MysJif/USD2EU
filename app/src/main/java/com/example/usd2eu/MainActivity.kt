package com.example.usd2eu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertBtn = findViewById<Button>(R.id.idConvertBtn)
        val toggleBtn = findViewById<ToggleButton>(R.id.idToggleButton)
        val amount = findViewById<EditText>(R.id.idMoneyEdit)
        val result = findViewById<TextView>(R.id.idResultView)
        val dollarFormat = DecimalFormat("$#,###.00")
        val euroFormat = DecimalFormat("€#,###.00")
        val bigToast = Toast.makeText(applicationContext, "Big Spender: Over 10k", Toast.LENGTH_SHORT)

        var convertBool = false

        toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                convertBool = true
            } else {
                convertBool = false
            }
        }
        fun convert(amount: Double, type: Boolean): String {
            val result: Double
            val resultS: String
            if (type) {
                result = amount / .9
                resultS = euroFormat.format(result)
            } else {
                result = amount * .9
                resultS = dollarFormat.format(result)
            }

            if (result >= 10000.00) {
                bigToast.show()
            }
            return resultS
        }


        convertBtn.setOnClickListener {
            result.text = convert(amount.text.toString().toDouble(), convertBool)
        }
    }
}
