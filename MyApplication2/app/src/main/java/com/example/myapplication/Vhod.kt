package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Vhod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vhod)

        // Получаем главный layout с id main
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)

        // Устанавливаем listener для обработки системных вставок (system bars)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Получаем элементы TextInputEditText внутри TextInputLayout
        val textInput1 = findViewById<TextInputEditText>(R.id.textInputEditText1)
        val textInput2 = findViewById<TextInputEditText>(R.id.textInputEditText2)

        // Пример взаимодействия с кликабельным текстом
        val textViewRegister = findViewById<TextView>(R.id.textView9) // Кликабельный текст "Зарегистрироваться"

        // Обработка нажатия по тексту "Зарегистрироваться"
        textViewRegister.setOnClickListener {
            val intent = Intent(this, reg1::class.java)
            startActivity(intent)
        }
    }
}
