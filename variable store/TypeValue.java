public class TypeValue {
	
	private String type;
	private String value;
	
	public TypeValue(String t, String v){
		type = t;
		value = v;
	}
	
	public String getType(){
		return type;
	}
	
	public String getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return "[" + type + "] " + value;
	}
}
