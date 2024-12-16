package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hello : AppCompatActivity() {

    // Объявляем переменные для кнопок
    private lateinit var customButton2: Button
    private lateinit var customButton: Button
    private lateinit var registerButton: Button // Добавляем кнопку для перехода на reg1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        // Инициализация кнопок
        customButton2 = findViewById(R.id.customButton2)
        customButton = findViewById(R.id.customButton)


        // Настройка edge-to-edge (полноэкранный режим)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT // Прозрачный статус бар

        // Обработка системных отступов для View с id main
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Обработка нажатия на customButton2
        customButton2.setOnClickListener {
            val intent = Intent(this, Vhod::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активность
        }

        // Настройка фона для customButton
        customButton.setBackgroundResource(R.drawable.rounded_button)

        // Обработка нажатия на customButton
        customButton.setOnClickListener {
            val intent = Intent(this, reg1::class.java)
            startActivity(intent)
            // Действие при нажатии на customButton
        }

        // Переход на активность reg1 при нажатии на registerButton

    }
}
