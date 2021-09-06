package com.kikianju.image

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var startX = 0.0f
    var startY = 0.0f

    var leftMargin = 0
    var topMargin = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kotlin에서는 carImageView를 패퀴지 변수라고 한다.
        carImageView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                        println("손가락이 눌렸어요.")

                        startX = event.x
                        startY = event.y
                    }
                    MotionEvent.ACTION_MOVE -> {
                        println("손가락을 눌렸어요.")
                        val diffX = event.x - startX
                        val diffY = event.y - startY

                        leftMargin += diffX.toInt()
                        topMargin += diffY.toInt()

                        val layoutParams = FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.WRAP_CONTENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT
                        )
                        layoutParams.leftMargin = leftMargin
                        layoutParams.topMargin = topMargin

                        carImageView.layoutParams = layoutParams
                    }
                }
                return@setOnTouchListener true

            }
        }
        fun println(message: String) {
            Log.d("Main", message)
        }
    }