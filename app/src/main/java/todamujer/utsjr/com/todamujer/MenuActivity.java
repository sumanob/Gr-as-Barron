package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MenuActivity extends ActionBarActivity {
    private static final int MENU_AYUDA=2;
    ImageButton btnMapa, btnEmergencias, btnLlamada, btnTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMapa=(ImageButton)findViewById(R.id.BtnMapa);
        btnEmergencias=(ImageButton)findViewById(R.id.BtnEmergencias);
        btnLlamada=(ImageButton)findViewById(R.id.BtnLlamada);
        btnTips=(ImageButton)findViewById(R.id.BtnTips);


        btnMapa.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Intent intent=new Intent(MenuActivity.this,MapaActivity.class);
                startActivity(intent);
            }
        });
        btnEmergencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,EmergenciasActivity.class);
                startActivity(intent);
            }
        });
       btnLlamada.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ET.class);
                startActivity(intent);
            }
       });
        btnTips.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,TipsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_menu, menu);
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



            case MENU_AYUDA:
                Intent intento = new Intent(MenuActivity.this, Ayuda2.class);
                startActivity(intento);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
