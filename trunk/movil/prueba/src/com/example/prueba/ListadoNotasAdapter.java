package com.example.prueba;

import java.util.ArrayList;
import java.util.List;

import com.sacooliveros.gestionacademica.bean.NotaBean;
import com.sacooliveros.intranet.controller.NotaController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListadoNotasAdapter extends ArrayAdapter<NotaBean> implements Filterable{

	private List<NotaBean> items;
	int resource;
	Context context;

	public ListadoNotasAdapter(Context context, int resource,
			List<NotaBean> items) {
		super(context, resource);
		this.context = context;
		this.items = items;
		this.resource = resource;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		NotaBean item = items.get(position);
		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtCurso = (TextView) nuevaVista.findViewById(R.id.frmNotaItem_txtCurso);
		TextView txtNota = (TextView) nuevaVista.findViewById(R.id.frmNotaItem_txtNota);
		
		txtCurso.setText(item.getCurso());
		txtNota.setText(item.getNota());

		return nuevaVista;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public NotaBean getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}


	@Override
    public Filter getFilter() {

        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // Now we have to inform the adapter about the new list filtered
                if (results.count == 0){
                    notifyDataSetInvalidated();
                } else {
                	items = (List<NotaBean>) results.values;
                    notifyDataSetChanged();
                }
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
            	FilterResults results = new FilterResults();
        	    // We implement here the filter logic
        	    if (constraint == null || constraint.length() == 0) {
        	    	items = NotaController.getInstance().getItemSelected().getNotas();
        	        // No filter implemented we return all the list
        	        results.values = items;
        	        results.count = items.size();
        	    }
        	    else {
        	        // We perform filtering operation
        	        List<NotaBean> nList = new ArrayList<NotaBean>();
        	         
        	        for (NotaBean p : items) {
        	            if (p.getCurso().toUpperCase().contains(constraint.toString().toUpperCase()))
        	            	nList.add(p);
        	        }
        	         
        	        results.values = nList;
        	        results.count = nList.size();
        	    }
        	    return results;            	
            }
        };

        return filter;
    }

}