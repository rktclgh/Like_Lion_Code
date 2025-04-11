package Work.WorkShop07.elite.test06;

public class Airplane extends Plane {

	public Airplane() {
	}

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	
	  @Override public void flight(int distance) { 
		  
		  this.setFuelSize(this.getFuelSize() - (distance / 10) * 30);
	  }

}
