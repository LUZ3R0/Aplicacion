package comceleluengo.fb.appinp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private android.support.design.widget.TextInputEditText campoNombre, campoTelefono, campoEmail, campoDescripcion;
    private TextView tvFecha;
    private Button miBoton, botCancel, botOk;
    private DatePicker campoPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditNombre);
        campoTelefono = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditTelefono);
        campoEmail = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditEmail);
        campoDescripcion = (android.support.design.widget.TextInputEditText) findViewById(R.id.EditDescripcion);
        miBoton = (Button) findViewById(R.id.botSiguiente);
        campoPicker = (DatePicker) findViewById(R.id.datePicker);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        botCancel = (Button) findViewById(R.id.botCancelar);
        botOk = (Button) findViewById(R.id.botOk);

        botOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFecha.setText(campoPicker.getDayOfMonth()+"/"+(campoPicker.getMonth()+1)+"/"+campoPicker.getYear());
            }
        });

        botCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFecha.setText("");
            }
        });

        miBoton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra("nombre", campoNombre.getText() + "");
                i.putExtra("telefono", campoTelefono.getText() + "");
                i.putExtra("email", campoEmail.getText() + "");
                i.putExtra("descripcion", campoDescripcion.getText() + "");
                i.putExtra("fecha", tvFecha.getText()+"");

                startActivity(i);

            }
        });

        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        String email = getIntent().getStringExtra("email");
        String descripcion = getIntent().getStringExtra("descripcion");
        String fecha = getIntent().getStringExtra("fecha");

        campoNombre.setText(nombre);
        campoTelefono.setText(telefono);
        campoEmail.setText(email);
        campoDescripcion.setText(descripcion);
        tvFecha.setText(fecha);



    }

}

