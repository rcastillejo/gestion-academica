package com.example.prueba;

import java.util.ArrayList;
import java.util.List;

import com.sacooliveros.gestionacademica.bean.SimulacroBean;
import com.sacooliveros.intranet.controller.SimulacroController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListadoSimulacrosAdapter extends ArrayAdapter<SimulacroBean> implements Filterable{

	private List<SimulacroBean> items;
	int resource;
	Context context;

	public ListadoSimulacrosAdapter(Context context, int resource,
			List<SimulacroBean> items) {
		super(context, resource);
		this.context = context;
		this.items = items;
		this.resource = resource;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		SimulacroBean item = items.get(position);
		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtSimulacro = (TextView) nuevaVista.findViewById(R.id.frmSimulacroItem_txtSimulacro);
		TextView txtPuntaje = (TextView) nuevaVista.findViewById(R.id.frmSimulacroItem_txtPuntaje);

		txtSimulacro.setText(item.getNombre());
		txtPuntaje.setText(item.getNota() + "");

		return nuevaVista;
	}
	
	
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public SimulacroBean getItem(int position) {
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
                	items = (List<SimulacroBean>) results.values;
                    notifyDataSetChanged();
                }
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
            	FilterResults results = new FilterResults();
        	    // We implement here the filter logic
        	    if (constraint == null || constraint.length() == 0) {
        	    	items = SimulacroController.getInstance().getSession().getSimulacros();
        	        // No filter implemented we return all the list
        	        results.values = items;
        	        results.count = items.size();
        	    }
        	    else {
        	        // We perform filtering operation
        	        List<SimulacroBean> nList = new ArrayList<SimulacroBean>();
        	         
        	        for (SimulacroBean p : items) {
        	            if (p.getNombre().toUpperCase().contains(constraint.toString().toUpperCase()))
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