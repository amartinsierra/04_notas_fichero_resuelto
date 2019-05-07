package graficos.curso.ejercicios.a04_notas_fichero;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import beans.Resultado;
import modelo.GestionNotas;

public class CalculosActivity extends Activity {
    GestionNotas gnotas;
    ArrayAdapter<Double> adpNotas;
    ListView lvNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);
        gnotas=new GestionNotas(this);

        TextView tvMedia=this.findViewById(R.id.tvMedia);
        TextView tvAprobados=this.findViewById(R.id.tvAprobados);
        //llama a los métodos que hacen los cálculos y muestra
        //los resultados en los campos de texto
        Resultado res=gnotas.calculos();
        tvMedia.setText("Nota media: "+res.getMedia());
        tvAprobados.setText("Aprobados: "+res.getAprobados());

        //volcamos las notas en ListView
        lvNotas=this.findViewById(R.id.lvNotas);
        adpNotas=new ArrayAdapter<Double>(this,android.R.layout.simple_list_item_1,gnotas.recupuerarNotas());
        lvNotas.setAdapter(adpNotas);

        lvNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gnotas.recupuerarNotas().remove(i);
                adpNotas=new ArrayAdapter<Double>(CalculosActivity.this,android.R.layout.simple_list_item_1,gnotas.recupuerarNotas());
                lvNotas.setAdapter(adpNotas);
            }
        });


    }

    public void salir(View view){
        AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
        cuadro.setMessage("¿Desea salir de la actividad");
        //el escuchador del botón de afirmación se define como
        //una clase anónima
        cuadro.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Abandona la actividad
                        CalculosActivity.this.finish();
                    }
                });
        //no se define ningún escuchador para el botón de negación
        cuadro.setNegativeButton(android.R.string.no,null);
        cuadro.show();
    }

}
