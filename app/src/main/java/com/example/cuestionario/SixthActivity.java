package com.example.cuestionario;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.FileOutputStream;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Button btnGenerarPDF = findViewById(R.id.btn_generar_pdf);
        btnGenerarPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarPDF();
            }
        });
    }

    private void generarPDF() {
        String fileName = "informacion.pdf";
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String filePath = new File(downloadsDir, fileName).getAbsolutePath();

        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream(new File(filePath)));
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            document.add(new Paragraph("Datos recopilados para el rol: " + DatosCuestionario.rolSeleccionado));
            document.add(new Paragraph(""));

            // Crear tabla para mostrar las preguntas y respuestas relevantes
            Table table = new Table(2); // 2 columnas
            table.addCell(new Cell().add(new Paragraph("Pregunta")));
            table.addCell(new Cell().add(new Paragraph("Respuesta")));

            // Agregar las preguntas y respuestas relevantes según el rol seleccionado
            switch (DatosCuestionario.rolSeleccionado) {
                case "Control Interno":
                    table.addCell(new Cell().add(new Paragraph("Nombre")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato1)));
                    table.addCell(new Cell().add(new Paragraph("Rol")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato2)));
                    table.addCell(new Cell().add(new Paragraph("Area")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato3)));
                    table.addCell(new Cell().add(new Paragraph("Nombre Entidad")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato4)));
                    table.addCell(new Cell().add(new Paragraph("URL Entidad")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato5)));
                    table.addCell(new Cell().add(new Paragraph("Tipo de entidad")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato6)));
                    table.addCell(new Cell().add(new Paragraph("Misión")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato7)));
                    table.addCell(new Cell().add(new Paragraph("Mapa de Procesos")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato8)));
                    table.addCell(new Cell().add(new Paragraph("Políticas de seguridad de la información")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato9)));
                    table.addCell(new Cell().add(new Paragraph("Organigrama, roles y responsabilidades")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato10)));
                    table.addCell(new Cell().add(new Paragraph("Documento de autoevaluación")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato11)));
                    table.addCell(new Cell().add(new Paragraph("Herramienta de diagnóstico")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato12)));
                    table.addCell(new Cell().add(new Paragraph("Documento de estratificación")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato13)));
                    table.addCell(new Cell().add(new Paragraph("Metodología de Gestión de riesgos")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato14)));
                    table.addCell(new Cell().add(new Paragraph("Riesgos identificados y valorados")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato15)));
                    table.addCell(new Cell().add(new Paragraph("Planes de tratamiento de los riesgos")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato16)));
                    table.addCell(new Cell().add(new Paragraph("Procedimiento de verificación de antecedentes")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato17)));
                    table.addCell(new Cell().add(new Paragraph("Inventario de activos de información")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato18)));
                    break;
                case "Responsable De Compras Y Adquisidores":
                case "Lider De Proceso 1":
                case "Responsable De Continuidad":
                case "Responsable Del SI":
                case "Responsable De TIC":
                    table.addCell(new Cell().add(new Paragraph("Gestión humana pregunta 1")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato19)));
                    table.addCell(new Cell().add(new Paragraph("Gestión humana pregunta 2")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato20)));
                    table.addCell(new Cell().add(new Paragraph("Nombre")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato1)));
                    table.addCell(new Cell().add(new Paragraph("Rol")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato2)));
                    table.addCell(new Cell().add(new Paragraph("Area")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato3)));
                    table.addCell(new Cell().add(new Paragraph("Nombre Entidad")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato4)));
                    table.addCell(new Cell().add(new Paragraph("URL Entidad")));
                    table.addCell(new Cell().add(new Paragraph(DatosCuestionario.dato5)));
                    break;

                // Añadir más casos según sea necesario para otros roles
                default:
                    Toast.makeText(this, "Rol no reconocido", Toast.LENGTH_SHORT).show();
                    break;
            }

            document.add(table);
            document.close();

            Toast.makeText(this, "PDF generado con éxito en: " + filePath, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al generar el PDF: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

