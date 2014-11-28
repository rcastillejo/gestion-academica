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
import com.sacooliveros.gestionacademica.bean.AsistenciaBean;
import com.sacooliveros.gestionacademica.bean.DetalleAsistenciaBean;
import com.sacooliveros.intranet.bean.MesBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.controller.AsistenciaController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ListadoAsistenciaActivity extends MenuActivity implements OnClickListener, Loadingable{

	TextView txtNombres, txtApellidos;
	Button btnRegresar;
	ListView lstAsistencias;
	ListadoAsistenciasAdapter adapter;
	List<DetalleAsistenciaBean> data;
	String mensaje;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_asistencias);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }
	
	private void rellenarElementos(){
		AlumnoBean session = AlumnoController.getInstance().getSession(); 
		txtNombres.setText(session.getNombres());
		txtApellidos.setText(session.getApellidoPaterno() + " " + session.getApellidoMaterno());

		// Configuracion de atributos <Cabecera, boton>
		
		adapter = new ListadoAsistenciasAdapter(this,
				R.layout.frm_asistencias_item, data);
		lstAsistencias.setAdapter(adapter);
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

    	btnRegresar = (Button) findViewById(R.id.frmAsistencias_btnRegresar);
    	lstAsistencias = (ListView) findViewById(R.id.frmAsistencias_lstAsistencias);
		txtNombres = (TextView) findViewById(R.id.frmAsistencias_txtNombres);
		txtApellidos = (TextView) findViewById(R.id.frmAsistencias_txtApellidos);
		

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		new LoadTaskDialog(ListadoAsistenciaActivity.this, null,
				new HyundaiProgressDialog(ListadoAsistenciaActivity.this)).execute();
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
		MesBean mes;
		AsistenciaBean bean;
		mensaje = "";
		try {

			alumnoId = getUsuario().getUsername();
			mes = ListadoMesActivity.mes;
			bean = AsistenciaController.getInstance().consultar(alumnoId, mes.getId());
			
			if(bean.getMensajeError() != null){
				mensaje = bean.getMensajeError();
			}else{
				data = bean.getDetalleAsistencia();
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
