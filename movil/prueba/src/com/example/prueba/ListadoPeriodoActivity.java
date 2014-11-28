package com.example.prueba;

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
import com.sacooliveros.gestionacademica.bean.ListadoPeriodoBean;
import com.sacooliveros.gestionacademica.bean.PeriodoBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.controller.NotaController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ListadoPeriodoActivity extends MenuActivity implements OnClickListener, Loadingable{

	TextView txtNombres, txtApellidos;
	Button btnRegresar;
	ListView lstPeriodos;
	ListadoPeriodosAdapter adapter;
	List<PeriodoBean> data;
	String mensaje;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_periodos);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }

	private void rellenarElementos(){
		AlumnoBean session = AlumnoController.getInstance().getSession(); 
		txtNombres.setText(session.getNombres());
		txtApellidos.setText(session.getApellidoPaterno() + " " + session.getApellidoMaterno());

		// Configuracion de atributos <Cabecera, boton>
		
		adapter = new ListadoPeriodosAdapter(this,
				R.layout.frm_periodos_item, data);
		lstPeriodos.setAdapter(adapter);
		lstPeriodos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int pos = arg2;
				NotaController.getInstance().select(pos);
	    		Intent i = new Intent(getBaseContext(), ListadoNotaActivity.class);
	        	startActivity(i);
				//Toast.makeText(ListadoPeriodoActivity.this, "hola:"+arg2, 20).show();
			}
		});
	}

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        

    	btnRegresar = (Button) findViewById(R.id.frmPeriodos_btnRegresar);
    	lstPeriodos = (ListView) findViewById(R.id.frmPeriodos_lstPeriodos);
		txtNombres = (TextView) findViewById(R.id.frmPeriodos_txtNombres);
		txtApellidos = (TextView) findViewById(R.id.frmPeriodos_txtApellidos);
		

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		new LoadTaskDialog(ListadoPeriodoActivity.this, null,
				new HyundaiProgressDialog(ListadoPeriodoActivity.this)).execute();
    }

	@Override
    public void onClick(View v){
    	if(v.equals(btnRegresar)){
    		finish();  		
    	}
    }

	//@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if(view.equals(lstPeriodos)){
			NotaController.getInstance().select(position);
    		Intent i = new Intent(this, ListadoNotaActivity.class);
        	startActivity(i);
		}
	}
	
	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void loadingData() {
		ListadoPeriodoBean listadoResponse;
		String alumnoId;
		mensaje = "";
		try {
			alumnoId = getUsuario().getUsername();
			listadoResponse = NotaController.getInstance().consultar(alumnoId);
			if(listadoResponse.getMensajeError() != null){
				mensaje = listadoResponse.getMensajeError();
			}else{
				data = listadoResponse.getPeriodos();
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
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
