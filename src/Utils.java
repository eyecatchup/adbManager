import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;


public class Utils {
	private static String appdata_folder;
	public static String os = System.getProperty("os.name");
	public static String uh = System.getProperty("user.home");
	public static String ds = System.getProperty("file.separator");
	public static String APPNAME = "adbManager";
	public static String device_uuid = "";
	public static String adb_location = "";
	
	public static String getAppDataFolder(){
		if(os.indexOf("Windows") == 0){
			appdata_folder=uh+ds+"AppData\\Roaming"+ds+APPNAME+ds;
		}
		else if(os.indexOf("Linux") == 0) {
			appdata_folder=uh+ds+"."+APPNAME+ds;
		}
		return appdata_folder;
	}
	
	public static String whereIsAdb(){
		String padb = Preference.getAdbLocation();
		File f = new File(padb);

		if(f.exists()){
			adb_location=padb;
			return padb;
		}
		
		if(os.indexOf("Windows") == 0){
			List<String> result = null;
    		
    		result = Utils.Execute("adb version");
    		
    		if (result != null) {
    			for (String line : result) {
    				if(!line.isEmpty()){
    					if(line.indexOf("Android Debug Bridge version") == 0){
    						adb_location="adb.exe";
    						return "adb.exe";
    					}
    				}
    			}
    		}			
		}
		else if(os.indexOf("Linux") == 0) {
			List<String> result = null;
    		
    		result = Utils.Execute("adb version");
    		
    		if (result != null) {
    			for (String line : result) {
    				if(!line.isEmpty()){
    					if(line.indexOf("Android Debug Bridge version") == 0){
    						adb_location="adb";
    						return "adb";
    					}
    				}
    			}
    		}
			
		}
		adb_location="";
		return "";
	}
	
    public static void PleaseCloseMe(JFrame f){
    	f.setVisible(false);
    	f.dispose();
    }
	
	/*
	 * 
	 * *******************************************************************************************************
	 * 
	 * Copyright (C) 2012 Jorrit "Chainfire" Jongma
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
	 *
	 *      http://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
	
	public static List<String> Execute(String commands) {
		
		List<String> res = Collections.synchronizedList(new ArrayList<String>());
		
		try {
			
			Process process = Runtime.getRuntime().exec(commands);
			StreamGobbler STDOUT = new StreamGobbler(process.getInputStream(), res);
			
			STDOUT.start();
			process.waitFor();
			STDOUT.join();
			process.destroy();
			
			if (process.exitValue() == 255) {
				res = null;
			}			
		} catch (IOException e) {
			res = null;
		} catch (InterruptedException e) {
			res = null;
		}
		return res;
	}
}
