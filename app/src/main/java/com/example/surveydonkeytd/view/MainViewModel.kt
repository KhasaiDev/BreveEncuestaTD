package com.example.surveydonkeytd.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Aqui llega la informacion sobre el primer fragmento y sus Checkbox
    private val _colorPreferido1 = MutableLiveData<Boolean>()
    private val _colorPreferido2 = MutableLiveData<Boolean>()
    private val _colorPreferido3 = MutableLiveData<Boolean>()

    val colorPreferido1: LiveData<Boolean> get() = _colorPreferido1
    val colorPreferido2: LiveData<Boolean> get() = _colorPreferido2
    val colorPreferido3: LiveData<Boolean> get() = _colorPreferido3

    fun setColorPreferido1(color: Boolean) {
        _colorPreferido1.value = color
    }

    fun setColorPreferido2(color: Boolean) {
        _colorPreferido2.value = color
    }

    fun setColorPreferido3(color: Boolean) {
        _colorPreferido3.value = color
    }

    //Vamos a repetir lo mismo para el segundo fragmento para que no se junte la informacion
    private val _materialPreferido1 = MutableLiveData<Boolean>()
    private val _materialPreferido2 = MutableLiveData<Boolean>()
    private val _materialPreferido3 = MutableLiveData<Boolean>()

    val materialPreferido1: LiveData<Boolean> get() = _materialPreferido1
    val materialPreferido2: LiveData<Boolean> get() = _materialPreferido2
    val materialPreferido3: LiveData<Boolean> get() = _materialPreferido3

    fun setMaterialPreferido1(color: Boolean) {
        _materialPreferido1.value = color
    }

    fun setMaterialPreferido2(color: Boolean) {
        _materialPreferido2.value = color
    }

    fun setMaterialPreferido3(color: Boolean) {
        _materialPreferido3.value = color
    }

    //Por ultimo repetimos lo mismo para el tercer fragmento y su informacion
    private val _correaPreferida1 = MutableLiveData<Boolean>()
    private val _correaPreferida2 = MutableLiveData<Boolean>()
    private val _correaPreferida3 = MutableLiveData<Boolean>()
    private val _correaPreferida4 = MutableLiveData<Boolean>()

    val correaPreferida1: LiveData<Boolean> get() = _correaPreferida1
    val correaPreferida2: LiveData<Boolean> get() = _correaPreferida2
    val correaPreferida3: LiveData<Boolean> get() = _correaPreferida3
    val correaPreferida4: LiveData<Boolean> get() = _correaPreferida4

    fun setCorreaPreferida1(color: Boolean) {
        _correaPreferida1.value = color
    }

    fun setCorreaPreferida2(color: Boolean) {
        _correaPreferida2.value = color
    }

    fun setCorreaPreferida3(color: Boolean) {
        _correaPreferida3.value = color
    }

    fun setCorreaPreferida4(color: Boolean) {
        _correaPreferida4.value = color
    }


    // Agregar métodos y LiveData adicionales según sea necesario para email y sugerencia
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _sugerencia = MutableLiveData<String>()
    val sugerencia: LiveData<String> get() = _sugerencia

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setSugerencia(sugerencia: String) {
        _sugerencia.value = sugerencia
    }

}
