package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EmergenciasActivity extends ActionBarActivity {
    private static final int MENU_MENU=1;
    private static final int MENU_AYUDA=2;
    private ListView lstSintomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencias);

        lstSintomas = (ListView) findViewById(R.id.LstSintomas);

        List<Item> items=new ArrayList<Item>();

        items.add(new Item(R.drawable.pa,"Policia"));
        items.add(new Item(R.drawable.ambulancia,"Ambulancia"));
        items.add(new Item(R.drawable.descarga,"Angeles Verdes"));
        items.add(new Item(R.drawable.bomberos,"Bomberos"));


        this.lstSintomas.setAdapter(new ItemAdapter(this,items));

        lstSintomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item=(Item)lstSintomas.getAdapter().getItem(position);
                Intent intent=new Intent(EmergenciasActivity.this,DetalleEmergenciaActivity.class);
                Bundle b=new Bundle();

                b.putString("sintoma",item.getSintoma());
                intent.putExtras(b);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_sintomas, menu);

        menu.add(Menu.NONE,MENU_MENU,Menu.NONE,"Menu de Gruas Barrón");
        menu.add(Menu.NONE,MENU_MENU,Menu.NONE,"Detalles de la APP");

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
                Intent intent = new Intent(EmergenciasActivity.this,MenuActivity.class);
                startActivity(intent);
                return true;


            case MENU_AYUDA:
                Intent intento = new Intent(EmergenciasActivity.this, Ayuda2.class);
                startActivity(intento);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
