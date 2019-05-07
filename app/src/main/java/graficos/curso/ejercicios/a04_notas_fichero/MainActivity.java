package graficos.curso.ejercicios.a04_notas_fichero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import modelo.GestionNotas;

public class MainActivity extends Activity {
    GestionNotas gnotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gnotas=new GestionNotas(this);
    }
    public void guardar(View v){
        EditText edtNota=this.findViewById(R.id.edtNota);
        gnotas.guardarNota(Double.parseDouble(edtNota.getText().toString()));
        //borra el contenido del campo nota
        edtNota.setText("");
        //pasa el foco a dicho control
        edtNota.requestFocus();
    }
    public void resultados(View v){
        Intent intent=new Intent(this,CalculosActivity.class);

        this.startActivity(intent);
    }

}
