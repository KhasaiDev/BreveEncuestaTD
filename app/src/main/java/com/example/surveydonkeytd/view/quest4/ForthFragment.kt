package com.example.surveydonkeytd.view.quest4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentFirstQuestionBinding
import com.example.surveydonkeytd.databinding.FragmentForthBinding
import com.example.surveydonkeytd.view.MainViewModel

class ForthFragment : Fragment() {
    private var _binding: FragmentForthBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.emailInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newValue = s.toString()
                if (viewModel.email.value != newValue) {
                    viewModel.setEmail(newValue)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        viewModel.email.observe(viewLifecycleOwner) { email -> if (binding.emailInput.text.toString() != email) {binding.emailInput.setText(email)}}


        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newValue = s.toString()
                if (viewModel.sugerencia.value != newValue) {
                    viewModel.setSugerencia(newValue)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        viewModel.sugerencia.observe(viewLifecycleOwner) { sugerencia -> if (binding.editText.text.toString() != sugerencia) {binding.editText.setText(sugerencia)}}

        binding.boton4.setOnClickListener {
            findNavController().navigate(R.id.action_forthFragment_to_endFragment)
        }
    }
}