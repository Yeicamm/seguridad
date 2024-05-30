package com.example.cuestionario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    private TextView promedioCalificacionesTextView;
    private TextView evaluacionEfectividadTextView;
    private int[] calificaciones = new int[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        promedioCalificacionesTextView = findViewById(R.id.promedioCalificacionesTextView);
        evaluacionEfectividadTextView = findViewById(R.id.evaluacionEfectividadTextView);

        int[] editTextIds = {
                R.id.calificacion1, R.id.calificacion2, R.id.calificacion3, R.id.calificacion4,
                R.id.calificacion5, R.id.calificacion6, R.id.calificacion7, R.id.calificacion8,
                R.id.calificacion9, R.id.calificacion10, R.id.calificacion11, R.id.calificacion12,
                R.id.calificacion13, R.id.calificacion14
        };

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(view -> {
            for (int i = 0; i < editTextIds.length; i++) {
                EditText editText = findViewById(editTextIds[i]);
                String text = editText.getText().toString();
                calificaciones[i] = text.isEmpty() ? 0 : Integer.parseInt(text);
            }

            double promedio = calcularPromedio(calificaciones);
            promedioCalificacionesTextView.setText("Promedio de calificaciones: " + promedio);

            String evaluacionEfectividad = calcularEvaluacionEfectividad(promedio);
            evaluacionEfectividadTextView.setText("Evaluación de efectividad: " + evaluacionEfectividad);
        });

        Button goToFifthActivityButton = findViewById(R.id.goToFifthActivityButton);
        goToFifthActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
            intent.putExtra("CALIFICACIONES", calificaciones);
            startActivity(intent);
        });
    }

    private double calcularPromedio(int[] calificaciones) {
        int sum = 0;
        for (int calificacion : calificaciones) {
            sum += calificacion;
        }
        return (double) sum / calificaciones.length;
    }

    private String calcularEvaluacionEfectividad(double promedio) {
        if (promedio <= 1) {
            return "INEXISTENTE";
        } else if (promedio <= 20) {
            return "INICIAL";
        } else if (promedio <= 40) {
            return "REPETIBLE";
        } else if (promedio <= 60) {
            return "EFECTIVO";
        } else if (promedio <= 80) {
            return "OPTIMIZADO";
        } else {
            return "EXCELENTE";
        }
    }
}
