package pojo;





public class Name_Nest {
	
	
    private	String firstname;
    private 	String lastname;
    
    // Constructor
    public Name_Nest (String firstname,String lastname)
    {
    	this.firstname =firstname;
    	this.lastname=lastname;
    	
    }

    // Getter and Setter 
    
    
    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname()
    {
    	return firstname;
    }
    
    public void setFirstname(String firstname)
    {
    	this.firstname =firstname;
    }
    
    
    
}
