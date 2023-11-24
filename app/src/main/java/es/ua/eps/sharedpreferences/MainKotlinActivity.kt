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

            button.setOnClickListener {
                saveSharedPreferences()
                // setCambios()
                val intent = Intent(this@MainKotlinActivity, DetalleKotlinActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun encrypt(input: String?): String {
        return Base64.encodeToString(input?.toByteArray(), Base64.DEFAULT)
    }
    fun decrypt(input: String?): String {
        return String(Base64.decode(input?.toByteArray(), Base64.DEFAULT))
    }

    fun saveSharedPreferences() {
        val texto = bindings.editText.text
        val tamano = bindings.seekBar.progress

        val prefs: SharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("texto", "TEST")// texto.toString())
        editor.putInt("tamano", 32) //tamano.toString())
        // editor.commit();  // wait until ends
        editor.apply() // do it in background
    }

    fun setCambios() {
        // val texto = getPrefs
        // val value = getPrefs

        // bindings.texto.text = "Texto:" + texto
        // bindings.tamano.text = "Tamaño:" + value
    }


}