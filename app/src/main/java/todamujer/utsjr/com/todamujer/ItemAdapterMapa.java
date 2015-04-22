package todamujer.utsjr.com.todamujer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yonathan on 08/03/2015.
 */
public class ItemAdapterMapa extends BaseAdapter {

    private Context context;
    private List<ItemMapa> items;

    public ItemAdapterMapa(Context context, List<ItemMapa> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=convertView;

        if(convertView==null){
            //creamos una vista en la ListView
            LayoutInflater inflater=(LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView=inflater.inflate(R.layout.list_item_mapa,parent,false);
        }

        //colocamos los valores en la vista

        ImageView imgItemEmba=(ImageView)rowView.findViewById(R.id.ImgItemEmba);
        TextView lblEmba=(TextView)rowView.findViewById(R.id.LblEmba);


        ItemMapa itemEmba=this.items.get(position);
        lblEmba.setText(itemEmba.getEmba());
        imgItemEmba.setImageResource(itemEmba.getImagenEmba());


        return rowView;
    }
}
