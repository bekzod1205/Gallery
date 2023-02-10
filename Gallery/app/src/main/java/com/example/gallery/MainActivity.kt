package com.example.gallery

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

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var ney:ImageView
    lateinit var ron:ImageView
    lateinit var mes:ImageView
    lateinit var bale:ImageView
    lateinit var mba:ImageView
    lateinit var hal:ImageView
    lateinit var card:CardView
    lateinit var main:ImageView
    lateinit var next:ImageButton
    lateinit var prev:ImageButton

    var index = 0
    var list = mutableListOf<ImageView>()
// NOTHING
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ney = findViewById(R.id.ney)
        ron = findViewById(R.id.ron)
        mes = findViewById(R.id.mes)
        bale = findViewById(R.id.bale)
        mba = findViewById(R.id.mba)
        hal = findViewById(R.id.hal)
        card = findViewById(R.id.card)
        main = findViewById(R.id.main)
        next = findViewById(R.id.next)
        prev = findViewById(R.id.prev)
        list.add(ney)
        list.add(ron)
        list.add(mes)
        list.add(bale)
        list.add(mba)
        list.add(hal)
        ney.setOnClickListener(this)
        ron.setOnClickListener(this)
        mes.setOnClickListener(this)
        bale.setOnClickListener(this)
        mba.setOnClickListener(this)
        hal.setOnClickListener(this)

        next.setOnClickListener {
            var animat = AnimationUtils.loadAnimation(this,R.anim.anim)
            if (index == list.size-1){
                index = 0
            }else index++
            main.startAnimation(animat)
            main.setImageDrawable(list[index].background)
        }
        prev.setOnClickListener {
            var animat = AnimationUtils.loadAnimation(this,R.anim.anim2)
            if (index == 0){
                index = list.size-1
            }else index--
            main.startAnimation(animat)
            main.setImageDrawable(list[index].background)
        }
        card.setOnClickListener {
            card.visibility = View.INVISIBLE
        }
    }

    override fun onClick(p0: View?) {
        var a = findViewById<ImageView>(p0!!.id)

        for (i in 0..list.size-1){
            if (list[i].id == a.id){
                index = i
            }
        }

        main.setImageDrawable(a.background)
        card.visibility = View.VISIBLE
    }
}