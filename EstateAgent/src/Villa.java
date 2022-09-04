package cagatayalptekin;

public class Villa extends Home 
{
   
	public Villa(double price, String location) {
		super(price, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double discountedPrice() {
		// TODO Auto-generated method stub
		
		price=price-price*0.10;
		return price;
	}
	

}
