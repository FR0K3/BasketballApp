package com.rodriguez.basketballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rodriguez.basketballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var scoreLocal = 0
    var scoreGuest = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //DataBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Button Actions
        addListeners(binding)
    }

    private fun addListeners(binding: ActivityMainBinding) {
        //INVITADO
        binding.btnGuest1.setOnClickListener() {
            scoreGuest++
            binding.scoreGuestText.text = scoreGuest.toString()
        }

        binding.btnGuest2.setOnClickListener() {
            scoreGuest += 2
            binding.scoreGuestText.text = scoreGuest.toString()
        }

        binding.minusGuestBtn.setOnClickListener() {
            if (scoreGuest > 0) {
                scoreGuest--
                binding.scoreGuestText.text = scoreGuest.toString()
            } else {
                Toast.makeText(this, "Valor no permitido", Toast.LENGTH_SHORT).show()
            }
        }

        //LOCAL
        binding.btnLocal1.setOnClickListener() {
            scoreLocal++
            binding.scoreLocalText.text = scoreLocal.toString()
        }

        binding.btnLocal2.setOnClickListener() {
            scoreLocal += 2
            binding.scoreLocalText.text = scoreLocal.toString()
        }

        binding.minusLocalBtn.setOnClickListener() {
            if (scoreLocal > 0) {
                scoreLocal--
                binding.scoreLocalText.text = scoreLocal.toString()
            } else {
                Toast.makeText(this, "Valor no permitido", Toast.LENGTH_SHORT).show()
            }
        }

        //RESET SCORE
        binding.resetBtn.setOnClickListener() {
            binding.scoreGuestText.text = "0"
            binding.scoreLocalText.text = "0"
        }

        //FINAL SCORE
        binding.nextBtn.setOnClickListener(){
            openResultActivity()
        }
    }

    private fun openResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.SCORE_GUEST_KEY, scoreGuest)
        intent.putExtra(ResultActivity.SCORE_LOCAL_KEY, scoreLocal)
        startActivity(intent)
    }

}