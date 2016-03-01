package cs320.midterm;

public class Car {
	private int id;
	private String make;
	private String model;
	private String year;
	
	public Car(){
		
	}
	public Car(int id, String make, String model, String year){
		this.id= id;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}