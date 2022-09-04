package cagatayalptekin;

public class Apartment extends Home {
    double dues;

	public Apartment(double price,String location,double dues) {
		super(price,location);
		this.dues = dues;
	}

	public double getDues() {
		return dues;
	}

	public void setDues(double dues) {
		this.dues = dues;
	}

	@Override
	public double discountedPrice() {
		// TODO Auto-generated method stub
		price=price-price*0.05;
		return price;
	}
    
}
