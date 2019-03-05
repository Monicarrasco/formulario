package com.example.monicacarrasco.formulariocurso;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    EditText editNombre, editFecha, editTelefono, editEmail, editDescripcion;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre =(EditText)findViewById(R.id.editNombre);
        editTelefono = (EditText)findViewById(R.id.editTelefono);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editDescripcion = (EditText)findViewById(R.id.editDescripcion);

        siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MostrarDatos.class);
                i.putExtra(getResources().getString(R.string.pnombre),editNombre.getText().toString());
                i.putExtra(getResources().getString(R.string.pfecha),editFecha.getText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono),editTelefono.getText().toString());
                i.putExtra(getResources().getString(R.string.pemail),editEmail.getText().toString());
                i.putExtra(getResources().getString(R.string.pdescrip),editDescripcion.getText().toString());
                startActivity(i);
                onStop();
            }
        });



        editFecha = (EditText)findViewById(R.id.editFecha);
        editFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        editFecha.setText(sdf.format(myCalendar.getTime()));
    }

}
