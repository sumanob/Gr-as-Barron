package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MapaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mapa);
        Button button = (Button)findViewById(R.id.button);



        button.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Uri uri =  Uri . parse ( "https://www.google.com.mx/maps/place/Universidad+Tecnol%C3%B3gica+de+San+Juan+del+R%C3%ADo/@20.367742,-100.01009,17z/data=!3m1!4b1!4m2!3m1!1s0x85d30c6707079ad9:0x16daa5dc56c8c592" );
                        Intent intent =  new  Intent ( Intent . ACTION_VIEW , uri );
                        startActivity ( intent );

                    }



                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_embarazo, menu);
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
