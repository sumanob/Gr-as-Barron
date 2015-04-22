package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalleEmergenciaActivity extends ActionBarActivity {
    private static final int MENU_MENU=1;
    private static final int MENU_AYUDA=2;
    TextView lblSintoma, lblDetallesSintoma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_emergencia);

        lblSintoma=(TextView)findViewById(R.id.LblSintoma);
        lblDetallesSintoma=(TextView)findViewById(R.id.LblDetallesSintoma);


        Bundle b=this.getIntent().getExtras();

        lblSintoma.setText(b.getString("sintoma"));
        if(b.getString("sintoma").equals("Policia")){
            lblDetallesSintoma.setText(
                    "Numeros de la policia:\n" +
                    "•\tSan Juan del Rio: 2156779\n" +
                    "•\tTequisquiapan: 655787\n" +
                    "•\tQueretaro: 568767\n" +
                    "•\tPedro Escobedo: 665478\n");

        }
        else if(b.getString("sintoma").equals("Ambulancia")){
            lblDetallesSintoma.setText("Numeros de la policia:\n" +
                    "•\tSan Juan del Rio: 2156779\n" +
                    "•\tTequisquiapan: 655787\n" +
                    "•\tQueretaro: 568767\n" +
                    "•\tPedro Escobedo: 665478\n");
        }
        else if(b.getString("sintoma").equals("Angeles Verdes")){
            lblDetallesSintoma.setText("Numeros de la policia:\n" +
                    "•\tSan Juan del Rio: 2156779\n" +
                    "•\tTequisquiapan: 655787\n" +
                    "•\tQueretaro: 568767\n" +
                    "•\tPedro Escobedo: 665478\n");
        }
        else if(b.getString("sintoma").equals("Bomberos")){
            lblDetallesSintoma.setText("Numeros de la policia:\n" +
                    "•\tSan Juan del Rio: 2156779\n" +
                    "•\tTequisquiapan: 655787\n" +
                    "•\tQueretaro: 568767\n" +
                    "•\tPedro Escobedo: 665478\n");
        }


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
                Intent intent = new Intent(DetalleEmergenciaActivity.this,MenuActivity.class);
                startActivity(intent);
                return true;
            case MENU_AYUDA:
                Intent intento = new Intent(DetalleEmergenciaActivity.this, Ayuda2.class);
                startActivity(intento);
                return true;




            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
