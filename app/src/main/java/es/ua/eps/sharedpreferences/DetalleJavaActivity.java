package es.ua.eps.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ua.eps.sharedpreferences.databinding.ActivityDetalleJavaBinding;

public class DetalleJavaActivity extends AppCompatActivity {

    private ActivityDetalleJavaBinding viewBinding;
    private TextView textoView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityDetalleJavaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        textoView = viewBinding.texto;
        button = viewBinding.button;

        updateValues();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleJavaActivity.this, MainJavaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateValues() {
        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String textData = prefs.getString("texto", "Hola Mundo!");
        int textValue = prefs.getInt("tamano", 32);

        textoView.setText(UtilsJava.decrypt(textData));
        textoView.setTextSize(Float.valueOf(textValue));
    }
}
