package com.example.sharedpreferences

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesHelper: PreferencesHelper
    private lateinit var textView: TextView
    private lateinit var previewTextView: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesHelper = PreferencesHelper(this)
        textView = findViewById(R.id.textView)
        previewTextView = findViewById(R.id.previewTextView)
        seekBar = findViewById(R.id.seekBar)
        btnSave = findViewById(R.id.btnSave)

        val savedFontSize = preferencesHelper.getFontSize()
        textView.textSize = savedFontSize
        previewTextView.textSize = savedFontSize
        seekBar.progress = savedFontSize.toInt()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val newSize = progress.toFloat()
                textView.textSize = newSize
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnSave.setOnClickListener {
            val currentSize = textView.textSize
            preferencesHelper.saveFontSize(currentSize)

            previewTextView.text = textView.text
            previewTextView.textSize = currentSize

            Toast.makeText(this, "Đã lưu kích thước phông chữ: $currentSize", Toast.LENGTH_SHORT).show()
        }
    }
}
