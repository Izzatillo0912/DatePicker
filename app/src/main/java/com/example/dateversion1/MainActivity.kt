package com.example.dateversion1

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var setListener : DatePickerDialog.OnDateSetListener
    private val calendar = Calendar.getInstance()
    var year = calendar[Calendar.YEAR]
    var month = calendar[Calendar.MONTH]
    var day = calendar[Calendar.DAY_OF_MONTH]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openDatePicker(view: View) {
        setListener = DatePickerDialog.OnDateSetListener(object : DatePickerDialog.OnDateSetListener,
                (DatePicker, Int, Int, Int) -> Unit {
            override fun onDateSet(p0: DatePicker?, year1 : Int, month1: Int, day1 : Int) {
            }
            override fun invoke(p1: DatePicker, year1: Int, month1: Int, day1: Int) {
                button.text = "$day1 - kun/$month1 - oy/$year1 - yil"
            }
        })
        val datePicker = DatePickerDialog(
            this,android.R.style.Theme_Holo_Dialog_MinWidth,setListener,year,month,day)
        datePicker.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        datePicker.show()
    }

    fun openDatePicker2(view: View) {

        val datePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener(object : DatePickerDialog.OnDateSetListener,
                (DatePicker, Int, Int, Int) -> Unit {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                }
                override fun invoke(p1: DatePicker, year1: Int, month1: Int, day1: Int) {
                    button1.text = "$day1 - kun/$month1 - oy/$year1 - yil"
                }
            }
        ),year,month,day).show()
    }
}