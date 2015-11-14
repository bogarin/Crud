package com.example.bogarin.crud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class Add extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Add);
        Button saveBoton=(Button)findViewById(R.id.saveButton);
        Button cancelBoton=(Button)findViewById(R.id.cancelButton);
        saveBoton.setOnClickListener(this);
        cancelBoton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveButton){
            EditText nombreField=(EditText)findViewById(R.id.nombre);
            EditText apField=(EditText)findViewById(R.id.apellidop);
            EditText amField=(EditText)findViewById(R.id.apellidom;
            EditText dateField=(EditText)findViewById(R.id.date);
            Intent Data=new Intent();
            Data.putExtra("nombre",nombreField.getText().toString());
            Data.putExtra("apellidop",apField.getText().toString());
            Data.putExtra("apellidom",amField.getText().toString());
            Data.putExtra("fecha",dateField.getText().toString());
            setResult(RESULT_OK,Data);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}
