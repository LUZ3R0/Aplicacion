package comceleluengo.fb.appinp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView textNombre, textTelefono, textEmail, textDescripcion, textFecha;
    private Button BotonEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        textNombre = (TextView) findViewById(R.id.textNombre);
        textTelefono = (TextView) findViewById(R.id.textTelefono);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textDescripcion = (TextView) findViewById(R.id.textDescripcion);
        textFecha = (TextView) findViewById(R.id.textFecha);
        BotonEditar = (Button) findViewById(R.id.button2);

        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        String email = getIntent().getStringExtra("email");
        String descripcion = getIntent().getStringExtra("descripcion");
        String fecha = getIntent().getStringExtra("fecha");


        textNombre.setText(nombre);
        textTelefono.setText(telefono);
        textEmail.setText(email);
        textDescripcion.setText(descripcion);
        textFecha.setText(fecha);

        BotonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConfirmarDatos.this, MainActivity.class);
                i.putExtra("nombre", textNombre.getText() + "");
                i.putExtra("telefono", textTelefono.getText() + "");
                i.putExtra("email", textEmail.getText() + "");
                i.putExtra("descripcion", textDescripcion.getText() + "");
                i.putExtra("fecha", textFecha.getText() + "");

                startActivity(i);
            }


        });


    }
}

