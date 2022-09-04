package cagatayalptekin;

public abstract class Home 
{
	double price;
	String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Home(double price,String location)
	{
		this.price=price;
		this.location=location;
	}
	public abstract double discountedPrice();
	
		

}
