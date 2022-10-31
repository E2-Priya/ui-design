package autoWiredWithxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human{
	private Heart heart;
	
	public Heart getHeart() {
		return heart;
	}
@Autowired
@Qualifier("heart1")
	public void setHeart(Heart heart) {
		this.heart = heart;
	}
public void humanpump() {
	heart. pump();
	System.out.println("Name of the heart "+heart.getNameOfanimal()+" No of heart "+heart.getNoOfHeart());
}
}
