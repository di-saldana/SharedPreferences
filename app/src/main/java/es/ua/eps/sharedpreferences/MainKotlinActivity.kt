package es.ua.eps.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import es.ua.eps.sharedpreferences.databinding.ActivityMainKotlinBinding

class MainKotlinActivity : AppCompatActivity() {
    private lateinit var bindings: ActivityMainKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainKotlinBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(root)

            updateValues()

            button.setOnClickListener {
                saveSharedPreferences()
                val intent = Intent(this@MainKotlinActivity, DetalleKotlinActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun saveSharedPreferences() {
        val texto = bindings.editText.text
        val tamano = bindings.seekBar.progress

        val prefs: SharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("texto", Encryption.encrypt(texto.toString())) // Encryption.encrypt(texto.toString()))
        editor.putInt("tamano", tamano) // Encryption.encrypt(tamano.toString()).toInt())
        // editor.commit();  // wait until ends
        editor.apply() // do it in background
    }

    fun updateValues() {
        val prefs: SharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val textData: String? = prefs.getString("texto", "Hola Mundo!")
        val textValue: Int? = prefs.getInt("tamano", 32)

        if (textValue != null) {
            bindings.texto.text = "Texto: " + Encryption.decrypt(textData)
            bindings.tamano.text = "Tamaño: " + textValue.toString() // .decrypt(textValue.toString()).toFloat()
        }
    }


}