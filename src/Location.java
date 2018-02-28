
public class Location {
	
	protected boolean visible ;
	protected String coden ;
	protected String ma ;
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
	
	public void setVisibility(boolean setflip) {
		this.visible = setflip;
	}
	
	public void setCodeName(String setcoden) {
		this.coden = setcoden ;
	}
	public void setTeam(String setteam) {
		this.ma = setteam; 
	}
	
	
	

}
