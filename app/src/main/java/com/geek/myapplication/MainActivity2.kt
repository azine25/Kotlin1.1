package com.geek.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geek.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult()
        sendData()
    }

    private fun sendData() {
        binding.btnSecondNext.setOnClickListener {
            if (binding.etSecond.text.isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.empty_et), Toast.LENGTH_SHORT).show()
            } else {
                setResult(
                    RESULT_OK,
                    Intent(this, MainActivity::class.java).putExtra(
                        Keys.KEY_2,
                        binding.etSecond.text.toString()
                    )
                )
                finish()
            }
        }
    }

    private fun getResult() {
        binding.etSecond.setText(intent?.getStringExtra(Keys.KEY_1))
    }

}