package com.example.studenthome.presentation

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.studenthome.R

class PreviewActivity : AppCompatActivity(){
    private lateinit var title: TextView
    private lateinit var img: ImageView
    private lateinit var desc: TextView
    private lateinit var nextClickableText: TextView
    private lateinit var skipClickableText: TextView
    private lateinit var floatBtn: ImageView
    private var activityState ="STATE_ONE"
    private val stateOne ="STATE_ONE"
    private val stateTwo = "STATE_TWO"
    private val stateThree = "STATE_THREE"
    private val stateFour = "STATE_FOUR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previu)
        title = findViewById(R.id.prevTitle)
        img = findViewById(R.id.prev_image)
        desc = findViewById(R.id.prevDec)
        nextClickableText = findViewById(R.id.next_prev)
        skipClickableText = findViewById(R.id.skip_prev)
        floatBtn = findViewById(R.id.bottom_dots)

        skipClickableText.setOnClickListener {
            Log.e(TAG, "onClick: the skip clickable text", )
            Intent(this,MainActivity::class.java)
        }
        nextClickableText.setOnClickListener {
            Log.e(TAG, "onClick: the next clickable text", )
            showActivity(activityState)
        }
        floatBtn.setOnClickListener {
            Log.e(TAG, "onClick: the flot clickable img", )
            if (activityState == stateFour) {
                Intent(this, MainActivity::class.java)
            }
        }
    }

    private fun showActivity(state: String){
        when(state){
            stateOne -> showFirstPrev()
            stateTwo -> showSecondPrev()
            stateThree -> showTheirsPrev()
            stateFour ->showForthPrev()
        }
    }

    private fun showForthPrev() {
        imageAnimation(img, R.drawable.map_colour)
        bottomDotsAnimation(floatBtn, R.drawable.float_btn)
        titleAnimation(title, R.string.any_where_in_morocco_prev)
        decAnimation(desc, R.string.get_start_now_prev)
    }

    private fun showTheirsPrev() {
        activityState = stateFour
        imageAnimation(img, R.drawable.mobile_article)
        bottomDotsAnimation(floatBtn, R.drawable.prev_dots3)
        titleAnimation(title, R.string.this_app_prev)
        decAnimation(desc, R.string.will_help_you_prev)
    }

    private fun showSecondPrev() {
        activityState=stateThree
        imageAnimation(img, R.drawable.storefront)
        bottomDotsAnimation(floatBtn, R.drawable.prev_dots2)
        titleAnimation(title, R.string.Or_Your_Are_Broker_prev)
        decAnimation(desc, R.string.you_have_house_prev)
    }

    private fun showFirstPrev() {
        activityState=stateTwo
    }


    @SuppressLint("Recycle")
    private fun imageAnimation(imgPosition: ImageView, newImageView: Int){
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(imgPosition,View.TRANSLATION_X,1500f)
        val backAnimator: ObjectAnimator = ObjectAnimator.ofFloat(imgPosition,View.TRANSLATION_X,0f)
        objectAnimator.duration= 1000
        backAnimator.duration = 1000
        objectAnimator.start()
        if (!objectAnimator.isRunning){
            imgPosition.setImageResource(newImageView)
            backAnimator.start()
        }



    }
    private fun titleAnimation(textPosition: TextView, newText: Int){
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(textPosition,View.TRANSLATION_Y,-200f)

        objectAnimator.repeatCount = 1
        objectAnimator.repeatMode = ObjectAnimator.REVERSE
        objectAnimator.duration= 2000
        objectAnimator.start()
        textPosition.text = resources.getText(newText)
    }
    private fun decAnimation(textPosition: TextView, newText: Int){
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(textPosition,View.ALPHA,0f)

        objectAnimator.repeatCount = 1
        objectAnimator.repeatMode = ObjectAnimator.REVERSE
        objectAnimator.duration= 1000
        objectAnimator.start()
        textPosition.text = resources.getText(newText)

    }
    private fun bottomDotsAnimation(imgPosition: ImageView, newImageView: Int){
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(imgPosition,View.TRANSLATION_Y,200f)
        objectAnimator.repeatCount = 1
        objectAnimator.repeatMode = ObjectAnimator.REVERSE
        objectAnimator.duration= 1000
        objectAnimator.start()
        imgPosition.setImageResource(newImageView)

    }

}