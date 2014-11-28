package com.example.prueba;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.intranet.bean.MesBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ListadoMesActivity extends MenuActivity implements OnClickListener, Loadingable{

	TextView txtNombres, txtApellidos;
	Button btnRegresar;
	ListView lstMeses;
	ListadoMesesAdapter adapter;
	List<MesBean> data;
	String mensaje;
	
	static MesBean mes;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_meses);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }
	
	private void rellenarElementos(){
		AlumnoBean session = AlumnoController.getInstance().getSession(); 
		txtNombres.setText(session.getNombres());
		txtApellidos.setText(session.getApellidoPaterno() + " " + session.getApellidoMaterno());

		// Configuracion de atributos <Cabecera, boton>
		
		adapter = new ListadoMesesAdapter(this,
				R.layout.frm_meses_item, data);
		lstMeses.setAdapter(adapter);
		lstMeses.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int pos = arg2;
				mes = data.get(pos);
				
	    		Intent i = new Intent(getBaseContext(), ListadoAsistenciaActivity.class);
	        	startActivity(i);
				//Toast.makeText(ListadoPeriodoActivity.this, "hola:"+arg2, 20).show();
			}
		});
	}

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        

    	btnRegresar = (Button) findViewById(R.id.frmMeses_btnRegresar);
    	lstMeses = (ListView) findViewById(R.id.frmMeses_lstMeses);
		txtNombres = (TextView) findViewById(R.id.frmMeses_txtNombres);
		txtApellidos = (TextView) findViewById(R.id.frmMeses_txtApellidos);
		

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		new LoadTaskDialog(ListadoMesActivity.this, null,
				new HyundaiProgressDialog(ListadoMesActivity.this)).execute();
    }

    
    private void cargarMeses(){
    	data = new ArrayList<MesBean>();
    	data.add(new MesBean("1", "Enero"));
    	data.add(new MesBean("2", "Febrero"));
    	data.add(new MesBean("3", "Marzo"));
    	data.add(new MesBean("4", "Abril"));
    	data.add(new MesBean("5", "Mayo"));
    	data.add(new MesBean("6", "Junio"));
    	data.add(new MesBean("7", "Julio"));
    	data.add(new MesBean("8", "Agosto"));
    	data.add(new MesBean("9", "Septiembre"));
    	data.add(new MesBean("10", "Octubre"));
    	data.add(new MesBean("11", "Nobiembre"));
    	data.add(new MesBean("12", "Diciembre"));
    }
    
	@Override
    public void onClick(View v){
    	if(v.equals(btnRegresar)){
    		finish();  		
    	}
    }


	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void loadingData() {
    	cargarMeses();
	}

	@Override
	public void afterLoadingData() {
		if (mensaje == null || mensaje.length() == 0){
			rellenarElementos();
		}else{
			Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
		}
		
	}

	
}
