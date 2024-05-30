package com.example.cuestionario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Obtener el LinearLayout del layout
        LinearLayout layout = findViewById(R.id.layout);

        // Crear TextView y EditText para cada pregunta y respuesta
        crearPreguntaRespuesta(layout, "Tipo de entidad (Publica, Privada, Mixta):", "Escribe tu respuesta", "dato6");
        crearPreguntaRespuesta(layout, "Misión:", "Escribe tu respuesta", "dato7");
        crearPreguntaRespuesta(layout, "Mapa de Procesos:", "Escribe tu respuesta", "dato8");
        crearPreguntaRespuesta(layout, "Políticas de seguridad de la información formalizada y firmada", "Escribe tu respuesta", "dato9");
        crearPreguntaRespuesta(layout, "Organigrama, roles y responsabilidades de seguridad de la información, asignación del recurso humano y comunicación de roles y responsabilidades:", "Escribe tu respuesta", "dato10");
        crearPreguntaRespuesta(layout, "Documento con el resultado de la autoevaluación realizada a la Entidad, de la gestión de la seguridad y privacidad de la información e infraestructura de red de comunicaciones (IPv4/IPv6), revisado y aprobado por la alta dirección:", "Escribe tu respuesta", "dato11");
        crearPreguntaRespuesta(layout, "Documento con el resultado de la herramienta de la encuesta de diagnóstico de seguridad y privacidad de la información, revisado, aprobado y aceptado por la alta dirección:", "Escribe tu respuesta", "dato12");
        crearPreguntaRespuesta(layout, "Documento con el resultado de la estratificación de la entidad, aceptado y aprobado por la alta dirección:", "Escribe tu respuesta", "dato13");
        crearPreguntaRespuesta(layout, "Metodología de Gestión de riesgos:", "Escribe tu respuesta", "dato14");
        crearPreguntaRespuesta(layout, "Riesgos identificados y valorados de acuerdo a la metodología:", "Escribe tu respuesta", "dato15");
        crearPreguntaRespuesta(layout, "Planes de tratamiento de los riesgos:", "Escribe tu respuesta", "dato16");
        crearPreguntaRespuesta(layout, "Procedimiento de verificación de antecedentes para candidatos a un empleo en la entidad:", "Escribe tu respuesta", "dato17");
        crearPreguntaRespuesta(layout, "Inventario de activos de información clasificados, de la entidad, revisado y aprobado por la alta dirección:", "Escribe tu respuesta", "dato18");
        crearPreguntaRespuesta(layout, "Inventario de áreas de procesamiento de información y telecomunicaciones:", "Escribe tu respuesta", "dato19");
        crearPreguntaRespuesta(layout, "Diagrama de red de alto nivel o arquitectura de TI:", "Escribe tu respuesta", "dato20");
        crearPreguntaRespuesta(layout, "Plan de continuidad de la Entidad aprobado:", "Escribe tu respuesta", "dato21");
        crearPreguntaRespuesta(layout, "Procedimientos, manuales, guías, directrices, lineamientos, estándares, instructivos relacionados con seguridad de la información, el modelo de seguridad y privacidad de la información de MinTic y Gobierno en Línea:", "Escribe tu respuesta", "dato22");

        // Agregar el botón
        Button siguienteButton = new Button(this);
        siguienteButton.setText("Siguiente");
        layout.addView(siguienteButton);

        // Agregar el evento onClick al botón
        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCamposLlenos(layout)) {
                    // Guardar los datos en DatosCuestionario
                    guardarDatosEnDatosCuestionario(layout);
                    // Iniciar la tercera actividad pasando el rol seleccionado
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("rol", getIntent().getStringExtra("rol"));
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "Por favor, complete todos los campos antes de continuar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para guardar los datos en DatosCuestionario
    private void guardarDatosEnDatosCuestionario(LinearLayout layout) {
        int count = layout.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = layout.getChildAt(i);
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                String tag = (String) editText.getTag();
                if (tag != null) {
                    switch (tag) {
                        case "dato6":
                            DatosCuestionario.dato6 = editText.getText().toString();
                            break;
                        case "dato7":
                            DatosCuestionario.dato7 = editText.getText().toString();
                            break;
                        case "dato8":
                            DatosCuestionario.dato8 = editText.getText().toString();
                            break;
                        case "dato9":
                            DatosCuestionario.dato9 = editText.getText().toString();
                            break;
                        case "dato10":
                            DatosCuestionario.dato10 = editText.getText().toString();
                            break;
                        case "dato11":
                            DatosCuestionario.dato11 = editText.getText().toString();
                            break;
                        case "dato12":
                            DatosCuestionario.dato12 = editText.getText().toString();
                            break;
                        case "dato13":
                            DatosCuestionario.dato13 = editText.getText().toString();
                            break;
                        case "dato14":
                            DatosCuestionario.dato14 = editText.getText().toString();
                            break;
                        case "dato15":
                            DatosCuestionario.dato15 = editText.getText().toString();
                            break;
                        case "dato16":
                            DatosCuestionario.dato16 = editText.getText().toString();
                            break;
                        case "dato17":
                            DatosCuestionario.dato17 = editText.getText().toString();
                            break;
                        case "dato18":
                            DatosCuestionario.dato18 = editText.getText().toString();
                            break;
                        case "dato19":
                            DatosCuestionario.dato19 = editText.getText().toString();
                            break;
                        case "dato20":
                            DatosCuestionario.dato20 = editText.getText().toString();
                            break;
                        case "dato21":
                            DatosCuestionario.dato21 = editText.getText().toString();
                            break;
                        case "dato22":
                            DatosCuestionario.dato22 = editText.getText().toString();
                            break;
                        // Agrega más casos según sea necesario
                    }
                }
            }
        }
    }

    // Método para crear una pregunta y respuesta y agregarlas al layout
    private void crearPreguntaRespuesta(LinearLayout layout, String pregunta, String hint, String tag) {
        // Crear un TextView para la pregunta
        TextView preguntaTextView = new TextView(this);
        preguntaTextView.setText(pregunta);
        layout.addView(preguntaTextView);

        // Crear un EditText para la respuesta
        EditText respuestaEditText = new EditText(this);
        respuestaEditText.setHint(hint);
        respuestaEditText.setTag(tag);
        layout.addView(respuestaEditText);
    }

    // Método para validar que todos los campos estén llenos
    private boolean validarCamposLlenos(LinearLayout layout) {
        // Obtener el número de hijos del LinearLayout
        int count = layout.getChildCount();
        // Recorrer cada hijo del LinearLayout
        for (int i = 0; i < count; i++) {
            View view = layout.getChildAt(i);
            // Si el hijo es un EditText
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                // Si el campo está vacío, retornar falso
                if (editText.getText().toString().trim().isEmpty()) {
                    return false;
                }
            }
        }
        // Si todos los campos están llenos, retornar verdadero
        return true;
    }
}
