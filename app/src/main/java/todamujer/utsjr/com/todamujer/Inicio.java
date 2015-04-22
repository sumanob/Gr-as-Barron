package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Alumno on 23/03/2015.
 */
public class Inicio extends ActionBarActivity{




    private static final int MENU_MENU=1;
    private static final int MENU_AYUDA=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);


        menu.add(Menu.NONE,MENU_MENU,Menu.NONE,"Menu de Gruas Barrón");
        menu.add(Menu.NONE,MENU_AYUDA,Menu.NONE,"Detalles de la APP");





        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {

            case MENU_MENU:
                Intent intent = new Intent(Inicio.this, MenuActivity.class);
                startActivity(intent);
                return true;


            case MENU_AYUDA:
                Intent intento = new Intent(Inicio.this, Ayuda2.class);
                startActivity(intento);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

