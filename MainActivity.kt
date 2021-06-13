package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var num1=0.0f
    var opr=""
    var prev=""
    var num2=0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun number(v: View?)
    {
        var e=findViewById<View>(R.id.result) as EditText
        var b=v as Button
        if(e.text.toString().contains(".")&& b.text==".")
            return
        if(e.text.toString().equals("0") && b.text=="0")
            return
        if(prev=="")
            e.setText(b.text)
        else
            e.setText(e.text.toString()+b.text)
        prev=e.text.toString()

    }
    fun opr(v:View?)
    {
        var e=findViewById<View>(R.id.result) as EditText
        if(e.text.toString().toFloatOrNull()==null)
            return
        num1=e.text.toString().toFloat()
        var b=v as Button
        opr=b.text.toString()
        e.setText(opr)
        prev = ""
    }
    fun calculate(v:View?)
    {
        var e=findViewById<View>(R.id.result) as EditText
        num2=e.text.toString().toFloat()
        var ans=when(opr)
        {
            "+"->num1+num2
            "-"->num1-num2
            "*"->num1*num2
            "/"->{
                if(num2.toInt()==0)
                {
                    Toast.makeText(this,"Divide by zero",Toast.LENGTH_LONG).show()
                    return
                }
                num1/num2

            }
            else->return
        }
         e.setText(ans.toString())
        prev=""

    }
    fun clear(v:View?)
    {
        var e=findViewById<View>(R.id.result) as EditText
        e.setText("")
        prev=""
    }
}


