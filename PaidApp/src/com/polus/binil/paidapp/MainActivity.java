package com.polus.binil.paidapp;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

	Boolean pro = false;
	Button btn_pro1,btn_pro2,btn_pro3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_main);
		
		btn_pro1 = (Button) findViewById(R.id.btn_pro1);
		btn_pro2 = (Button) findViewById(R.id.btn_pro2);
		btn_pro3=  (Button) findViewById(R.id.btn_pro3);
		
      pro =  isProInstalled(getApplicationContext());
	
	  if(pro)
	  {
		  btn_pro1.setVisibility(View.VISIBLE);
		  btn_pro2.setVisibility(View.VISIBLE);
		  btn_pro3.setVisibility(View.VISIBLE);
	  }
	  else
	  {
		  btn_pro1.setVisibility(View.INVISIBLE);
		  btn_pro2.setVisibility(View.INVISIBLE);
		  btn_pro3.setVisibility(View.INVISIBLE);
	  }
	 
	
	}

	private Boolean isProInstalled(Context context) {
		// TODO Auto-generated method stub
		String proPackage = "com.polus.binil.apppro";
		  // get the package manager
		  final PackageManager pm = context.getPackageManager();
		  // get a list of installed packages
		  List<PackageInfo> list = pm.getInstalledPackages(PackageManager.GET_DISABLED_COMPONENTS);
		  // let's iterate through the list
		  Iterator<PackageInfo> i = list.iterator();
		  while(i.hasNext()) {
		    PackageInfo p = i.next();
		    // check if proPackage is in the list AND whether that package is signed
		    //  with the same signature as THIS package
		    if((p.packageName.equals(proPackage)) &&
		       (pm.checkSignatures(context.getPackageName(), p.packageName) == PackageManager.SIGNATURE_MATCH))
		      return true;
		  }
		  return false;

	}

}
