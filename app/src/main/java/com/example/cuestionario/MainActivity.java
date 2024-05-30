package com.example.cuestionario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etNombreFuncionario;
    private Spinner spinnerRol;
    private EditText etArea;
    private EditText etNombreEntidad;
    private EditText etUrlEntidad;
    private EditText etNitEntidad;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreFuncionario = findViewById(R.id.et_nombre_funcionario);
        spinnerRol = findViewById(R.id.spinner_rol);
        etArea = findViewById(R.id.et_area);
        etNombreEntidad = findViewById(R.id.et_nombre_entidad);
        etUrlEntidad = findViewById(R.id.et_url_entidad);
        etNitEntidad = findViewById(R.id.et_nit_entidad);
        btnSubmit = findViewById(R.id.btn_submit);

        // Definir las opciones para el Spinner
        String[] roles = new String[]{"Seleccione Un Rol", "Control Interno", "Responsable De Compras Y Adquisidores", "Lider De Proceso 1", "Responsable De Continuidad", "Responsable Del SI", "Responsable De TIC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roles);
        spinnerRol.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreFuncionario = etNombreFuncionario.getText().toString();
                String rol = spinnerRol.getSelectedItem().toString();
                String area = etArea.getText().toString();
                String nombreEntidad = etNombreEntidad.getText().toString();
                String urlEntidad = etUrlEntidad.getText().toString();
                String nitEntidad = etNitEntidad.getText().toString();

                if (!TextUtils.isEmpty(nombreFuncionario) && !TextUtils.isEmpty(rol) &&
                        !TextUtils.isEmpty(area) && !TextUtils.isEmpty(nombreEntidad) &&
                        !TextUtils.isEmpty(urlEntidad) && !TextUtils.isEmpty(nitEntidad)) {
                    // Guardar los datos en la clase auxiliar DatosCuestionario
                    DatosCuestionario.dato1 = nombreFuncionario;
                    DatosCuestionario.dato2 = rol;
                    DatosCuestionario.dato3 = area;
                    DatosCuestionario.dato4 = nombreEntidad;
                    DatosCuestionario.dato5 = urlEntidad;

                    // Si los campos están completos, enviar los datos a SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nombreFuncionario", nombreFuncionario);
                    intent.putExtra("rol", rol);
                    intent.putExtra("area", area);
                    intent.putExtra("nombreEntidad", nombreEntidad);
                    intent.putExtra("urlEntidad", urlEntidad);
                    intent.putExtra("nitEntidad", nitEntidad);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
