package com.polus.binil.apppro;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PackageManager pm = getApplicationContext().getPackageManager();
		pm.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP); 
	}

}
