package com.example.surveydonkeytd.view.quest1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentFirstQuestionBinding
import com.example.surveydonkeytd.view.MainViewModel

class FirstQuestionFragment : Fragment() {
    private var _binding: FragmentFirstQuestionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //CheckBox 1
        binding.answer11.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setColorPreferido1(isChecked)
        }
        viewModel.colorPreferido1.observe(viewLifecycleOwner) { colorPreferido1 ->
            binding.answer11.isChecked = colorPreferido1
        }

        //CheckBox 2
        binding.answer12.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setColorPreferido2(isChecked)
        }
        viewModel.colorPreferido2.observe(viewLifecycleOwner) { colorPreferido2 ->
            binding.answer12.isChecked = colorPreferido2
        }

        //CheckBox 3
        binding.answer13.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setColorPreferido3(isChecked)
        }
        viewModel.colorPreferido3.observe(viewLifecycleOwner) { colorPreferido3 ->
            binding.answer13.isChecked = colorPreferido3
        }

        //Boton
        binding.boton1.setOnClickListener {
            findNavController().navigate(R.id.action_firstQuestionFragment_to_secondQuestionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}