package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reg2 : AppCompatActivity() {

    // Объявляем элементы
    private lateinit var lastName: EditText
    private lateinit var firstName: EditText
    private lateinit var middleName: EditText
    private lateinit var birthDate: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var maleRadioButton: RadioButton
    private lateinit var femaleRadioButton: RadioButton
    private lateinit var nextButton: Button
    private lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg2)

        // Инициализация элементов
        lastName = findViewById(R.id.lastName)
        firstName = findViewById(R.id.firstName)
        middleName = findViewById(R.id.middleName)
        birthDate = findViewById(R.id.birthDate)
        genderRadioGroup = findViewById(R.id.genderRadioGroup) // Инициализация RadioGroup
        maleRadioButton = findViewById(R.id.maleRadioButton)
        femaleRadioButton = findViewById(R.id.femaleRadioButton)
        nextButton = findViewById(R.id.button3)
        backArrow = findViewById(R.id.backArrow)

        // Настройка edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Обработчик для кнопки "Далее"
        nextButton.setOnClickListener {

                startActivity(intent)
            val lastNameText = lastName.text.toString().trim()
            val firstNameText = firstName.text.toString().trim()
            val middleNameText = middleName.text.toString().trim()
            val birthDateText = birthDate.text.toString().trim()
//
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId // Получаем ID выбранного RadioButton
            val gender = if (selectedGenderId == R.id.maleRadioButton) {
                "Мужской"
            } else if (selectedGenderId == R.id.femaleRadioButton) {
                "Женский"
            } else {
                ""
            }
//
            if (lastNameText.isEmpty() || firstNameText.isEmpty() || birthDateText.isEmpty() || gender.isEmpty()) {
                // Если какие-либо поля пустые, показываем сообщение
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()

            } else {
                // Если все поля заполнены, переходим на следующую активность
                val intent = Intent(this, reg3::class.java) // Замените на вашу следующую активность
                startActivity(intent)
            }
        }

        // Обработчик для стрелочки назад
        backArrow.setOnClickListener {
            onBackPressed() // Возвращаемся на предыдущий экран
        }
    }
}
