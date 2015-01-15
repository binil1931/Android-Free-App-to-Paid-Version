# Android demo for Free App change to Paid App

   Here we show the sample App for Free App and Paid App
   For this we need to develop two Application one for free and another for paid
   
   we should add all the functionality for the free App and we can lock the some functionality those we need to enable in Paid version
   
   Paid version App act as key to open the functionality in free App
  
 ## Steps
   
    1. Create free App with all functions and lock function those we want
	2. Create the paid App , it must invisible to the user after installing, so we not use intent filter in manifest
	3. Use the same signed key for both App for generating signed APK
	4. For opening the locked functionality in free App we check "package name of the paid App and signature"
	5. If the paid App is installed in the device then check the signature , it is used for avoid hacking and there is a chance for the same package name for the App
	6. if both condition same we get the results as true , so we can enable the lock functionality
	
## Code for check the paid app package name and signature	
	
	``` java
		private Boolean isProInstalled(Context context) {
		// TODO Auto-generated method stub
		String proPackage = "com.polus.binil.apppro";
		  // get the package manager
		  
		  final PackageManager pm = context.getPackageManager()
		  ;
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
	
```