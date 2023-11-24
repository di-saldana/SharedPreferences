package es.ua.eps.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.sharedpreferences.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {
    private lateinit var bindings: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityDetalleBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(root)

            button.setOnClickListener {
                val intent = Intent(this@DetalleActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}