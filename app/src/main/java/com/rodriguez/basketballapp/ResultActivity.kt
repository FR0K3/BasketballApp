package com.rodriguez.basketballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rodriguez.basketballapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val localScore = bundle.getInt(SCORE_LOCAL_KEY).toString()
        val guestScore = bundle.getInt(SCORE_GUEST_KEY).toString()
        Log.d("BUM", localScore)

        binding.scoreText.text = "$localScore - $guestScore"

        if (localScore > guestScore) {
            binding.resultText.text = "¡Ganó el equipo local!"
        } else if(localScore < guestScore){
            binding.resultText.text = "¡Gananaron los visitantes!"
        } else{
            binding.resultText.text = "Fue un empate \uD83D\uDE15"
        }
    }

    companion object {
        const val SCORE_LOCAL_KEY = "scoreLocal"
        const val SCORE_GUEST_KEY = "scoreGuest"
    }
}