package com.example.aplicacionespruebas;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

public class MiServicio  extends Service{

	public static Activity ACTIVIDAD;
	private Timer timer=null;
	
	public static void establecerActividadPrincipal(Activity actividad)
	{
		MiServicio.ACTIVIDAD=actividad;
		
	}
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		this.inciarServicio();
		Log.i(getClass().getSimpleName(),"Servicio Iniciado");
	}
	
	

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		this.finalizarServicio();
		Log.i(getClass().getSimpleName(),"Servicio Detenido");
	}
	
	private void inciarServicio() {
		// TODO Auto-generated method stub
		
		try {
			
			Log.i(getClass().getSimpleName(),"Iniciando Servicio...");
			this.timer=new Timer();
			this.timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					ejecutarTarea();
					
				}

				
			}, 0, 1000);
			
			
		} catch (Exception e) {
			Log.i(getClass().getSimpleName(),e.getMessage());
		}
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	private void finalizarServicio() {
		try {
			Log.i(getClass().getSimpleName(),"Finalizando Servicio");
			this.timer.cancel();
			Log.i(getClass().getSimpleName(),"Servicio Detenido");
		} catch (Exception e) {
			Log.i(getClass().getSimpleName(),e.getMessage());
		}
		
		
	}
	
	private void ejecutarTarea() {
		Log.i(getClass().getSimpleName(),"Ejecutando Tarea");
		MiServicio.ACTIVIDAD.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				TextView ejecuciones=(TextView)MiServicio.ACTIVIDAD.findViewById(R.id.textView1);
				ejecuciones.append(".");
				
			}
		});
		
	}
	
}
