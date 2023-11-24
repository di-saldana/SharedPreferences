package es.ua.eps.sharedpreferences

import android.content.Intent
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

            button.setOnClickListener {
                val intent = Intent(this@DetalleKotlinActivity, MainKotlinActivity::class.java)
                startActivity(intent)
            }
        }
    }
}