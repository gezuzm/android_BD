package com.example.gezuzm.imagencorporativa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
    private EditText etNombre;
    private EditText etCorreo;
    private EditText etMessage;

    //Send button
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //Initializing the views
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etMessage = (EditText) findViewById(R.id.etMensaje);
        etNombre = (EditText) findViewById(R.id.etNombre);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        //Adding click listener
        //buttonSend.setOnClickListener(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

        private void sendEmail() {
            //Getting content for email
            String correo = etCorreo.getText().toString().trim();
            String nombre = etNombre.getText().toString().trim();
            String mensaje = etMessage.getText().toString().trim();

            //Creating SendMail object
            SendMail sm = new SendMail(this, correo, nombre, mensaje);

            //Executing sendmail to send email
            sm.execute();
        }

        @Override
        public void onClick(View v) {
            sendEmail();
        }
    }