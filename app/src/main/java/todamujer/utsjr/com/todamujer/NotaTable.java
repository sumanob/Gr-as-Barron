package todamujer.utsjr.com.todamujer;

/**
 * Created by yonathan on 13/04/2015.
 */
public class NotaTable {


    public static final String TABLA="notas";
    public static final String ID="id";
    public static final String TITULO="titulo";
    public static final String FECHA="fecha";
    public static final String NOTA="nota";


    public static String[] getNotaColumns(){
        String array[]={ID,TITULO,FECHA,NOTA};
        return array;
    }

}
