package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reg1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg1)

        // Настройка edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Найти элементы по их ID
        val backArrow = findViewById<ImageView>(R.id.backArrow) // Стрелка назад
        val checkBox = findViewById<CheckBox>(R.id.checkBox)    // Чекбокс согласия
        val nextButton = findViewById<Button>(R.id.button2)  // Кнопка "Далее"

        // Обработчик для кнопки "Далее"
        nextButton.setOnClickListener {
            if (checkBox.isChecked) {
                // Действие, если чекбокс выбран
                val intent = Intent(this, reg2::class.java) // Замените на вашу следующую активность
                startActivity(intent)
            } else {
                // Вывод сообщения, если чекбокс не выбран
                Toast.makeText(this, "Вы должны согласиться с условиями", Toast.LENGTH_SHORT).show()
            }
        }

        // Обработчик для стрелочки назад
        backArrow.setOnClickListener {
            onBackPressed() // Вернуться назад
        }
    }
}
