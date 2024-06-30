package com.example.surveydonkeytd.view.quest2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentSecondQuestionBinding
import com.example.surveydonkeytd.view.MainViewModel

class SecondQuestionFragment : Fragment() {

    private var _binding: FragmentSecondQuestionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Primer CheckBox
        binding.answer21.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setMaterialPreferido1(isChecked)
        }
        viewModel.materialPreferido1.observe(viewLifecycleOwner) { materialPreferido1 ->
            binding.answer21.isChecked = materialPreferido1
        }

        // Segunda opción
        binding.answer22.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setMaterialPreferido2(isChecked)
        }
        viewModel.materialPreferido2.observe(viewLifecycleOwner) { materialPreferido2 ->
            binding.answer22.isChecked = materialPreferido2
        }

        // Tercera Opción
        binding.answer23.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setMaterialPreferido3(isChecked)
        }
        viewModel.materialPreferido3.observe(viewLifecycleOwner) { materialPreferido3 ->
            binding.answer23.isChecked = materialPreferido3
        }

        // Botón de navegación al siguiente fragmento
        binding.boton2.setOnClickListener {
            findNavController().navigate(R.id.action_secondQuestionFragment_to_thirdQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}