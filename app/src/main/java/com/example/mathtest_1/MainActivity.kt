package com.example.mathtest_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }

    fun randomChar(chars: String): Char {
        return chars[Random.nextInt(chars.length)]
    }

    public var a = 0
    public var b = 0
    public var c = " "
    public var x = 0
    public var y = 0
    public var z = 0

    fun btnClickStart(view: View){
        val start = 10
        val end = 99
        val chars = "+-*/"
        a = rand(start, end)
        b = rand(start, end)
        c = randomChar(chars).toString()
        if (c == "/")
        {
            do {
                do {
                    a = rand(start, end)
                    b = rand(start, end)
                } while ((a % 2 != 0 || b % 2 != 0) && a == b)
                if (a < b) {
                    val a2 = b
                    val b2 = a
                    a = a2
                    b = b2
                }
            }while(a % b != 0)
        }
        val a1 = a.toString()
        val b1 = b.toString()
        var c1 = c.toString()
        val textV1 = findViewById<TextView>(R.id.textView8)
        val textV3 = findViewById<TextView>(R.id.textView9)
        val textV2 = findViewById<TextView>(R.id.textView10)
        textV1.text = a1
        textV2.text = b1
        textV3.text = c1
    }

    fun btnClickCheck(view: View){
        var sum = 0
        var txtProcent = findViewById<TextView>(R.id.textPROCENT)
        var p = 0.00
        var txtTrue = findViewById<TextView>(R.id.textTRUE)
        var txtFalse = findViewById<TextView>(R.id.textFALSE)
        var txtItog = findViewById<TextView>(R.id.textITOG)
        when(c){
            "+" -> sum = a + b
            "-" -> sum = a - b
            "*" -> sum = a * b
            "/" -> sum = a / b
        }
        var sumV = sum.toString()
        var sumV1 = findViewById<TextView>(R.id.editValue)
        var sumV2 = sumV1.text.toString()
        if (sumV == sumV2)
        {
            x += 1
            z +=1
            txtTrue.text = "$x"
            txtItog.text = "$z"
        }
        else
        {
            y += 1
            z +=1
            txtFalse.text = "$y"
            txtItog.text = "$z"
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        p = ((x.toDouble() / z.toDouble()))
        val p1 = df.format(p * 100)
        txtProcent.text = "$p1 %"
    }

}