package com.rodriguez.basketballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.rodriguez.basketballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //ViewModel
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //DataBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel

        //ViewModel Observer
        binding.lifecycleOwner = this

        //Button Actions
        addListeners()
    }

    private fun addListeners() {
        //INVITADO
        binding.btnGuest1.setOnClickListener() {
            viewModel.addPoints(1, false)
        }

        binding.btnGuest2.setOnClickListener() {
            viewModel.addPoints(2, false)
        }

        binding.minusGuestBtn.setOnClickListener() {
            viewModel.subtractScore(false)
        }

        //LOCAL
        binding.btnLocal1.setOnClickListener() {
            viewModel.addPoints(1, true)
        }

        binding.btnLocal2.setOnClickListener() {
            viewModel.addPoints(2, true)
        }

        binding.minusLocalBtn.setOnClickListener() {
            viewModel.subtractScore(true)
        }

        //RESET SCORE
        binding.resetBtn.setOnClickListener() {
            viewModel.resetScore()
        }

        //FINAL SCORE
        binding.nextBtn.setOnClickListener() {
            openResultActivity()
        }
    }

    private fun openResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.SCORE_GUEST_KEY, viewModel.scoreGuest.value!!.toInt())
        intent.putExtra(ResultActivity.SCORE_LOCAL_KEY, viewModel.scoreLocal.value!!.toInt())
        startActivity(intent)
    }

}