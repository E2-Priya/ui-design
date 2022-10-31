package autoWiredWithxml;

public class Heart {
	private String nameOfanimal;
    private int noOfHeart;
	public String getNameOfanimal() {
		return nameOfanimal;
	}
	public int getNoOfHeart() {
		return noOfHeart;
	}
	public void setNameOfanimal(String nameOfanimal) {
		this.nameOfanimal = nameOfanimal;
	}
	public void setNoOfHeart(int noOfHeart) {
		this.noOfHeart = noOfHeart;
	}
    void pump() {
    	System.out.println("Heart is pumping");
    }
}
