package com.example.bogarin.crud;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.example.bogarin.crud.QueryScriptAlumnos.ColumnAlumnos;

public class MainActivity extends ListActivity {

    private static final int ADD_REQUEST_CODE = 1;
    private QueryScriptAlumnos dataSource;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSource=new QueryScriptAlumnos(this);
        adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.two_line_list_item,
                dataSource.allAlumnos(),
                new String[]{ColumnAlumnos.NOMBRE,ColumnAlumnos.APELLIDOP},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_add:
                agregar();//Iniciando la actividad Form
                return true;

            case R.id.action_detlete:
                dataSource.deleteAlumnosRow();
                adapter.changeCursor(dataSource.allAlumnos());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                //Insertando el registro con los datos del formulario
                dataSource.saveAlumnoRow(data.getStringExtra("nombre"),data.getStringExtra("apellidop"),data.getStringExtra("apellidom"),data.getStringExtra("fecha"));
                //Refrescando la lista manualmente
                adapter.changeCursor(dataSource.allAlumnos());
            }
        }

    }
    private void agregar(){
        //Iniciando la actividad Form
        Intent intent = new Intent(this, Add.class);
        //Inicio de la actividad esperando un resultado
        startActivityForResult(intent, ADD_REQUEST_CODE);
    }

}
