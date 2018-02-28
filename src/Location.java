
public class Location {
	
	boolean visible ;
	String coden ;
	String ma ;
	public Location (boolean flip, String codename, String team) {
		
		visible = flip ;
		coden = codename ; 
		ma = team ;
		
		
	}
	
	public boolean getVisibility() {
		return visible ;
	}
	
	public String getCodeName() {
		return coden ;
	}
	public String getTeam() {
		return ma ; 
	}
	
	
	

}
