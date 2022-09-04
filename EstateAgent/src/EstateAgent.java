package cagatayalptekin;









public class EstateAgent 
{
	String name;
	Home[] h ;
	int count;
	public void asd()
	{
		count=0;
	}
    
	public EstateAgent() {
		super();
		h=new Home[20];
	}

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}
	public void hasHome(Home ev)
	{
		h[count]=ev;
		count++;
	}
	public void listHome()
	{
		int i=0;
		while(h[i]!=null)
		{
			System.out.println("Estate Agentin evi:"+"Fiyat "+h[i].getPrice()+"Sehir: "+h[i].getLocation());
		i++;
		}
	}
	public void sellHome(Home ev,Customer musteri)
	{
		for(int i=0;i<count;i++)
		{
			
			if(h[i]==ev)
			{
				
				musteri.homeCounter++;
				if(musteri.homeCounter>2)
	            {
				   h[i].setPrice(h[i].discountedPrice());
	            }
				musteri.buyHome(ev);
				
				count--;
				for (int j = i; j < count; j++)
                    h[j] = h[j+1];
                h[count] = null;
                
			}
			
		}
	}
	

}
