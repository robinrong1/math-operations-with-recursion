import javax.swing.JOptionPane;

public class LoginForm {

	public LoginForm() {
		// TODO Auto-generated constructor stub
	}
	 public static void main(String arg[])  
	    {  
		
	        try  
	        {  
	            //create instance of the CreateLoginForm  
	            CreateLoginForm form = new CreateLoginForm();  
	            form.setSize(300,100);  //set size of the frame  
	            form.setVisible(true);  //make form visible to the user  
	        }  
	        catch(Exception e)  
	        {     
	            //handle exception   
	            JOptionPane.showMessageDialog(null, e.getMessage());  
	        }  
	    }  
}