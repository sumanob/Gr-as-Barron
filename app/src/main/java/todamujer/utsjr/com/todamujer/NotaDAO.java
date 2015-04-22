package todamujer.utsjr.com.todamujer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonathan on 13/04/2015.
 */
public class NotaDAO {

    private NotaHelper nh;
    private SQLiteDatabase sd;

    public NotaDAO(Context context) {
        nh=new NotaHelper(context);
    }

    public void open() throws SQLException {
        sd=nh.getWritableDatabase();
    }
    public void close() {
        nh.close();
    }
    public SQLiteDatabase getSd(){
        return sd;
    }


    public boolean agregarNota(Nota n){
        long resultado=-1;

        //declaramos objeto ContentValues
        ContentValues cv=new ContentValues();

        //agregamos elementos al ContentValues (clave,valor)
        cv.put(NotaTable.TITULO, n.getTitulo());
        cv.put(NotaTable.FECHA, n.getFecha());
        cv.put(NotaTable.NOTA, n.getNota());


        //insertamos los valores en la tabla de la BD
        resultado=getSd().insert(NotaTable.TABLA,NotaTable.TABLA,cv);

        //verificar numero de filas afectadas
        if(resultado>0){
            return true;
        }
        else{
            return false;
        }
    }



    public boolean eliminarNota(int id){
        long resultado=getSd().delete(NotaTable.TABLA,NotaTable.ID + "=" + id,null);

        //verificar numero de filas afectadas
        if(resultado>0){
            return true;
        }
        else{
            return false;
        }

    }



    public boolean modificarNota(Nota n) {
        long resultado = -1;

        //declaramos objeto ContentValues
        ContentValues cv = new ContentValues();

        //agregamos elementos al ContentValues (clave,valor)
        cv.put(NotaTable.TITULO, n.getTitulo());
        cv.put(NotaTable.FECHA, n.getFecha());
        cv.put(NotaTable.NOTA, n.getNota());

        //se actualiza l registro
        resultado = getSd().update(NotaTable.TABLA, cv, NotaTable.ID + "=?", new String[]{String.valueOf(n.getId())});


        //verificar numero de filas afectadas
        if (resultado > 0) {
            return true;
        } else {
            return false;
        }
    }



        public List<Nota> getNotas(){
            Nota n=null;
            List<Nota> notaList=new ArrayList<Nota>();
            //declaramos un objeto Cursor y obtenemos los datos
            Cursor cursor=getSd().query(NotaTable.TABLA,NotaTable.getNotaColumns(),null,null,null,null,null);

            //nos moveremos al primer elemento del cursor
            cursor.moveToFirst();

            //recorremos el cursor y vamos extrayendo cada registro
            //y agregandolo a la lista
            while (!cursor.isAfterLast()){
                n=new Nota();
                n.setId(cursor.getInt(0));
                n.setTitulo(cursor.getString(1));
                n.setFecha(cursor.getString(2));
                n.setNota(cursor.getString(3));

                notaList.add(n);
                cursor.moveToNext();
            }
            return notaList;
        }





    public Nota buscarNota(int id){
        //convertimos el id que es int a un arreglo de string
        String[] valor={String.valueOf(id)};

        //declaramos el cursor y hacemos la consulta
        Cursor cursor=getSd().query(NotaTable.TABLA,NotaTable.getNotaColumns(),"id=?",valor,null,null,null);


        cursor.moveToFirst();
        Nota n=new Nota();
        n.setId(cursor.getInt(0));
        n.setTitulo(cursor.getString(1));
        n.setFecha(cursor.getString(2));
        n.setNota(cursor.getString(3));


        return n;
    }



    public List<String> getTitulosNota(){
        List<String> titulosList=new ArrayList<String>();
        //declaramos el cursor y obtenemos los registros
        Cursor cursor=getSd().query(NotaTable.TABLA,NotaTable.getNotaColumns(),null,null,null,null,null);
        cursor.moveToFirst();

        //recorremo el cursor y extraemos el compo NOMBRE
        while(!cursor.isAfterLast()){
            titulosList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        return titulosList;
    }



    public List<String> getIdNotas(){
        List<String> idList=new ArrayList<String>();


        //declaramos el cursor y obtenemos los registros
        Cursor cursor=getSd().query(NotaTable.TABLA,NotaTable.getNotaColumns(),null,null,null,null,null);
        cursor.moveToFirst();



        //recorremo el cursor y extraemos el compo NOMBRE
        while(!cursor.isAfterLast()){
            idList.add(""+cursor.getString(0));
            cursor.moveToNext();
        }
        return idList;
    }







}
