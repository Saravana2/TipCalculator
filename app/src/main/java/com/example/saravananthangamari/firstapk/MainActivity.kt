package com.example.saravananthangamari.firstapk

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.*;


class MainActivity : AppCompatActivity() {

    private var edit_text:  EditText?=null
    private var button1: Button?=null
    private var button2: Button?=null
    private var button3: Button?=null
    private var textView1: TextView?=null
    private var textView2: TextView?=null
    private var textView3: TextView?=null
    private var percentage: Int =0
    private val percent1: Int =10
    private val percent2: Int =15
    private val percent3: Int =20
    private var billAmount: Double =0.0
    private var finalAmount: Double =0.0
    private var tipAmount: Double =0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        define()
    }


    private fun initialize() {
        edit_text=findViewById(R.id.editText) as EditText
        button1=findViewById(R.id.button) as Button
        button2=findViewById(R.id.button1) as Button
        button3=findViewById(R.id.button2) as Button
        textView1=findViewById(R.id.textView1) as TextView
        textView2=findViewById(R.id.textView2) as TextView
        textView3=findViewById(R.id.textView4) as TextView
    }

    private fun define() {
        percentage=percent1
        callFunctions()

    button1!!.setOnClickListener{
        percentage=percent1
        callFunctions()
    }
        button2!!.setOnClickListener{
            percentage=percent2
            callFunctions()
        }
        button3!!.setOnClickListener{
            percentage=percent3
            callFunctions()
        }

        edit_text!!.onChange {
            callFunctions()
        }

    }
    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }


    private fun callFunctions(){

        var input1: String = edit_text?.getText().toString()
        if(input1.equals("")){
            billAmount=0.0
        }else{
            billAmount=input1.toDouble()
        }

        //Toast.makeText(this,input1,Toast.LENGTH_LONG ).show()

        calculateBillAmount_with_tip()
    }

    private fun calculateBillAmount_with_tip(){
        tipAmount=(billAmount*percentage)/100
        finalAmount=billAmount+tipAmount
        textView1?.setText(resources.getString(R.string.tip_percent,percentage.toDouble().toString()))
        textView2?.setText(resources.getString(R.string.tip_total,tipAmount.toString()))
        textView3?.setText(resources.getString(R.string.total_amount,finalAmount.toString()))
    }



}
