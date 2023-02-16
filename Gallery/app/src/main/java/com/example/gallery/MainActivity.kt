package com.example.gallery

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var img: ImageView
    lateinit var img1: ImageView
    lateinit var img2: ImageView
    lateinit var img3: ImageView
    lateinit var img4: ImageView
    lateinit var img5: ImageView
    lateinit var card: CardView
    lateinit var main: ImageView
    lateinit var next: ImageButton
    lateinit var prev: ImageButton

    var index = 0
    var list = mutableListOf<ImageView>()

    // NOTHING
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.img)
        img1 = findViewById(R.id.img_1)
        img2 = findViewById(R.id.img_2)
        img3 = findViewById(R.id.img_3)
        img4 = findViewById(R.id.img_4)
        img5 = findViewById(R.id.img_5)
        card = findViewById(R.id.card)
        main = findViewById(R.id.main)
        next = findViewById(R.id.next)
        prev = findViewById(R.id.prev)
        list.add(img)
        list.add(img1)
        list.add(img2)
        list.add(img3)
        list.add(img4)
        list.add(img5)
        img.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)

        next.setOnClickListener {
            var animat = AnimationUtils.loadAnimation(this, R.anim.anim)
            if (index == list.size - 1) {
                index = 0
            } else index++
            main.startAnimation(animat)
            main.setImageDrawable(list[index].background)
        }
        prev.setOnClickListener {
            var animat = AnimationUtils.loadAnimation(this, R.anim.anim2)
            if (index == 0) {
                index = list.size - 1
            } else index--
            main.startAnimation(animat)
            main.setImageDrawable(list[index].background)
        }
        card.setOnClickListener {
            card.visibility = View.INVISIBLE
        }
    }

    override fun onClick(p0: View?) {
        var a = findViewById<ImageView>(p0!!.id)

        for (i in 0 until list.size) {
            if (list[i].id == a.id) {
                index = i
            }
        }

        main.setImageDrawable(a.background)
        card.visibility = View.VISIBLE
    }
}