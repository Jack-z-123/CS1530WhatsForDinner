import java.util.*;

public class Account {
	private String username;
	private String password;
	private String accountType;
	//not sure for the button attribute
	
	public Account(String username, String password, String accountType) {
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}

	public boolean trySignIn(String username, String password)
	{
		if (this.username == username && this.password == password)
		{
			return true;
		}
		return false;
	}
	
	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public String getAccountType()
	{
		return accountType;
	}
}