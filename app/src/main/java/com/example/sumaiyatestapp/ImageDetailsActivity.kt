package com.example.sumaiyatestapp

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.contentarcade.adnan.shapedblurlibrary.GaussianBlur
import com.contentarcade.adnan.shapedblurlibrary.view.ShapeLayout
import com.example.sumaiyatestapp.databinding.ActivityImageDetailsBinding

class ImageDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailsBinding
    lateinit var shapeLayout: ShapeLayout
    var shapeType: Int = 1
    var size: Float = 0F
    var rad: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.hasExtra("shape")) {
            shapeType = intent.getIntExtra("shape", 1)
        }

        shapeLayout = binding.shapeLayoutOverlay
        binding.actualImage.setImageResource(R.drawable.img)

        when (shapeType) {
            1 -> {
                square()
            }
            2 -> {
                circle()
            }
            3 -> {
                rectangle()
            }
            else -> {
                cut()
            }
        }



        binding.blurRadiusSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rad = progress
                when (rad) {
                    0 -> {
                        applyBlur(rad+1, size)
                    }
                    else -> {
                        applyBlur(rad, size)
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        binding.blurAreaSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                size = progress.toFloat()
                applyBlur(rad, size)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })


    }

    private fun applyBlur(rad: Int, size: Float) {
        GaussianBlur.with(this).radius(rad).size(size).put(R.drawable.img, binding.blurredImage)
    }


    private fun rectangle() {
        shapeLayout.setTypeOfShape(ShapeLayout.ShapeType.RECTANGLE)
    }

    private fun circle() {
        shapeLayout.setTypeOfShape(ShapeLayout.ShapeType.CIRCLE)
    }

    private fun square() {
        shapeLayout.setTypeOfShape(ShapeLayout.ShapeType.SQUARE)
    }

    private fun cut() {
        shapeLayout.setTypeOfShape(ShapeLayout.ShapeType.CUT)
    }

}