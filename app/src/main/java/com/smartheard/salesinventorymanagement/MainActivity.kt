package com.smartheard.salesinventorymanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private val data1 = ArrayList<String>()
    private val data2 = ArrayList<String>()
    private val data3 = ArrayList<String>()
    private val data4 = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pname = findViewById(R.id.editProductName) as EditText
        val price = findViewById(R.id.editProductPrice) as EditText
        val qty = findViewById(R.id.editProductQty) as EditText

        val subtotal = findViewById(R.id.editSubTotal) as EditText
        val pay = findViewById(R.id.editPayment) as EditText
        val bal = findViewById(R.id.editBalance) as EditText

        val badd = findViewById(R.id.btnAdd) as MaterialButton
        val bCal = findViewById(R.id.btnCal) as MaterialButton

        bCal.setOnClickListener {
            val sub = Integer.parseInt(subtotal.text.toString())
            val payment = Integer.parseInt(pay.text.toString())
            val balance = payment - sub
            bal.setText(balance.toString())
        }

        badd.setOnClickListener {
           val pn = pname.text.toString()
          val pp = price.text.toString().toInt()
          val qtyy = qty.text.toString().toInt()

            val total = pp * qtyy

            data1.add(pn)
            data2.add(pp.toString())
            data3.add(qtyy.toString())
            data4.add(total.toString())

            val table = findViewById(R.id.tableLayout) as TableLayout

            val row = TableRow(this)
            val t1 = TextView(this)
            val t2 = TextView(this)
            val t3 = TextView(this)
            val t4 = TextView(this)

            var tot : String
            var sum = 0

            for(i in data1.indices ){
                val pa = data1[i]
                val pprice = data2[i]
                val pqty = data3[i]
                val ptotal = data4[i]

                t1.text = pa
                t2.text = pprice
                t3.text = pqty
                t4.text = ptotal

                sum = sum  + Integer.parseInt(data4[i])
            }
            row.addView(t1)
            row.addView(t2)
            row.addView(t3)
            row.addView(t4)
            table.addView(row)

            subtotal.setText(sum.toString())
            pname.setText("")
            price.setText("")
            qty.setText("")
            pname.requestFocus()

        }

    }
}