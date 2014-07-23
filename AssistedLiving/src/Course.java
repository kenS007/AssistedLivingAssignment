import java.util.ArrayList;


public class Course {
	
	
	ArrayList<Ingredient> ingredientList;
	
	String name;
	
	
	Double cost;
	
	
	public void setName(String name){
		this.name=name;
		
		
	}
	public String getname(){
		return name;
	}
	
	public double getTotalCost(){
		double total=0;
		
		for(Ingredient ingredient:ingredientList){
			total=total+ingredient.getCost();
		}
		
		
		
		return total;
	}
	
	
	public void addIngredient(Ingredient in){
		this.ingredientList.add(in);
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
