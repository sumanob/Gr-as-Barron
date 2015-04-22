package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;


public class Nota_Activity extends ActionBarActivity {


    private ListView lstNotas;
    private Button btnAgregarNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_);

        lstNotas=(ListView)findViewById(R.id.LstNotas);
        btnAgregarNota=(Button)findViewById(R.id.BtnAgregarNota);

        NotaDAO ndao=new NotaDAO(this);
        try{
            ndao.open();
            ArrayList<Nota> searchResult=(ArrayList<Nota>)ndao.getNotas();
            lstNotas.setAdapter(new AdaptadorNota(this, searchResult));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ndao.close();
        }

        lstNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nota n=(Nota)lstNotas.getItemAtPosition(position);
                Intent datosNota=new Intent(Nota_Activity.this,DetalleNotaActivity.class);


                Bundle b=new Bundle();
                b.putInt("id",n.getId());
                b.putString("titulo", n.getTitulo());
                b.putString("fecha", n.getFecha());
                b.putString("nota", n.getNota());

                datosNota.putExtras(b);
                startActivity(datosNota);

            }
        });


        btnAgregarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registroNota=new Intent(Nota_Activity.this,AgregarNotaActivity.class);
                startActivity(registroNota);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        lstNotas=(ListView)findViewById(R.id.LstNotas);

        NotaDAO ndao=new NotaDAO(this);
        try{
            ndao.open();
            ArrayList<Nota> searchResult=(ArrayList<Nota>)ndao.getNotas();
            lstNotas.setAdapter(new AdaptadorNota(this, searchResult));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ndao.close();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nota_, menu);
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
