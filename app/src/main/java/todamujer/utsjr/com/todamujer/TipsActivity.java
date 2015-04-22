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


public class TipsActivity extends ActionBarActivity {
    private ListView lstHumor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        lstHumor=(ListView)findViewById(R.id.LstHumor);


        List<ItemTips> items=new ArrayList<ItemTips>();

        items.add(new ItemTips(R.drawable.choque,"Choque"));
        items.add(new ItemTips(R.drawable.reglamento,"Reglamentos de seguridad"));
        items.add(new ItemTips(R.drawable.gas,"Falta de gasolina"));
        items.add(new ItemTips(R.drawable.freno,"Falta de frenos"));
        items.add(new ItemTips(R.drawable.a,"Causas"));


        this.lstHumor.setAdapter(new ItemAdapterTips(this,items));

        lstHumor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemTips itemTips =(ItemTips)lstHumor.getAdapter().getItem(position);
                Intent intent=new Intent(TipsActivity.this,DetalleTipsActivity.class);
                Bundle b=new Bundle();
                b.putString("humor", itemTips.getHumor());
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_humor, menu);
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
