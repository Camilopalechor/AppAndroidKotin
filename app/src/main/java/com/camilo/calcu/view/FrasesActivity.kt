package com.camilo.calcu.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.camilo.calcu.databinding.ActivityFrasesBinding
import com.camilo.calcu.viewmodel.QuoteViewModel

class FrasesActivity : AppCompatActivity() {
     lateinit var binding:ActivityFrasesBinding
     val quoteViewModel:QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Aqui tienetodo el activity
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        //Raiz de la vista
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.txtQuote.text = it.quote
            binding.txtAutor.text = it.author

        })

        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}