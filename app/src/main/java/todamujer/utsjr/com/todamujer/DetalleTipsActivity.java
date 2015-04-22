package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetalleTipsActivity extends ActionBarActivity {

    TextView lblHumor, lblDetallesHumor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tips);

        lblHumor=(TextView)findViewById(R.id.LblHumor);
        lblDetallesHumor=(TextView)findViewById(R.id.LblDetallesHumor);


        Bundle b=this.getIntent().getExtras();

        lblHumor.setText(b.getString("humor"));

        if(b.getString("humor").equals("Choque")){
            lblDetallesHumor.setText(" 1. NO Dejar la escena del choque:huir de la escena del choque –si alguien está herido o falleció- y no prestar ayuda es motivo de crimen.\n" +
                    "2. Reportar el accidente:ante nuestro seguro siempre será mejor; con ello el agente de seguros podrá ver y determinar las condiciones de tu unidad, así como quedar registrado de que tuviste un accidente. \n" +
                    "3. NO Perder la calma:No empieces a buscar culpas, gritarle o insultarlo. No vas arreglar nada y a nadie le va a beneficiar. Respira profundo y mantén la calma.\n" +
                    "4. Dejar que tu seguro o la policía trabaje:ellos se encargan de evaluar, coordinar y ajustar todo lo que sea necesario con el dueño del otro vehículo.");

        }
        else if(b.getString("humor").equals("Reglamentos de seguridad")){
            lblDetallesHumor.setText("ACTUALIZADOS:\n");
        }
        else if(b.getString("humor").equals("Falta de gasolina")){
            lblDetallesHumor.setText("Lo primero que tienes que hacer si tu coche se queda sin gasolina es intentar apartarlo lo más a la derecha de la carretera, colocarte el chaleco de seguridad y, a continuación, colocar los triángulos para que el resto de los conductores que circulan por la vía puedan ver bien tu automóvil. Lee este artículo para saber en detalle cómo tienes que colocar los triángulos y recuerda que el vehículo no deberá entorpecer la circulación, ya que además de poner en peligro a otros conductores podrás ganarte una multa.\n" +
                    "\n" +
                    "En el caso de que te quedes sin gasolina en ciudad, trata de apartar el coche hacia un lugar en el que se pueda estacionar.\n");
        }
        else if(b.getString("humor").equals("Falta de frenos")){
            lblDetallesHumor.setText("1.¡No entres en pánico! Una reacción exagerada en esta situación solo hará que sea más peligroso\n" +
                    "2.Quita el pie del acelerador y desactiva el control de crucero (si está encendido).\n" +
                    "3.Presta atención a cómo sientes el pedal del freno. \n" +
                    "4.Bombea tus frenos:Baja la velocidad. El cambio a marchas inferiores ayuda a bajar la velocidad utilizando el motor para frenar el coche\n" +
                    "5.Usa el freno de emergencia");
        }
        else if(b.getString("humor").equals("Causas")) {
            lblDetallesHumor.setText("Factor Humano: \n" +
                    "Los factores humanos son la causa del mayor porcentaje de accidentes de tránsito.\n" +
                    "Factor Mecánico:\n" +
                    "Vehículo en condiciones no adecuadas para su operación (sistemas averiados de frenos, eléctrico, dirección o suspensión).\n" +
                    "Mantenimiento inadecuado del vehículo.\n" +
                    "Factor Climatológico:\n" +
                    "Niebla, humedad, derrumbes, zonas inestables, hundimientos.\n" +
                    "Factor estructural de tránsito:\n" +
                    "Errores de señalamientos viales");
        }

        Button button = (Button)findViewById(R.id.button);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);


        button.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Uri uri =  Uri . parse ( "http://www.ordenjuridico.gob.mx/Estatal/QUERETARO/Reglamentos/QROREG09.pdf" );
                        Intent intent =  new  Intent ( Intent . ACTION_VIEW , uri );
                        startActivity ( intent );

                    }



                }
        );
        button1.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Uri uri =  Uri . parse ( "http://vlex.com.mx/tags/reglamento-transito-tequisquiapan-queretaro-449993"
                                 );
                        Intent intent =  new  Intent ( Intent . ACTION_VIEW , uri );
                        startActivity ( intent );

                    }



                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Uri uri =  Uri . parse ( "http://pedroescobedo.gob.mx/pdf/frac4/r2.pdf" );
                        Intent intent =  new  Intent ( Intent . ACTION_VIEW , uri );
                        startActivity ( intent );

                    }



                }
        );
        button3.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Uri uri =  Uri . parse ( "http://www.sanjuandelrio.gob.mx/sjr/docs/uig/I_12.pdf" );
                        Intent intent =  new  Intent ( Intent . ACTION_VIEW , uri );
                        startActivity ( intent );

                    }



                }
        );


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_humor, menu);
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
