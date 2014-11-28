package com.example.prueba;

import java.util.ArrayList;
import java.util.List;

import com.sacooliveros.gestionacademica.bean.PeriodoBean;
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

public class ListadoPeriodosAdapter extends ArrayAdapter<PeriodoBean> implements Filterable{

	private List<PeriodoBean> items;
	int resource;
	Context context;

	public ListadoPeriodosAdapter(Context context, int resource,
			List<PeriodoBean> items) {
		super(context, resource);
		this.context = context;
		this.items = items;
		this.resource = resource;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		PeriodoBean item = items.get(position);
		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtNombre = (TextView) nuevaVista.findViewById(R.id.frmPeriodoItem_txtPeriodo);
		
	    txtNombre.setText(item.getNombre());

		return nuevaVista;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public PeriodoBean getItem(int position) {
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
                	items = (List<PeriodoBean>) results.values;
                    notifyDataSetChanged();
                }
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
            	FilterResults results = new FilterResults();
        	    // We implement here the filter logic
        	    if (constraint == null || constraint.length() == 0) {
        	    	items = NotaController.getInstance().getSession().getPeriodos();
        	        // No filter implemented we return all the list
        	        results.values = items;
        	        results.count = items.size();
        	    }
        	    else {
        	        // We perform filtering operation
        	        List<PeriodoBean> nClienteList = new ArrayList<PeriodoBean>();
        	         
        	        for (PeriodoBean p : items) {
        	            if (p.getNombre().toUpperCase().contains(constraint.toString().toUpperCase()))
        	            	nClienteList.add(p);
        	        }
        	         
        	        results.values = nClienteList;
        	        results.count = nClienteList.size();
        	    }
        	    return results;            	
            }
        };

        return filter;
    }

}