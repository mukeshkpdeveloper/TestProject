package com.hexalitics.testproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.hexalitics.testproject.databinding.ActivityMainBinding
import com.hexalitics.testproject.databinding.ActivitySplashBinding
import com.hexalitics.testproject.util.TicketEdgeTreatment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

    }
}

val ticketShapePathModel = ShapeAppearanceModel
    .Builder()
    .setAllCorners(CornerFamily.ROUNDED, 36f)
    .setLeftEdge(TicketEdgeTreatment(36f))
    .setRightEdge(TicketEdgeTreatment(36f))
    .build()

class TicketDrawable : MaterialShapeDrawable(ticketShapePathModel)