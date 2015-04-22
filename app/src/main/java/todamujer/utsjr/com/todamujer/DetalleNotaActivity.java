package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;


public class DetalleNotaActivity extends ActionBarActivity {

    private TextView detallesLblTitulo, detallesLblFecha, detallesLblNota;
    private ImageButton detallesBtnEliminar, detallesBtnModificar;
    private int id;
    private String titulo,fecha,nota;
    private NotaDAO ndao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_nota);

        detallesLblTitulo=(TextView)findViewById(R.id.DetallesLblTitulo);
        detallesLblFecha=(TextView)findViewById(R.id.DetallesLblFecha);
        detallesLblNota=(TextView)findViewById(R.id.DetallesLblNota);
        detallesBtnEliminar=(ImageButton)findViewById(R.id.DetallesBtnEliminar);
        detallesBtnModificar=(ImageButton)findViewById(R.id.DetallesBtnModificar);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        titulo=b.getString("titulo");
        fecha=b.getString("fecha");
        nota=b.getString("nota");

        detallesLblTitulo.setText("TITULO: "+titulo);
        detallesLblFecha.setText("FECHA: "+fecha);
        detallesLblNota.setText("NOTA: "+nota);

        detallesBtnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modificarNota=new Intent(DetalleNotaActivity.this,ModificarNotaActivity.class);
                modificarNota.putExtra("id", id);
                startActivity(modificarNota);
                DetalleNotaActivity.this.finish();
            }
        });

        detallesBtnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ndao=new NotaDAO(DetalleNotaActivity.this);
                try{
                    ndao.open();
                    if(ndao.eliminarNota(id)){
                        Toast.makeText(DetalleNotaActivity.this, "Nota Eliminada.", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(DetalleNotaActivity.this,"Nota No Eliminada", Toast.LENGTH_LONG).show();
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                ndao.close();
                DetalleNotaActivity.this.finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_nota, menu);
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
