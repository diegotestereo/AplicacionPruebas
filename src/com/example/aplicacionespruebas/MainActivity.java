package com.example.aplicacionespruebas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiServicio.ACTIVIDAD=this;
        try {
        	Log.i(getClass().getSimpleName(), "Iniciando el servicio de la actividad");
        	Intent servicio = new Intent(this,MiServicio.class);
        	
        	if(startService(servicio)==null)
        	{
        		this.notificar("No se ha podido iniciar el  servicio");
        	}
        	else{
        		this.notificar("Servicio iniciado Correctamente");
        	}
		} catch (Exception e) {
			this.notificar(e.getMessage());
		}
    }

  @Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	  try {
		  Log.i(getClass().getSimpleName(), "Finalizando el servicio de la actividad");
      	Intent servicio = new Intent(this,MiServicio.class);
      	
      	if(stopService(servicio)){
      		this.notificar("Se finalizo el servicio perfectamente");
      	}
      	else{
      		this.notificar("No se a podido finalizar el servicio");
      	}
      	
      	try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	
		} catch (Exception e) {
			this.notificar(e.getMessage());
		}
	
}
    
    
    private void notificar(String cadena) {
	Context contexto =getApplicationContext();
	CharSequence texto= cadena;
	int duration= Toast.LENGTH_SHORT;
	
	Toast toast=Toast.makeText(contexto, texto, duration);
	toast.show();
	
		
	}


}
