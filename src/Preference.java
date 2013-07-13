import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
 
public class Preference {
	static String pref = Utils.getAppDataFolder()+"preference.json";
	File pf = new File(Utils.getAppDataFolder());
	
	public Preference() {
    	 
    	if(!pf.exists()){
    		if(!pf.mkdirs()){
    			new Exception("Preference File Error");
    		}
    	}
    	
    	if(!(new File(pref).exists())){
			ObjectMapper mapper = new ObjectMapper();
		 
			Map<String, Object> userInMap = new HashMap<String, Object>();
			userInMap.put("adbDir", "");
			userInMap.put("lastDevice", "");
	
			try {
		 
				// write JSON to a file
				mapper.writeValue(new File(pref), userInMap);
		 
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ObjectMapper mapper2 = new ObjectMapper();
			 
			try {
		 
				// read JSON from a file
				Map<String, Object> userInMap2 = mapper2.readValue(new File(pref), new TypeReference<Map<String, Object>>() {});
		 
				System.out.println(userInMap2.get("adbDir"));
				System.out.println(userInMap2.get("lastDevice"));
		 
			} catch (JsonGenerationException e) {
		    	e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
	
	public static void setAdbLocation(String dir){
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
 
			BufferedReader fileReader = new BufferedReader(new FileReader(pref));
			JsonNode rootNode = mapper.readTree(fileReader);
			
			((ObjectNode)rootNode).remove("adbDir");
			((ObjectNode)rootNode).put("adbDir", dir);
 
			mapper.writeValue(new File(pref), rootNode);
 
		} catch (JsonGenerationException e) {
 
			e.printStackTrace();
 
		} catch (JsonMappingException e) {
 
			e.printStackTrace();
 
		} catch (IOException e) {
 
			e.printStackTrace();
 
		}
	}
	
	public static String getAdbLocation(){
		String adb = "";
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
 
			BufferedReader fileReader = new BufferedReader(new FileReader(pref));
			JsonNode rootNode = mapper.readTree(fileReader);
 
			JsonNode nameNode = rootNode.path("adbDir");
			System.out.println(nameNode.textValue());
			adb = nameNode.textValue();
			
		} catch (JsonGenerationException e) {
 
			e.printStackTrace();
 
		} catch (JsonMappingException e) {
 
			e.printStackTrace();
 
		} catch (IOException e) {
 
			e.printStackTrace();
 
		}
		return adb;
	}
	
	public static void setLastDevice(String dir){
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
 
			BufferedReader fileReader = new BufferedReader(new FileReader(pref));
			JsonNode rootNode = mapper.readTree(fileReader);
			
			((ObjectNode)rootNode).remove("lastDevice");
			((ObjectNode)rootNode).put("lastDevice", dir);
 
			mapper.writeValue(new File(pref), rootNode);
 
		} catch (JsonGenerationException e) {
 
			e.printStackTrace();
 
		} catch (JsonMappingException e) {
 
			e.printStackTrace();
 
		} catch (IOException e) {
 
			e.printStackTrace();
 
		}
	}
}