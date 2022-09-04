package cagatayalptekin;

public class Customer 
{
	String name;
	String telephone;
	String address;
	
	Home[] hm;
	int homeCounter;
	double payment;
	public Customer(String name, String telephone, String address) {
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		hm=new Home[20];
		payment=0;
		homeCounter=0;
		
	}
	public void listHome()
	{
		int i=0;
		while(hm[i]!=null)
		{
			System.out.println("Customerin evi:"+"Fiyat "+hm[i].getPrice()+"Sehir: "+hm[i].getLocation());
		i++;
		}
	}
	public void buyHome(Home ev)
	{
		int i=0;
		while(hm[i]!=null) {
			i++;
		}
		hm[i]=ev;
		payment+=ev.getPrice();
		//homeCounter++;
		
		}
	public String getInfo()
	{
		String bilgi;
	    bilgi="Musteri ismi "+this.name+"alinan ev sayisi: "+this.homeCounter+"odenen para "+this.payment;
        return bilgi;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHomeCounter() {
		return homeCounter;
	}
	public void setHomeCounter(int homeCounter) {
		this.homeCounter = homeCounter;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}

}
