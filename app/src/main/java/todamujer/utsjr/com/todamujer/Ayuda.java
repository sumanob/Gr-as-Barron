package todamujer.utsjr.com.todamujer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Ayuda extends ActionBarActivity {
    TextView lblAyuda, lblDetalleAyuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        lblAyuda=(TextView)findViewById(R.id.LblAyuda);
        lblDetalleAyuda=(TextView)findViewById(R.id.LblDetalleAyuda);

        Bundle b=this.getIntent().getExtras();

        lblAyuda.setText(b.getString("ayu"));

        if(b.getString("ayu").equals("Acceder")){
            lblDetalleAyuda.setText("El acceso a la aplicación es sencillo, basta con ubicar el  \n" +
                    "icono de la aplicacion en el menu del telefono, y dar clic sobre el,\n" +
                    "una vez habiendo realizado eso, nos aparecera la ventana de login,\n" +
                    "tendremos que teclear nuestro nombre de usuario y la contraseña.\n");
        }
        else if(b.getString("ayu").equals("Nuestro Menu")){
            lblDetalleAyuda.setText("El menu consta de una serie de imagenes sobre las que podemos hacer clic \n"+
            "al hacer clic sobre ellas obtenemos una serie de detalles importantes segun sea el caso, para regresarnos basta con dar clic en la felcha de anterior. \n");
        }
        else if(b.getString("ayu").equals("Detalles")){
            lblDetalleAyuda.setText("Estos estan ubicados dentro del menu de opciones que aparecen en embarazo, sintomas y estados de humor. \n" +
                    "La información presentada es de ayuda, y son algunos consejos para los casos que se presentan.\n");
        }

        else if(b.getString("ayu").equals("Acerca de Nosotros")){
            lblDetalleAyuda.setText(
                    "En este apartado de la aplicacion podremos informarnos sobre la aplicación, quiénes son los creadores" +
                    "cuál es el objetivo que tiene esta, cuáles son los benéficios de utilizarla\n+" +
                            "CREADORES:\n "+
                            "•\tDIEGO SUMANO BASURTO\n" +
                            "•\tSAEL ESSAÚ ARREOLA \n" +
                            "•\tRICARDO CALDERON MUÑOZ\n" +
                            "•\tDAVID REZENDIZ TAPIA\n" +
                            "•\tJULIO CESAR LOPEZ VERDE\n");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ayuda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
