package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpression as XPathExpression1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNull.setOnClickListener { setTextFields("0") }
        btn1.setOnClickListener { setTextFields("1") }
        btn2.setOnClickListener { setTextFields("2") }
        btn3.setOnClickListener { setTextFields("3") }
        btn4.setOnClickListener { setTextFields("4") }
        btn5.setOnClickListener { setTextFields("5") }
        btn6.setOnClickListener { setTextFields("6") }
        btn7.setOnClickListener { setTextFields("7") }
        btn8.setOnClickListener { setTextFields("8") }
        btn9.setOnClickListener { setTextFields("9") }
        btnDot.setOnClickListener { setTextFields(".") }
        buttonMinus.setOnClickListener { setTextFields("-") }
        buttonPlus.setOnClickListener { setTextFields("+") }
        btnOne.setOnClickListener { setTextFields("(") }
        btnTwo.setOnClickListener { setTextFields(")") }
        btnThree.setOnClickListener { setTextFields("/") }
        btnMultiply.setOnClickListener { setTextFields("*") }

        acButton.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }
        btnBack.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty())
                mathOperation.text = str.substring(0, str.length - 1)
            resultText.text = ""
        }

        buttonEqually.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble() )
                    resultText.text = longRes.toString()
                else
                    resultText.text = result.toString()

            }catch (e:Exception){
                Log.d("Ошибка", "Сообшение: ${e.message}")
            }
        }


    }

    fun setTextFields(str: String){
        mathOperation.append(str)
    }






}