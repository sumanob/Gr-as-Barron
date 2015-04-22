package todamujer.utsjr.com.todamujer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by yonathan on 13/04/2015.
 */
public class NotaHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="notas.db";
    private static final int DATABASE_VERSION=1;


    public NotaHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+NotaTable.TABLA+"("+
                NotaTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NotaTable.TITULO + " TEXT, "+
                NotaTable.FECHA + " TEXT, "+
                NotaTable.NOTA + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(NotaHelper.class.getName(),
                "Actualizacion base de datos de la version " + oldVersion +
                        " a " + newVersion + ", y se perderan los datos");

        db.execSQL("DROP TABLE IF EXIST "+NotaTable.TABLA);
        onCreate(db);
    }
}
