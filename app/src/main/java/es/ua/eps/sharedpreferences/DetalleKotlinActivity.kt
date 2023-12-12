package es.ua.eps.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.sharedpreferences.databinding.ActivityDetalleKotlinBinding

class DetalleKotlinActivity : AppCompatActivity() {
    private lateinit var bindings: ActivityDetalleKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityDetalleKotlinBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(root)

            updateValues()

            button.setOnClickListener {
                val intent = Intent(this@DetalleKotlinActivity, MainKotlinActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun updateValues() {
        val prefs: SharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val textData: String? = prefs.getString("texto", "Hola Mundo!")
        val textValue: Int? = prefs.getInt("tamano", 32)

        if (textValue != null) {
            bindings.texto.text = UtilsKotlin.decrypt(textData)
            bindings.texto.textSize = textValue.toFloat()
        }
    }
}