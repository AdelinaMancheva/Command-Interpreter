import java.util.HashMap;

public class VarHashMap {
	
	private static HashMap<String, String> map;
	
	public VarHashMap(){
		map = new HashMap<String, String>();
	}
	
	public void set(String key, String value){
		map.put(key, value);
	}
	
	public static String get(String key){
		// returns [type] value
		
		Object tmp = key;
		return ((tmp instanceof Integer) ? "[Integer]" : "[String]") +" " + tmp;
	
	}
	
	public static String getValueType(String args){
		String[] arrayArgs = args.split(" ");
		return arrayArgs[1];
	}

}
