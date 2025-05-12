package com.example.katas.presentation.play

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katas.R
import com.example.katas.databinding.FragmentPlayBinding


class PlayFragment : Fragment(R.layout.fragment_play) {
    private  lateinit var binding: FragmentPlayBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentPlayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.texto.text = " fragment play  "
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false)
    }


}
