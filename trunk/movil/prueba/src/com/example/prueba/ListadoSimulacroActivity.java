package com.example.prueba;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.ListadoSimulacroBean;
import com.sacooliveros.gestionacademica.bean.SimulacroBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.controller.SimulacroController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ListadoSimulacroActivity extends MenuActivity implements OnClickListener, Loadingable{

	TextView txtNombres, txtApellidos;
	Button btnRegresar;
	ListView lstSimulacros;
	ListadoSimulacrosAdapter adapter;
	List<SimulacroBean> data;
	String mensaje;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_simulacros);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }
	
	private void rellenarElementos(){
		AlumnoBean session = AlumnoController.getInstance().getSession(); 
		txtNombres.setText(session.getNombres());
		txtApellidos.setText(session.getApellidoPaterno() + " " + session.getApellidoMaterno());

		
		// Configuracion de atributos <Cabecera, boton>
		
		adapter = new ListadoSimulacrosAdapter(this,
				R.layout.frm_simulacros_item, data);
		lstSimulacros.setAdapter(adapter);
		/*lstMeses.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int pos = arg2;
				mes = data.get(pos);
	    		Intent i = new Intent(getBaseContext(), ListadoAsistenciaActivity.class);
	        	startActivity(i);
				//Toast.makeText(ListadoPeriodoActivity.this, "hola:"+arg2, 20).show();
			}
		});*/
	}

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        

    	btnRegresar = (Button) findViewById(R.id.frmSimulacros_btnRegresar);
    	lstSimulacros = (ListView) findViewById(R.id.frmSimulacros_lstSimulacros);
		txtNombres = (TextView) findViewById(R.id.frmSimulacros_txtNombres);
		txtApellidos = (TextView) findViewById(R.id.frmSimulacros_txtApellidos);
		

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		new LoadTaskDialog(ListadoSimulacroActivity.this, null,
				new HyundaiProgressDialog(ListadoSimulacroActivity.this)).execute();
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
		String alumnoId;
		ListadoSimulacroBean bean;
		mensaje = "";
		try {

			alumnoId = getUsuario().getUsername();
			bean = SimulacroController.getInstance().consultar(alumnoId);
			
			if(bean.getMensajeError() != null){
				mensaje = bean.getMensajeError();
			}else{
				data = bean.getSimulacros();
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
