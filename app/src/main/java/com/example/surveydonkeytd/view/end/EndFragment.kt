package com.example.surveydonkeytd.view.end

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.surveydonkeytd.R
import com.example.surveydonkeytd.databinding.FragmentEndBinding
import com.example.surveydonkeytd.databinding.FragmentFirstQuestionBinding
import com.example.surveydonkeytd.view.MainViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Suppress("DEPRECATION")
class EndFragment : Fragment() {
    private val REQUEST_PERMISSION_CODE = 123
    private var _binding: FragmentEndBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa los LiveData de los colores preferidos
        viewModel.colorPreferido1.observe(viewLifecycleOwner) { colorPreferido1 -> updateSelectedColors() }
        viewModel.colorPreferido2.observe(viewLifecycleOwner) { colorPreferido2 -> updateSelectedColors() }
        viewModel.colorPreferido3.observe(viewLifecycleOwner) { colorPreferido3 -> updateSelectedColors() }

        //Observa los LiveData de los materiales preferidos
        viewModel.materialPreferido1.observe(viewLifecycleOwner) { materialPreferido1 -> updateSelectedMaterials() }
        viewModel.materialPreferido2.observe(viewLifecycleOwner) { materialPreferido2 -> updateSelectedMaterials() }
        viewModel.materialPreferido3.observe(viewLifecycleOwner) { materialPreferido3 -> updateSelectedMaterials() }

        //Observa los LiveData de las correas preferidas
        viewModel.correaPreferida1.observe(viewLifecycleOwner) { correaPreferida1 -> updateSelectedCorreas() }
        viewModel.correaPreferida2.observe(viewLifecycleOwner) { correaPreferida2 -> updateSelectedCorreas() }
        viewModel.correaPreferida3.observe(viewLifecycleOwner) { correaPreferida3 -> updateSelectedCorreas() }
        viewModel.correaPreferida4.observe(viewLifecycleOwner) { correaPreferida4 -> updateSelectedCorreas() }

        // Observa el LiveData del email y muestra el texto correspondiente
        viewModel.email.observe(viewLifecycleOwner) { email -> binding.tvUserEmail.text = "Email: $email" }

        // Observa el LiveData de la sugerencia y muestra el texto correspondiente
        viewModel.sugerencia.observe(viewLifecycleOwner) { sugerencia -> binding.tvUserComment.text = "Sugerencia: $sugerencia" }

        // Configurar el botón de descarga
        binding.botonEnd.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // Permiso concedido, mostrar Toast de descarga
                showToast("Archivo descargado")
            } else {
                // Solicitar permiso al usuario
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_PERMISSION_CODE
                )
            }
        }

    }

    // Función para mostrar Toast
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }



    //Metodo para colores
    private fun updateSelectedColors() {
        // Obtén los valores actuales de los LiveData
        val color1 = viewModel.colorPreferido1.value ?: false
        val color2 = viewModel.colorPreferido2.value ?: false
        val color3 = viewModel.colorPreferido3.value ?: false

        // Construye el texto a mostrar basado en las selecciones
        val selectedColors = mutableListOf<String>()
        if (color1) {
            selectedColors.add("Rojo")
        }
        if (color2) {
            selectedColors.add("Azul")
        }
        if (color3) {
            selectedColors.add("Blanco")
        }

        // Actualiza el TextView con los colores seleccionados
        binding.tvFirstAnswer.text = "Colores seleccionados: ${selectedColors.joinToString(", ")}"
    }

    //Metodo para materiales
    private fun updateSelectedMaterials() {
        // Obtén los valores actuales de los LiveData
        val material1 = viewModel.materialPreferido1.value ?: false
        val material2 = viewModel.materialPreferido2.value ?: false
        val material3 = viewModel.materialPreferido3.value ?: false

        // Construye el texto a mostrar basado en las selecciones
        val selectedMaterials = mutableListOf<String>()
        if (material1) {
            selectedMaterials.add("Cuero")
        }
        if (material2) {
            selectedMaterials.add("Acero Inox.")
        }
        if (material3) {
            selectedMaterials.add("Aluminio")
        }

        // Actualiza el TextView con los materiales seleccionados
        binding.tvSecondAnswer.text = "Materiales seleccionados: ${selectedMaterials.joinToString(", ")}"
    }

    //Metodo para correas
    private fun updateSelectedCorreas() {
        // Obtén los valores actuales de los LiveData
        val correa1 = viewModel.correaPreferida1.value ?: false
        val correa2 = viewModel.correaPreferida2.value ?: false
        val correa3 = viewModel.correaPreferida3.value ?: false
        val correa4 = viewModel.correaPreferida4.value ?: false

        // Construye el texto a mostrar basado en las selecciones
        val selectedCorreas = mutableListOf<String>()
        if (correa1) {
            selectedCorreas.add("Negro")
        }
        if (correa2) {
            selectedCorreas.add("Azul Cobalto")
        }
        if (correa3) {
            selectedCorreas.add("Verde Lima")
        }
        if (correa4) {
            selectedCorreas.add("Ambar")
        }

        // Actualiza el TextView con los colores seleccionados
        binding.tvThirdAnswer.text = "Correas seleccionadas: ${selectedCorreas.joinToString(", ")}"
    }



    // Manejar el resultado de la solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, mostrar Toast de descarga
                showToast("Archivo descargado")
            } else {
                // Permiso denegado, mostrar mensaje
                showToast("Permiso de almacenamiento denegado, archivo no descargado")
            }
        }
    }



    //Funcion no integrada pero se deja para futuro analisis
//    private fun downloadFile() {
//        // Obtener los datos mostrados en los TextViews
//        val texto1 = binding.tvFirstAnswer.text.toString()
//        val texto2 = binding.tvSecondAnswer.text.toString()
//        val texto3 = binding.tvThirdAnswer.text.toString()
//        val email = binding.tvUserEmail.text.toString()
//        val comentario = binding.tvUserComment.text.toString()
//
//        // Crear el contenido del archivo JPG (puedes usar un Bitmap o simplemente texto)
//        val contenidoArchivo = """
//            Resultados:
//            $texto1
//            $texto2
//            $texto3
//
//            Correo electrónico: $email
//
//            Comentario:
//            $comentario
//        """.trimIndent()
//
//        // Crear un archivo temporal para guardar el contenido
//        val fileName = "resultados_${System.currentTimeMillis()}.jpg"
//        val file = File(requireContext().externalCacheDir, fileName)
//
//        try {
//            // ...
//
//            // Mostrar un mensaje de éxito
//            Toast.makeText(requireContext(), "Archivo descargado: $fileName", Toast.LENGTH_SHORT).show()
//
//            // Intent para abrir el archivo con aplicaciones que puedan manejar archivos de texto
//            val openFileIntent = Intent(Intent.ACTION_VIEW)
//            openFileIntent.setDataAndType(Uri.fromFile(file), "text/*")
//            openFileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//            val chooser = Intent.createChooser(openFileIntent, "Abrir archivo con...")
//            if (openFileIntent.resolveActivity(requireContext().packageManager) != null) {
//                startActivity(chooser)
//            } else {
//                Toast.makeText(requireContext(), "No se encontró una aplicación para abrir el archivo", Toast.LENGTH_SHORT).show()
//            }
//
//        } catch (e: IOException) {
//            e.printStackTrace()
//            Toast.makeText(requireContext(), "Error al descargar el archivo", Toast.LENGTH_SHORT).show()
//        }
//    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}