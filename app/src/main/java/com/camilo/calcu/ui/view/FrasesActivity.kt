package com.camilo.calcu.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.camilo.calcu.databinding.ActivityFrasesBinding
import com.camilo.calcu.ui.viewmodel.QuoteViewModel

class FrasesActivity : AppCompatActivity() {
     lateinit var binding:ActivityFrasesBinding
     val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Aqui tienetodo el activity
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        //Raiz de la vista
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.txtQuote.text = it?.quote
            binding.txtAutor.text = it?.author

        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}