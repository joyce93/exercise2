package com.example.exercise2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener() {
            calBmi()
        }
        btnReset.setOnClickListener(){
            reset()
        }
        //lk
    }

    private fun calBmi() {
        try {
            val weight: Double = AnsWeight.text.toString().toDouble()
            val height: Double = AnsHeight.text.toString().toDouble()

            val bmi: Double = weight / (height * height)
            val result: String

            if (bmi <= 18.5) {
                result = "UNDER"
                imgResult.setImageResource(R.drawable.under)
            } else if (bmi <= 24.9) {
                result = "NORMAL"
                imgResult.setImageResource(R.drawable.normal)
            } else {
                result = "OVER"
                imgResult.setImageResource(R.drawable.over)
            }

            //todo:: display image & BMI result
            bmiResult.text = "BMI: %.2f (%s)".format(bmi, result)
        }
        catch (e:Exception){
            val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            val view = toast.view
            view.setBackgroundColor(Color.RED)

            toast.setGravity(Gravity.CENTER, 0 , 0 )
            toast.show()
        }
    }
    private fun reset()
    {
        AnsHeight.text = null //  = setTEst("")
        AnsWeight.text = null
        imgResult.setImageResource(R.drawable.empty)
        bmiResult.text =null

        AnsWeight.requestFocus()
    }

}
