package es.ua.eps.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ua.eps.sharedpreferences.databinding.ActivityMainJavaBinding;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainJavaBinding viewBinding;
    private EditText editText;
    private SeekBar seekBar;
    private TextView textoView;
    private TextView tamanoView;
    private Button button;
    private Button buttonCerrar;
    private ImageButton buttonKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainJavaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        editText = viewBinding.editText;
        seekBar = viewBinding.seekBar;
        textoView = viewBinding.texto;
        tamanoView = viewBinding.tamano;
        button = viewBinding.button;
        buttonCerrar = viewBinding.buttonCerrar;
        buttonKotlin = viewBinding.buttonKotlin;

        updateValues();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSharedPreferences();
                Intent intent = new Intent(MainJavaActivity.this, DetalleJavaActivity.class);
                startActivity(intent);
            }
        });

        buttonCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainJavaActivity.this, MainKotlinActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveSharedPreferences() {
        String texto = editText.getText().toString();
        int tamano = seekBar.getProgress();

        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("texto", UtilsJava.encrypt(texto));
        editor.putInt("tamano", tamano);
//        editor.commit();
        editor.apply();
    }

    private void updateValues() {
        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String textData = prefs.getString("texto", "Hola Mundo!");
        int textValue = prefs.getInt("tamano", 32);

        textoView.setText("Texto: " + UtilsJava.decrypt(textData));
        tamanoView.setText("Tamaño: " + textValue);
    }
}
