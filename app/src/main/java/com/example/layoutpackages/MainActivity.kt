package com.example.layoutpackages


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutpackages.databinding.ActivityMainBinding
import com.example.layoutpackages.layout.constraint.FirstMenuFragment



class MainActivity : AppCompatActivity(){
    /*
    1. Сравнить расход памяти при использовании верстки с ConstraintLayout и при использовании верстки без ConstraintLayout

    Замеры были произведены в Profiler. При выборе макета с ConstraintLayout было заметно увеличение потребления памяти, но разница была не велика.

    2. Сравнить скорость отрисовки в одном и другом случае

    Замеры были сделаны с помощью теста (присутствует в проекте).
    --
    Constraint facebook : 1889 мс
    Linear facebook : 753 мс
    --
    Constraint audio player : 2005 мс
    Linear audio player : 773 мс
    --
    Constraint telegramm : 1463 мс
    Linear telegramm : 1223 мс
    --
    Constraint calculator : 2313 мс
    Linear calculator : 1540 мс

    3.Сравнить размер apk в одном и другом случае

    В моем случае я не увидел разницы, размеры apk были 5.2 мб.

    4. Ответить на вопрос: в каких случаях лучше использовать ConstraintLayout, а в каких лучше без него?

    Все зависит от сложности ui, если нам необходимо реализовать более сложный ui, то лучше использовать constraint layout.
    Потому что он позволит оптимизировать приложение, путем избежания вложенности других компоновщиков и также, имеет более мощный функционал,
    что позволит сделать ваш макет "гибким" (адаптивным) под различные размеры и форматы экрана.
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.containerView, FirstMenuFragment()).commit()


    }


}