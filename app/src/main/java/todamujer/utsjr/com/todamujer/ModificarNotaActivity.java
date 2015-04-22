package todamujer.utsjr.com.todamujer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class ModificarNotaActivity extends ActionBarActivity {


    private EditText modificarTxtTitulo,modificarTxtFecha,modificarTxtNota;
    private Button modificarBtnRegistrar, modificarBtnRegresar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_nota);

        modificarTxtTitulo=(EditText)findViewById(R.id.ModificarTxtTitulo);
        modificarTxtFecha=(EditText)findViewById(R.id.ModificarTxtFecha);
        modificarTxtNota=(EditText)findViewById(R.id.ModificarTxtNota);
        modificarBtnRegistrar=(Button)findViewById(R.id.ModificarBtnRegistrar);
        modificarBtnRegresar=(Button)findViewById(R.id.ModificarBtnRegresar);


        NotaDAO ndao=new NotaDAO(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        Nota n=new Nota();

        try{
            ndao.open();
            n=ndao.buscarNota(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ndao.close();
        }



        modificarTxtTitulo.setText(n.getTitulo());
        modificarTxtFecha.setText(n.getFecha());
        modificarTxtNota.setText(n.getNota());

        modificarBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nota n = new Nota();
                n.setId(ModificarNotaActivity.this.id);
                n.setTitulo(modificarTxtTitulo.getText().toString());
                n.setFecha(modificarTxtFecha.getText().toString());
                n.setNota(modificarTxtNota.getText().toString());

                NotaDAO ndao = new NotaDAO(ModificarNotaActivity.this);
                try {
                    ndao.open();
                    if (ndao.modificarNota(n)) {
                        Toast.makeText(ModificarNotaActivity.this, "Nota modificada", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ModificarNotaActivity.this, "Nota modificada", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException sqle) {

                } finally {


                    ndao.close();
                }

                ModificarNotaActivity.this.finish();
            }
        });

        modificarBtnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModificarNotaActivity.this.finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_nota, menu);
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
