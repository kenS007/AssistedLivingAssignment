import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;


public class LoadFile {
	ArrayList<Course> courseList=new ArrayList<Course>();
	ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
	Hashtable<Course,ArrayList<Ingredient>> courseTable=new Hashtable<Course,ArrayList<Ingredient>>();
	
	
	/**
	 * scans textfile and returns and ArrayList of Ingredients
	 * 
	 * @param path - path of the textfile
	 * @return ArrayList of Ingredients
	 * 
	 */
	public ArrayList<Ingredient> loadIngredient(String path){
		//ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
		File file=new File(path);
		try{
			Scanner in=new Scanner(file);
			
			while(in.hasNext()){
				
				String line=in.nextLine(); //read line then split name and cost
				String[] inNameCost=line.split(",");
				
				if (inNameCost.length==2){
				Ingredient ingredient=new Ingredient(inNameCost[0],Double.parseDouble(inNameCost[1]));
				//System.out.println(inNameCost[0]+" "+inNameCost[1]);
					ingredientList.add(ingredient);
				}
			}
			System.out.println(ingredientList.toString());
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return ingredientList;
		
	}
	
	
	public void addInToCourse(){
		
	}
	public int getIngredientIndex(String ingName){
		for(Ingredient ing:ingredientList){
			if(ing.getName().equals(ingName)){
				
			}
		}
		for(int i=0;i<ingredientList.size();i++){
			if(ingredientList.get(i).getName().equals(ingName)){
				return i;
			}
		}
		
		
		return -1;  //return -1 if the ingredient doesnt exist
	}
	
	public ArrayList<Course> loadCourse(String path){
		//ArrayList<Course> courseList=new ArrayList<Course>();
		File file =new File(path);
		
		try{
			Scanner in=new Scanner(file);
			
			while(in.hasNext()){
				String line=in.nextLine();
				String[] c =line.split(",");
				c[0]=c[0].toLowerCase();
				
				Boolean courseExists=false;

				if (!courseList.isEmpty()) {
					for (Course course : courseList) {
						System.out.println("!");
						if (course.getName().equals(c[0])) {
							int indx=getIngredientIndex(c[1]);
							if(indx!=-1){
								//check if the ingredient is already in the course
								//if it already exist increment unit or 
								//if it doesnt add it to the course ingredient list
								// and add unit
								
							}else{
								System.out.println("Error: ingredient "+c[1]+" doesnt exist");
							}
									
							
							break;
						}
					}
				}
				if(!courseExists){
					System.out.println(c[0]+" it doesnt exist");
					Course cor=new Course();
					cor.setName(c[0]);
					courseList.add(cor);
					
					//add ingredient
					int indx=getIngredientIndex(c[1]);
					if(indx!=-1){//if ingredient is in the list
						cor.addIngredient(ingredientList.get(indx));
						
					}else{
						System.out.println("error:ingredient: "+c[1]+" doesnt exist");
					}
					
				}
				System.out.println(courseList);
				
				
				
			}
			in.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return courseList;
	}
	public ArrayList<Meal> loadMeal(String path){
		ArrayList<Meal> mealList=new ArrayList<Meal>();
		File file =new File(path);
		
		try{
			Scanner in =new Scanner(file);
			while(in.hasNext()){
				String line=in.nextLine();
				String[] m =line.split(",");
				
				//add code
				
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		return mealList;
	}

	
	
	
	
	
	
	
	
	public ArrayList<String> loadCourseString(String path){
		ArrayList<String> courseListS=new ArrayList<String>();
		File file=new File(path);
		
		try{
			Scanner in=new Scanner(file);
			
			while (in.hasNext()){
				String line=in.nextLine();
				
				courseListS.add(line);
				
				

			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
		return courseListS;
	}
	
	public ArrayList<String> loadCourseRestrictionString(String path){
		ArrayList<String> cRList=new ArrayList<String>();
		File file=new File(path);
		try{
			Scanner in=new Scanner(file);
			
			while(in.hasNext()){
				String line=in.nextLine();
				
				cRList.add(line);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		return cRList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoadFile load =new LoadFile();
		//load.loadtxt("ingredients.txt");
		//load.loadCourseString("courses.txt");
		
		load.loadCourse("courses.txt");
		
		
	}

}
