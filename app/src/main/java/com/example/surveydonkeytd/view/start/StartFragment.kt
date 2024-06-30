package com.example.surveydonkeytd.view.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentForthBinding
import com.example.surveydonkeytd.databinding.FragmentStartBinding
import com.example.surveydonkeytd.databinding.FragmentThirdQuestionBinding

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonStart.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_firstQuestionFragment) }
    }
}