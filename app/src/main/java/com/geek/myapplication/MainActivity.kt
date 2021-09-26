package com.geek.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geek.myapplication.databinding.ActivityMain2Binding
import com.geek.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var send: Intent
    private lateinit var binding: ActivityMainBinding

    private val sendData =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                binding.etFirst.setText(it.data?.getStringExtra(Keys.KEY_2))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nextActivity()
    }

    private fun nextActivity() {
        send = Intent(this, MainActivity2::class.java)

        binding.btnNext.setOnClickListener {
            if (binding.etFirst.text.isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.empty_et), Toast.LENGTH_SHORT).show()
            } else {
                send.putExtra(Keys.KEY_1, binding.etFirst.text.toString())
                sendData.launch(send)
            }
        }
    }
}

object Keys {
    const val KEY_1 = "KEY_1"
    const val KEY_2 = "KEY_2"
}