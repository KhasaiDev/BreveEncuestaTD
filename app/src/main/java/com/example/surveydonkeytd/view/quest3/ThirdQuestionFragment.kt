package com.example.surveydonkeytd.view.quest3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentThirdQuestionBinding
import com.example.surveydonkeytd.view.MainViewModel

class ThirdQuestionFragment : Fragment() {
    private var _binding: FragmentThirdQuestionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Primer CheckBox
        binding.answer31.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setCorreaPreferida1(isChecked)
        }
        viewModel.correaPreferida1.observe(viewLifecycleOwner) { correaPreferida1 ->
            binding.answer31.isChecked = correaPreferida1
        }

        // Segunda opción
        binding.answer32.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setCorreaPreferida2(isChecked)
        }
        viewModel.correaPreferida2.observe(viewLifecycleOwner) { correaPreferida2 ->
            binding.answer32.isChecked = correaPreferida2
        }

        // Tercera Opción
        binding.answer33.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setCorreaPreferida3(isChecked)
        }
        viewModel.correaPreferida3.observe(viewLifecycleOwner) { correaPreferida3 ->
            binding.answer33.isChecked = correaPreferida3
        }

        // Cuarta Opción
        binding.answer34.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setCorreaPreferida4(isChecked)
        }
        viewModel.correaPreferida4.observe(viewLifecycleOwner) { correaPreferida4 ->
            binding.answer34.isChecked = correaPreferida4
        }

        // Botón de navegación al siguiente fragmento
        binding.boton3.setOnClickListener {
            findNavController().navigate(R.id.action_thirdQuestionFragment_to_forthFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}