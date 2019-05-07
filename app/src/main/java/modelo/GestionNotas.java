package modelo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import beans.Resultado;

/**
 * Created by antonio on 20/09/2017.
 */

public class GestionNotas {
    String ruta="notas.txt";
    Context ctx;
    public GestionNotas(Context context){
        this.ctx=context;
    }
    //si quisieramos que fuera Singleton
    /*private GestionNotas obj;
    private GestionNotas(){

    }
    static{
        obj=new GestionNotas();
    }
    public static GestionNotas getInstance(){
        return obj;
    }
    */

    public void guardarNota(double d){
        try(FileOutputStream fos=ctx.openFileOutput(ruta, Context.MODE_APPEND);
            PrintStream out=new PrintStream(fos);) {
            out.println(d);

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public List<Double> recupuerarNotas(){
        ArrayList<Double> notas=new ArrayList<>();
        try(FileInputStream fis = ctx.openFileInput(ruta);
            BufferedReader bf = new BufferedReader(new InputStreamReader(fis));) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                notas.add(Double.parseDouble(linea));
            }

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return notas;
    }
    public Resultado calculos(){
        int ap=0;
        double media=0;
        int cont=0;
        Resultado res=null;
        try(FileInputStream fis = ctx.openFileInput(ruta);
            BufferedReader bf = new BufferedReader(new InputStreamReader(fis));) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                media+=Double.parseDouble(linea);
                if(Double.parseDouble(linea)>=5){
                    ap++;
                }
                cont++;
            }
            res=new Resultado(media/cont,ap);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return res;
    }

}
