package com.example.calculatorkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var numStr: String = ""
    private val nList = ArrayList<Double>()
    private val oList = ArrayList<Char>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}0"
            numStr += "0"
        }

        btn1.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}1"
            numStr += "1"
        }

        btn2.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}2"
            numStr += "2"
        }

        btn3.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}3"
            numStr += "3"
        }

        btn4.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}4"
            numStr += "4"
        }

        btn5.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}5"
            numStr += "5"
        }

        btn6.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}6"
            numStr += "6"
        }

        btn7.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}7"
            numStr += "7"
        }

        btn8.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}8"
            numStr += "8"
        }

        btn9.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}9"
            numStr += "9"
        }

        btnPeriod.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}."
            numStr += "."
        }

        btnAddition.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}+"
            addList(numStr, '+')
            numStr = ""
        }

        btnSubstraction.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}-"
            addList(numStr, '-')
            numStr = ""
        }

        btnMultiple.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}×"
            addList(numStr, '*')
            numStr = ""
        }

        btnDivision.setOnClickListener{
            textViewToDisplay.text = "${textViewToDisplay.text}÷"
            addList(numStr, '/')
            numStr = ""
        }

        btnAllClear.setOnClickListener {
            textViewToDisplay.text = ""
            numStr = ""
            nList.clear()
            oList.clear()
        }

        btnEqual.setOnClickListener {
            /*if(nList.size != oList.size + 1)
                return@setOnClickListener*/

            textViewToDisplay.text = "${textViewToDisplay.text}="
            addList(numStr)
            val result = calculate().toString()
            textViewToDisplay.text = result
            numStr = result
            nList.clear()
            oList.clear()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addList(numStr: String) {
        try {
            val num = numStr.toDouble()
            nList.add(num)
        }catch (e: Exception){
            textViewToDisplay.text = "Numeric Error"
        }

    }

    @Suppress("NAME_SHADOWING")
    private fun calculate(): Double {
        var i = 0
        while (i < oList.size){
            if (oList.get(i) == '*' || oList.get(i) == '/'){
                val result =
                    if(oList.get(i) == '*'){
                        nList.get(i) * nList.get(i+1)
                    }else{
                        nList.get(i) / nList.get(i+1)
                    }
                nList.set(i, result)
                nList.removeAt(i+1)
                oList.removeAt(i)
                i--
            }
            else if(oList.get(i) == '-'){
                oList.set(i, '+')
                nList.set(i+1, nList.get(i+1) * -1)
            }
            i++
        }

        var result = 0.0
        for (i in nList){
            result += i
        }

        return result
    } // end of calculate()

    @SuppressLint("SetTextI18n")
    private fun addList(numStr: String, operator: Char) {
        try {
            val num = numStr.toDouble()
            nList.add(num)
            if (operator != '='){
                oList.add(operator)
            }
        }catch (e: Exception){
            textViewToDisplay.text = "Numeric Error"
        }
    }
}
