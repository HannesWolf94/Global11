package beans;

import java.io.Serializable;


public class UserInfoAdmin implements Serializable  {
	
	 	private int userId;
	    private String userEmail;
	    private String userPassword;
	    private String userFirstName;
	    private String userLastName;
	    private String userStreet;
	    private String userCity;
	    private int userAdmin; 
	    

	    public UserInfoAdmin() {
	    }

	    
	    public int getUserId() {
	        return userId;
	    }
	    
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    
	    
	    public String getUserEmail() {
	        return userEmail;
	    }

	    public void setUserEmail(String userEmail) {
	        this.userEmail = userEmail;
	    }

	    
	    public String getUserPassword() {
	        return userPassword;
	    }

	    public void setUserPassword(String userPassword) {
	        this.userPassword = userPassword;
	    }
 
	    
	    public String getUserFirstName() {
	        return userFirstName;
	    }
	    public void setUserFirstName(String userFirstName) {
	        this.userFirstName = userFirstName;
	    }

	    
	    public String getUserLastName() {
	        return userLastName;
	    }

	    public void setUserLastName(String userLastName) {
	        this.userLastName = userLastName;
	    }
	    
	    
	    public String getUserStreet() {
	        return userStreet;
	    }

	    public void setUserStreet(String userStreet) {
	        this.userStreet = userStreet;
	    }

	    
	    public String getUserCity() {
	        return userCity;
	    }

	    public void setUserCity(String userCity) {
	        this.userCity = userCity;
	    }
	    
	    
	    public int getUserAdmin() {
	        return userAdmin;
	    }

	    public void setUserAdmin(int userAdmin) {
	        this.userAdmin = userAdmin;
	    }
	    


}
