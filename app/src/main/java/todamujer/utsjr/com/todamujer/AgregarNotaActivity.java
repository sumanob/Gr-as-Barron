package todamujer.utsjr.com.todamujer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;


public class AgregarNotaActivity extends ActionBarActivity {

    private EditText txtTitulo, txtFecha, txtNota;
    private Button btnRegistrar, btnRegresar;
    private NotaDAO ndao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nota);


        txtTitulo=(EditText)findViewById(R.id.TxtTitulo);
        txtFecha=(EditText)findViewById(R.id.TxtFecha);
        txtNota=(EditText)findViewById(R.id.TxtNota);
        btnRegistrar=(Button)findViewById(R.id.BtnRegistrar);
        btnRegresar=(Button)findViewById(R.id.BtnRegresar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nota n=new Nota();
                n.setTitulo(txtTitulo.getText().toString());
                n.setFecha(txtFecha.getText().toString());
                n.setNota(txtNota.getText().toString());

                ndao=new NotaDAO(AgregarNotaActivity.this);
                try{
                    ndao.open();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                if(ndao.agregarNota(n)){
                    mostrarMensaje("Alta de nota", "Nota Guardada");
                }
                else{
                    mostrarMensaje("Ata de nota" , "Nota no guardada");

                }

            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarNotaActivity.this.finish();
            }
        });

    }

    private void mostrarMensaje(String titulo, String mensaje){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        TextView lblMensaje=new TextView(this);
        builder.setTitle(titulo);
        lblMensaje.setText(mensaje);
        lblMensaje.setTextSize(20);
        lblMensaje.setGravity(Gravity.CENTER_HORIZONTAL);
        builder.setView(lblMensaje);
        builder.setCancelable(false);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                ((EditText)(findViewById(R.id.TxtTitulo))).setText("");
                ((EditText)(findViewById(R.id.TxtFecha))).setText("");
                ((EditText)(findViewById(R.id.TxtNota))).setText("");

                ((EditText)(findViewById(R.id.TxtTitulo))).requestFocus();

            }
        });

        builder.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregar_nota, menu);
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
