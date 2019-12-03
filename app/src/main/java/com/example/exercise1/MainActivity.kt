package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editTextCarPrice: EditText
    lateinit var editTextDownPayment: EditText
    lateinit var editTextLoanPeriod: EditText
    lateinit var editTextInterestRate: EditText
    lateinit var textViewLoan: TextView
    lateinit var textViewInterest:TextView
    lateinit var textViewMonthlyRepayment:TextView
    lateinit var buttonCalculate: Button
    lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCarPrice = findViewById(R.id.editTextCarPrice)
        editTextDownPayment = findViewById(R.id.editTextDownPayment)
        editTextLoanPeriod = findViewById(R.id.editTextLoanPeriod)
        editTextInterestRate = findViewById(R.id.editTextInterestRate)
        textViewLoan = findViewById(R.id.textViewLoan)
        textViewInterest = findViewById(R.id.textViewInterest)
        textViewMonthlyRepayment = findViewById(R.id.textViewMonthlyRepayment)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonReset = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener { calculate() }
        buttonReset.setOnClickListener { reset() }
    }

    private fun calculate(){
        //Car loan = car price - down payment
        var carPrice = editTextCarPrice.text.toString().toDouble()
        var downPayment = editTextDownPayment.text.toString().toDouble()
        var carLoan = carPrice - downPayment
        val carLoanPrice: Double = String.format("%.2f", carLoan).toDouble()

        //Interest = car loan * interest rate * loan period
        var loanPeriod = editTextLoanPeriod.text.toString().toInt()
        var interestRate = editTextInterestRate.text.toString().toDouble()
        var interest = carLoan * (interestRate / 100) * loanPeriod
        val interestPrice: Double = String.format("%.2f", interest).toDouble()

        //Monthly repayment = (car loan + interest) / loan period / 12 months
        var monthlyRepayment = (carLoan + interest) / loanPeriod / 12
        val monthlyRepaymentPrice: Double = String.format("%.2f", monthlyRepayment).toDouble()

        //Display the result
        textViewLoan.text = textViewLoan.text.toString() + " RM " + carLoanPrice.toString()
        textViewInterest.text = textViewInterest.text.toString() + " RM " + interestPrice.toString()
        textViewMonthlyRepayment.text = textViewMonthlyRepayment.text.toString() + " RM " + monthlyRepaymentPrice.toString()
    }

    private fun reset(){
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextInterestRate.text = null
        editTextLoanPeriod.text = null
        textViewLoan.text = resources.getString(R.string.loan)
        textViewInterest.text = resources.getString(R.string.interest)
        textViewMonthlyRepayment.text = resources.getString(R.string.monthly_repayment)
    }
}
