package todamujer.utsjr.com.todamujer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yonathan on 13/04/2015.
 */
public class AdaptadorNota extends BaseAdapter{

    private static ArrayList<Nota> searchArrayList;
    private LayoutInflater mInflater;

    public AdaptadorNota(Context context,ArrayList<Nota> results) {
        searchArrayList=results;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return searchArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null){
            convertView=mInflater.inflate(R.layout.list_item_nota, null);
            holder=new ViewHolder();
            holder.txtFecha=(TextView) convertView.findViewById(R.id.LblFecha);
            holder.txtTitulo=(TextView) convertView.findViewById(R.id.LblTitulo);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }

        holder.txtFecha.setText(searchArrayList.get(position).getFecha());
        holder.txtTitulo.setText(searchArrayList.get(position).getTitulo());

        return convertView;

    }

    static class ViewHolder{
        TextView txtFecha, txtTitulo;
    }
}
