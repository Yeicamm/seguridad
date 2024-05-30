package com.example.cuestionario;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.RadarEntry;

import java.util.ArrayList;

public class FifthActivity extends AppCompatActivity {

    private RadarChart radarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        radarChart = findViewById(R.id.radarChart);
        Button goToSixthActivityButton = findViewById(R.id.goToSixthActivityButton);

        Intent intent = getIntent();
        int[] calificaciones = intent.getIntArrayExtra("CALIFICACIONES");

        // Verifica si los datos de calificaciones no son nulos y si hay suficientes datos
        if (calificaciones != null && calificaciones.length == 14) {
            // Crear una lista de entradas para la gráfica de radar
            ArrayList<RadarEntry> entries = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                entries.add(new RadarEntry(calificaciones[i])); // Agrega la calificación para este dominio
            }

            // Configurar el conjunto de datos para la gráfica de radar
            RadarDataSet dataSet = new RadarDataSet(entries, "Calificacion Actual");
            dataSet.setColor(Color.BLUE);
            dataSet.setDrawFilled(true);

            // Configurar la data y los ejes de la gráfica de radar
            RadarData data = new RadarData(dataSet);
            String[] labels = {
                    "Políticas de SI", "Org. de SI", "Seg. Recursos Humanos", "Gestión de Activos",
                    "Control de Acceso", "Criptografía", "Seg. Física y del Entorno",
                    "Seg. de Operaciones", "Seg. de Comunicaciones", "Desarrollo y Mant.",
                    "Relaciones con Proveedores", "Gestión de Incidentes",
                    "Cont. del Negocio", "Cumplimiento"
            };

            XAxis xAxis = radarChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
            xAxis.setTextColor(Color.BLACK);
            xAxis.setTextSize(8f); // Ajusta el tamaño del texto de las etiquetas
            xAxis.setLabelRotationAngle(0f); // Rotar las etiquetas si es necesario

            // Configurar la gráfica de radar
            radarChart.getDescription().setEnabled(false);
            radarChart.setData(data);
            radarChart.invalidate();
        } else {
            // Manejar el caso en el que no se reciben suficientes datos de calificaciones
            Toast.makeText(this, "No se recibieron suficientes datos de calificaciones", Toast.LENGTH_SHORT).show();
        }

        // Configurar el listener para el botón
        goToSixthActivityButton.setOnClickListener(v -> {
            Intent intentToSixth = new Intent(FifthActivity.this, SixthActivity.class);
            startActivity(intentToSixth);
        });
    }
}

