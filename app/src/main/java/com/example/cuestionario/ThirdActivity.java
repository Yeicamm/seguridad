package com.example.cuestionario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String rol = intent.getStringExtra("rol");
        DatosCuestionario.rolSeleccionado = rol;  // Guardar el rol seleccionado

        // Obtener el LinearLayout del layout correspondiente al rol
        LinearLayout layout = null;
        switch (rol) {
            case "Control Interno":
                layout = findViewById(R.id.layout_control_interno);
                break;
            case "Responsable De Compras Y Adquisidores":
                layout = findViewById(R.id.layout_compras_adquisidores);
                break;
            case "Lider De Proceso 1":
                layout = findViewById(R.id.layout_lider_proceso1);
                break;
            case "Responsable De Continuidad":
                layout = findViewById(R.id.layout_responsable_continuidad);
                break;
            case "Responsable Del SI":
                layout = findViewById(R.id.layout_responsable_si);
                break;
            case "Responsable De TIC":
                layout = findViewById(R.id.layout_responsable_tic);
                break;
            default:
                Toast.makeText(this, "Rol no reconocido", Toast.LENGTH_SHORT).show();
                finish(); // Terminar la actividad si el rol no es reconocido
                return;
        }
        // Mostrar las preguntas para el rol actual
        mostrarPreguntas(layout, rol);

        // Botón para ir a la cuarta vista
        Button nextButton = findViewById(R.id.button_to_fourth);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para mostrar preguntas según el rol
    private void mostrarPreguntas(LinearLayout layout, String rol) {
        // Cambiar la visibilidad del layout al visible para mostrar las preguntas
        layout.setVisibility(View.VISIBLE);

        // Agregar preguntas al layout según el rol
        switch (rol) {
            case "Control Interno":
                crearPreguntaRespuesta(layout, "¿Existe un plan de auditorías para el año 2015 que contemple la revisión de la conveniencia, la adecuación y la eficacia continuas de la gestión de la seguridad de la información?\n", 1);
                crearPreguntaRespuesta(layout, "¿Se realizaron auditorías en el año 2015 para evaluar la seguridad de la información según lo planificado?\n", 2);
                crearPreguntaRespuesta(layout, "¿Fueron identificadas oportunidades de mejora o cambios necesarios en la seguridad de la información a partir de las auditorías del año 2015?\n", 3);
                crearPreguntaRespuesta(layout, "¿Aseguran los gerentes que todos los procedimientos de seguridad dentro de su área de responsabilidad se llevan a cabo correctamente para lograr el cumplimiento de las políticas y estándares de seguridad?\n", 4);
                crearPreguntaRespuesta(layout, "¿Se realiza una revisión periódica del cumplimiento del centro de cómputo con las políticas y normas de seguridad establecidas?\n", 5);
                crearPreguntaRespuesta(layout, "¿Son revisados regularmente los sistemas de información para asegurar el cumplimiento de las normas de seguridad de la información?", 6);
                // Agregar más preguntas según sea necesario para Control Interno
                break;
            case "Responsable De Compras Y Adquisidores":
                crearPreguntaRespuesta(layout, "¿Se realiza un seguimiento regular de la prestación de servicios por parte de los proveedores de acuerdo con la política de la entidad?\n", 1);
                crearPreguntaRespuesta(layout, "¿Se revisa y audita regularmente el cumplimiento de los compromisos de los proveedores respecto a la seguridad de la información?\n", 2);
                crearPreguntaRespuesta(layout, "¿Puede proporcionar evidencia documental que demuestre la revisión y auditoría de una muestra de proveedores seleccionada?\n", 3);
                crearPreguntaRespuesta(layout, "¿Se tienen en cuenta la criticidad de la información, sistemas y procesos del negocio involucrados al gestionar los cambios en los servicios de los proveedores?\n", 4);
                crearPreguntaRespuesta(layout, "¿Se consideran los incidentes de seguridad de la información y la revaloración de los riesgos al gestionar los cambios en el suministro de servicios por parte de los proveedores?", 5);
                // Agregar más preguntas según sea necesario para Gestión Humana
                break;
            case "Responsable De Continuidad":
                crearPreguntaRespuesta(layout, "1. ¿La Entidad cuenta con un BCP (Business Continuity Plan) o DRP (Disaster Recovery Plan)?", 1);
                crearPreguntaRespuesta(layout, "2. ¿Determina si aplica para procesos críticos solamente o se han incluido otros procesos o por lo menos se ha reconocido la necesidad de ampliarlo a otros procesos (para determinar el nivel de madurez)?", 2);
                crearPreguntaRespuesta(layout, "3. ¿Evalúa si se ha incluido en estos planes y procedimientos los requisitos de seguridad de la información?", 3);
                crearPreguntaRespuesta(layout, "4. ¿Se tiene en cuenta que, en ausencia de una planificación formal de continuidad de negocio y recuperación de desastres, la dirección de seguridad de la información debería suponer que los requisitos de seguridad de la información siguen siendo los mismos en situaciones adversas, en comparación con las condiciones operacionales normales?", 4);
                crearPreguntaRespuesta(layout, "5. ¿La organización lleva a cabo un análisis de impacto en el negocio de los aspectos de seguridad de la información, para determinar los requisitos de seguridad de la información aplicables a situaciones adversas?", 5);
                crearPreguntaRespuesta(layout, "6. ¿Se tienen planes de respuesta a incidentes y recuperación de incidentes?", 6);
                crearPreguntaRespuesta(layout, "7. ¿Se realizan revisiones independientes de la conveniencia, la adecuación y la eficacia continuas de la gestión de la seguridad de la información?", 7);
                crearPreguntaRespuesta(layout, "8. ¿Existe un plan de auditorías para el año 2015?", 8);
                crearPreguntaRespuesta(layout, "9. ¿Se realizaron auditorías en el año 2015?", 9);
                crearPreguntaRespuesta(layout, "10. ¿Fueron identificadas oportunidades de mejora o cambios en la seguridad de la información durante las auditorías del año 2015?", 10);
                crearPreguntaRespuesta(layout, "11. ¿Los gerentes aseguran el cumplimiento de los procedimientos de seguridad en su área?", 11);
                crearPreguntaRespuesta(layout, "12. ¿Se revisa periódicamente el cumplimiento del centro de cómputo con las políticas de seguridad?", 12);
                crearPreguntaRespuesta(layout, "13. ¿Se revisan regularmente los sistemas de información para cumplir con las normas de seguridad?", 13);
                // Agregar más preguntas según sea necesario para Gestión Humana
                break;
            case "Lider De Proceso 1":
                crearPreguntaRespuesta(layout, "1. ¿Se desarrollan campañas, folletos y boletines de concienciación?", 1);
                crearPreguntaRespuesta(layout, "2. ¿Los planes de concienciación están aprobados y documentados por la alta dirección?", 2);
                crearPreguntaRespuesta(layout, "3. ¿Los nuevos empleados y contratistas reciben formación en seguridad de la información?", 3);
                crearPreguntaRespuesta(layout, "4. ¿Se actualizan los programas de concienciación regularmente?", 4);
                crearPreguntaRespuesta(layout, "5. ¿Se pueden establecer evidencias de la asistencia y los temas impartidos?", 5);
                crearPreguntaRespuesta(layout, "6. ¿Se incluyen procedimientos básicos de seguridad de la información en la concienciación?", 6);
                crearPreguntaRespuesta(layout, "7. ¿Los funcionarios con roles privilegiados comprenden sus responsabilidades según NIST?", 7);
                // Agregar más preguntas según sea necesario para Gestión Humana
                break;
            case "Responsable Del SI":
                crearPreguntaRespuesta(layout, "1. Se definen los objetivos, alcance de la política?", 1);
                crearPreguntaRespuesta(layout, "2. Se encuentra alineada con la estrategia y objetivos de la entidad?", 2);
                crearPreguntaRespuesta(layout, "3. Fue debidamente aprobada y socializada al interior de la entidad por la alta dirección?", 3);
                crearPreguntaRespuesta(layout, "4. Los roles y responsabilidades frente a la ciberseguridad han sido establecidos?", 4);
                crearPreguntaRespuesta(layout, "5. Los roles y responsabilidades de seguridad de la información han sido coordinados y alineados con los roles internos y las terceras partes externas?", 5);
                crearPreguntaRespuesta(layout, "6. Los a) proveedores, b) clientes, c) socios, d) funcionarios, e) usuarios privilegiados, f) directores y gerentes (mandos senior), g) personal de seguridad física, h) personal de seguridad de la información entienden sus roles y responsabilidades, i) Están claros los roles y responsabilidades para la detección de incidentes?", 6);
                crearPreguntaRespuesta(layout, "7. La entidad asigna dispositivos móviles a sus funcionarios o permite que los dispositivos de estos ingresen a la entidad.", 7);
                crearPreguntaRespuesta(layout, "8. Existe una política y controles para su uso, que protejan la información almacenada o procesada en estos dispositivos y el acceso a servicios te TI desde los mismos.", 8);
                crearPreguntaRespuesta(layout, "9. Se desarrollan campañas, elaboran folletos y boletines?", 9);
                crearPreguntaRespuesta(layout, "10. Los planes de toma de conciencia y comunicación, de las políticas de seguridad y privacidad de la información, están aprobados y documentados, por la alta Dirección?", 10);
                crearPreguntaRespuesta(layout, "11. Los nuevos empleados y contratistas son objeto de sensibilización en SI?", 11);
                crearPreguntaRespuesta(layout, "12. Se actualizan los programas de toma de conciencia?", 12);
                crearPreguntaRespuesta(layout, "13. Las evidencias pueden establecer los asistentes al programa y el tema impartido?", 13);
                crearPreguntaRespuesta(layout, "14. Se incluyen los temas de toma de conciencia los procedimientos básicos de seguridad de la información (tales como el reporte de incidentes de seguridad de la información) y los controles de línea base (tales como la seguridad de las contraseñas, los controles del software malicioso, y los escritorios limpios)?", 14);
                crearPreguntaRespuesta(layout, "15. De acuerdo a NIST los funcionarios con roles privilegiados entienden sus responsabilidades y roles?", 15);
                crearPreguntaRespuesta(layout, "16. Actualizan el inventario de activos?", 16);
                crearPreguntaRespuesta(layout, "17. Se utilizan criterios para determinar la importancia de un activo?", 17);
                crearPreguntaRespuesta(layout, "18. ¿Quién es el propietario del activo y quiénes son los encargados de mantener el inventario actualizado?", 18);
                crearPreguntaRespuesta(layout, "19. Se realizan evaluaciones de seguridad técnicas por o bajo la supervisión de personal autorizado, apoyado en herramientas automáticas o con revisiones manuales realizadas por especialistas?", 19);
                crearPreguntaRespuesta(layout, "20. Según las pruebas realizadas, sus resultados y seguimiento para asegurar que las brechas de seguridad fueron solucionadas.", 20);
                // Agregar más preguntas según sea necesario para Gestión Humana
                break;
            case "Responsable De TIC":
                crearPreguntaRespuesta(layout, "1. ¿El personal o terceros pueden realizar actividades de teletrabajo?", 1);
                crearPreguntaRespuesta(layout, "2. ¿Existe una política que indica las condiciones y restricciones para el uso del teletrabajo?", 2);
                crearPreguntaRespuesta(layout, "3. ¿Hay seguridad física existente en el sitio del teletrabajo?", 3);
                crearPreguntaRespuesta(layout, "4. ¿Los requisitos de seguridad de las comunicaciones tienen en cuenta la necesidad de acceso remoto a los sistemas internos de la organización, la sensibilidad de la información a la que se tendrá acceso y que pasará a través del enlace de comunicación y la sensibilidad del sistema interno?", 4);
                crearPreguntaRespuesta(layout, "5. ¿Se solicitan las directrices, guías, lineamientos y procedimientos para la gestión de medios removibles?", 5);
                crearPreguntaRespuesta(layout, "6. ¿Se remueve el contenido de cualquier medio reusable que se vaya a retirar de la organización de forma que no sea recuperable?", 6);
                crearPreguntaRespuesta(layout, "7. ¿Se solicita autorización para retirar los medios de la organización y se lleva un registro de dichos retiros para mantener un rastro de auditoría cuando resulte necesario y práctico?", 7);
                crearPreguntaRespuesta(layout, "8. ¿Se utilizan técnicas criptográficas para proteger los datos en medios removibles si la confidencialidad o integridad de los datos se consideran importantes?", 8);
                crearPreguntaRespuesta(layout, "9. ¿Se guardan varias copias de los datos valiosos en medios separados para reducir el riesgo de daño o pérdida casual de los datos?", 9);
                crearPreguntaRespuesta(layout, "10. ¿Se habilitan unidades de medios removibles únicamente si hay una razón válida asociada a los procesos de la entidad?", 10);
                crearPreguntaRespuesta(layout, "11. ¿Se hace seguimiento a la transferencia de información a medios removibles donde hay necesidad de usarlos?", 11);
                crearPreguntaRespuesta(layout, "12. ¿Existen procedimientos para garantizar que los medios a desechar o donar no contienen información confidencial que pueda ser consultada y copiada por personas no autorizadas?", 12);
                crearPreguntaRespuesta(layout, "13. ¿Se solicitan los procedimientos para el cumplimiento de los requisitos contractuales relacionados con los derechos de propiedad intelectual y el uso de productos de software patentados?", 13);
                crearPreguntaRespuesta(layout, "14. ¿La Entidad cuenta con una política publicada sobre el cumplimiento de derechos de propiedad intelectual que define el uso legal del software y de productos informáticos?", 14);
                crearPreguntaRespuesta(layout, "15. ¿Se investiga cómo se controla que no se instale software ilegal?", 15);
                crearPreguntaRespuesta(layout, "16. ¿Se tiene un inventario de software instalado y se compara con el número de licencias adquiridas para asegurar que no se incumplen los derechos de propiedad intelectual?", 16);
                crearPreguntaRespuesta(layout, "17. ¿Se tienen en cuenta los controles para asegurar que no se exceda ningún número máximo de usuarios permitido dentro de la licencia?", 17);
                // Agregar más preguntas según sea necesario para Gestión Humana
                break;
            // Agregar más casos según sea necesario para otros roles
            default:
                Toast.makeText(this, "Rol no reconocido", Toast.LENGTH_SHORT).show();
                finish(); // Terminar la actividad si el rol no es reconocido
                return;
        }
    }

    // Método para crear una pregunta y respuesta y agregarlas al layout
    private void crearPreguntaRespuesta(LinearLayout layout, final String pregunta, final int index) {
        // Crear un TextView para la pregunta
        TextView preguntaTextView = new TextView(this);
        preguntaTextView.setText(pregunta);
        layout.addView(preguntaTextView);

        // Crear un RadioGroup para las respuestas
        RadioGroup radioGroup = new RadioGroup(this);
        RadioButton siButton = new RadioButton(this);
        siButton.setText("Sí");
        siButton.setId(View.generateViewId());
        RadioButton noButton = new RadioButton(this);
        noButton.setText("No");
        noButton.setId(View.generateViewId());

        radioGroup.addView(siButton);
        radioGroup.addView(noButton);
        layout.addView(radioGroup);

        // Agregar un listener para guardar la respuesta cuando cambie
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Guardar la respuesta en la clase DatosCuestionario
                RadioButton selectedButton = group.findViewById(checkedId);
                if (selectedButton != null) {
                    String respuesta = selectedButton.getText().toString();
                    switch (index) {
                        case 1:
                            DatosCuestionario.dato19 = respuesta;
                            break;
                        case 2:
                            DatosCuestionario.dato20 = respuesta;
                            break;
                        case 3:
                            DatosCuestionario.dato21 = respuesta;
                            break;
                        // Añadir más casos según sea necesario para cada dato
                        default:
                            break;
                    }
                }
            }
        });
    }
}
