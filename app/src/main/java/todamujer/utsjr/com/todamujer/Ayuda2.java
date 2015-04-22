package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Ayuda2 extends ActionBarActivity {
    private ListView lstAyuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda2);
        lstAyuda=(ListView)findViewById(R.id.LstAyuda);


        List<ItemMapa> items=new ArrayList<ItemMapa>();

        items.add(new ItemMapa(R.drawable.grua,"Acceder"));
        items.add(new ItemMapa(R.drawable.grua,"Nuestro Menu"));
        items.add(new ItemMapa(R.drawable.grua,"Detalles"));
        items.add(new ItemMapa(R.drawable.grua,"Acerca de Nosotros"));


        this.lstAyuda.setAdapter(new ItemAdapterMapa(this,items));

        lstAyuda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemMapa itemMapa =(ItemMapa)lstAyuda.getAdapter().getItem(position);
                Intent intent=new Intent(Ayuda2.this,Ayuda.class);
                Bundle b=new Bundle();
                b.putString("ayu", itemMapa.getEmba());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ayuda2, menu);
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
