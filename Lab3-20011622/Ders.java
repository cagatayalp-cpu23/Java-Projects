package Lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Ders {
	private String dersAdi;
	private LinkedList<Ogrenci> ogrenciler;
	private int subeASayisi;
	private int subeBSayisi;
	private int ogrenciSayisi;
	public Ders(String dersAdi)
	{
		this.dersAdi=dersAdi;
		ogrenciler=new LinkedList<Ogrenci>();
	}
	public String getDersAdi() {
		return dersAdi;
	}
	public LinkedList<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}
	public void dosyaOku(String dosyaAdi)
	{
		 try {
		     FileInputStream in = new FileInputStream(dosyaAdi);
		     
		     ObjectInputStream objectinputstream = new ObjectInputStream(in);
		 
		    
		    	
		    
		      ogrenciler = (LinkedList<Ogrenci>) objectinputstream.readObject();
		      objectinputstream.close();
		      
		 }
		  catch (Exception e) {
		     e.printStackTrace();
		 }
	}
	public void gruplaraAyir()
	{
		subeASayisi=(ogrenciler.size()+1)/2;
		subeBSayisi=ogrenciler.size()/2;
		ogrenciSayisi=ogrenciler.size();
		
	}
	public synchronized void ekranaYazdir()
	{
		for(Ogrenci ogr: ogrenciler) {
			System.out.println(ogr);
		}
	}
	public void hesapla()
	{
		LinkedList<Ogrenci> A = new LinkedList<>();
		LinkedList<Ogrenci> B = new LinkedList<>();
		int k=0;
		for(Ogrenci ogr : ogrenciler) {
			if(k<subeASayisi) {
				A.add(ogr);
			}
			else {
				B.add(ogr);
			}
			k++;
		}
		Thread hesapla1= new Thread(new Hesapla(A));
		Thread hesapla2= new Thread(new Hesapla(B));
		hesapla1.start();
		hesapla2.start();
		try {
			hesapla1.join();
			hesapla2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public class Hesapla implements Runnable
	{

		private LinkedList<Ogrenci> A;
		public Hesapla(LinkedList<Ogrenci> A) {
			this.A=A;
		}
		public void run() {
			for(int i=0;i<A.size();i++) {
				A.get(i).genelNotHesapla();
			}
		}
		
		
		
		
	}
	
	
	

}
