package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class OnBorn : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var imageView: ImageView
    private lateinit var nextButton: Button
    private lateinit var skipButton: TextView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_born)

        // Найти ViewPager2, ImageView, TextView и кнопки по ID
        viewPager2 = findViewById(R.id.viewPager2)
        imageView = findViewById(R.id.imageView3)

        nextButton = findViewById(R.id.nextButton)
        skipButton = findViewById(R.id.skipButton)

        // Список изображений для ViewPager2
        val imagesForPager = listOf(
            R.drawable.img_2,
            R.drawable.img_5,
            R.drawable.img_6
        )

        // Список изображений для ImageView (отдельные изображения)
        val imagesForImageView = listOf(
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_7
        )


        // Добавляем заголовки и подзаголовки для ViewPager2
        val titlesForPages = listOf(
            "Аренда автомобилей",
            "Безопасно и удобно",
            "Лучшие предложения"
        )

        val subtitlesForPages = listOf(
            "Открой для себя удобный и доступный способ передвижения",
            "Арендуй автомобиль и наслаждайся его удобством",
            "Выбирай понравившееся среди сотен доступных автомобилей"
        )

        // Настроить адаптер для ViewPager2
        viewPagerAdapter = ViewPagerAdapter(imagesForPager, titlesForPages, subtitlesForPages)
        viewPager2.adapter = viewPagerAdapter

        // Callback для смены страницы
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Меняем изображение и текст в зависимости от позиции ViewPager2
                imageView.setImageResource(imagesForImageView[position])


                // Если на последней странице, меняем текст кнопки на "Завершить"
                if (position == imagesForPager.size - 1) {
                    nextButton.text = "Завершить"
                } else {
                    nextButton.text = "Далее"
                }
            }
        })

        // Обработка кнопки "Пропустить"
        skipButton.setOnClickListener {
            // Запускаем HelloActivity при нажатии на кнопку "Пропустить"
            val intent = Intent(this, Hello::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активность
        }

// Обработка кнопки "Далее"
        nextButton.setOnClickListener {
            if (viewPager2.currentItem < imagesForPager.size - 1) {
                viewPager2.currentItem = viewPager2.currentItem + 1 // Листаем на следующую страницу
            } else {
                // Запускаем HelloActivity при достижении последней страницы
                val intent = Intent(this, Hello::class.java)
                startActivity(intent)
                finish() // Закрываем текущую активность
            }
        }


        // Обработка edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
