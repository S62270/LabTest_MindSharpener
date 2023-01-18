package com.example.mindsharpener

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var checkButton : Button
    lateinit var operand1: TextView
    lateinit var operand2: TextView
    lateinit var operator : TextView
    lateinit var user_answer : EditText
    lateinit var easy : RadioButton
    lateinit var medium : RadioButton
    lateinit var hard : RadioButton
    lateinit var point : TextView
    var randomOperand1=0
    var randomOperand2=0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkButton = findViewById(R.id.checkBtn)
        operand1 = findViewById(R.id.value1)
        operator = findViewById(R.id.operator)
        operand2 = findViewById(R.id.value2)
        user_answer = findViewById(R.id.answer)
        easy = findViewById(R.id.easy)
        medium = findViewById(R.id.medium)
        hard = findViewById(R.id.hard)
        point = findViewById(R.id.pointsVal)

        val randomOperator = "+-*/"
        var operatorGenerator = randomOperator.random()

            randomOperand1= Random.nextInt(0,9)
            randomOperand2= Random.nextInt(0,9)

        operand1.setText(randomOperand1.toString())
        operator.setText(operatorGenerator.toString())
        operand2.setText(randomOperand2.toString())
        point.setText("0")

        var answer = 0
        var currentPoint = 0
        checkButton.setOnClickListener(){
            answer = calculate(randomOperand1,operatorGenerator,randomOperand2)


                if (user_answer.text.toString().toInt() == answer) {
                    currentPoint++
                } else {
                    currentPoint--
                }

            point.setText(currentPoint.toString())

            operatorGenerator = randomOperator.random()
            operator.setText(operatorGenerator.toString())

            if(easy.isChecked){
                do{
                randomOperand1 = Random.nextInt(0,9)
                randomOperand2 = Random.nextInt(1,9)
                }while(operator.equals("/")&&(randomOperand2.equals(0)))

            }else if(medium.isChecked){
                do{
                    randomOperand1 = Random.nextInt(10,99)
                    randomOperand2 = Random.nextInt(10,99)
                }while(operator.equals("/")&&(randomOperand2.equals(0)))

            }else if(hard.isChecked){
                do{
                    randomOperand1 = Random.nextInt(100,999)
                    randomOperand2 = Random.nextInt(1,999)
                }while(operator.equals("/")&&(randomOperand2.equals(0)))

            }

            operand1.setText(randomOperand1.toString())
            operand2.setText(randomOperand2.toString())
            user_answer.setText("")
        }
    }


    fun calculate(operand1:Int,operator:Char,operand2:Int) : Int{
        var result = 0
        if(operator.equals('+')){
            result = operand1 + operand2
        }else if(operator.equals('-')){
            result = operand1 - operand2
        }else if(operator.equals('*')){
            result = operand1 * operand2
        }else if(operator.equals('/')){
            result = operand1 / operand2
        }else{

        }
        return result
    }

}