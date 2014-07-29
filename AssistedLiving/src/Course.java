import java.util.ArrayList;


public class Course {
	
	
	ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
	
	private String name;
	
	
	private Double cost;
	
	
	public void setName(String name){
		this.name=name;
		 
		
	}
	public String getName(){
		return name;
	}
	
	public double getTotalCost(){
		double total=0;
		
		for(Ingredient ingredient:ingredientList){
			total=total+ingredient.getCost();
		}
		
		
		
		return total;
	}
	public Boolean ingredientExists(String ingredient){
		for(Ingredient ing :ingredientList){
			if(ing.getName().equals(ingredient)){//the ingredient is alredy in the list
					return true;
				}
			
		}
		
		return false;
			
	}
	public int getCourseIngredientIndex(String ingName){
		for(int i=0;i<ingredientList.size();i++){
			if(ingredientList.get(i).name.equals(ingName)){
				return i;
			}
		}
		
		
		
		return -1;
	}
	
	
	public void addIngredient(Ingredient in){
		this.ingredientList.add(in);
	}
	public void addIngredient(Ingredient ing,double numUnit){
		Ingredient in=ing;
		in.addNumUnitBy(numUnit);
		this.ingredientList.add(in);
	}
	
	public String toString(){
		return name+" "+ingredientList;
	}
	
	public ArrayList<Ingredient> getIngredientlist(){
		return ingredientList;
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
