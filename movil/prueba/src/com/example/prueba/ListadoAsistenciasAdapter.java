package com.example.prueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.sacooliveros.gestionacademica.bean.DetalleAsistenciaBean;
import com.sacooliveros.intranet.controller.AsistenciaController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListadoAsistenciasAdapter extends ArrayAdapter<DetalleAsistenciaBean> implements Filterable{

	private static final int MONTH_OFFSET = 1;
	private List<DetalleAsistenciaBean> items;
	int resource;
	Context context;

	public ListadoAsistenciasAdapter(Context context, int resource,
			List<DetalleAsistenciaBean> items) {
		super(context, resource);
		this.context = context;
		this.items = items;
		this.resource = resource;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		DetalleAsistenciaBean item = items.get(position);
		LinearLayout nuevaVista;

		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);

		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtNroDia = (TextView) nuevaVista.findViewById(R.id.frmAsistenciaItem_txtNroDia);
		TextView txtNomDia = (TextView) nuevaVista.findViewById(R.id.frmAsistenciaItem_txtNomDia);
		TextView txtEstado = (TextView) nuevaVista.findViewById(R.id.frmAsistenciaItem_txtEstado);

		int mes = Integer.parseInt(item.getMes());
		int dia = Integer.parseInt(item.getDia());
		
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, mes + MONTH_OFFSET); 
		c.set(Calendar.DAY_OF_MONTH, dia);

		txtNroDia.setText(item.getDia());
		txtNomDia.setText(c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
		txtEstado.setText(item.getEstado());

		return nuevaVista;
	}
	
	
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public DetalleAsistenciaBean getItem(int position) {
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
                	items = (List<DetalleAsistenciaBean>) results.values;
                    notifyDataSetChanged();
                }
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
            	FilterResults results = new FilterResults();
        	    // We implement here the filter logic
        	    if (constraint == null || constraint.length() == 0) {
        	    	items = AsistenciaController.getInstance().getSession().getDetalleAsistencia();
        	        // No filter implemented we return all the list
        	        results.values = items;
        	        results.count = items.size();
        	    }
        	    else {
        	        // We perform filtering operation
        	        List<DetalleAsistenciaBean> nList = new ArrayList<DetalleAsistenciaBean>();
        	         
        	        for (DetalleAsistenciaBean p : items) {
        	            if (p.getDia().toUpperCase().contains(constraint.toString().toUpperCase()))
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