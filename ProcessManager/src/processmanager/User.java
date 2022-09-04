package processmanager;

public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public String toString()
	{
		String s ="name is "+this.name;
		return s;
	}
	

}
