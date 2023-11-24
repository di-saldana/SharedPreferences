package es.ua.eps.sharedpreferences

import android.content.Intent
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
}