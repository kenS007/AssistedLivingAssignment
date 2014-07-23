import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class LoadFile {
	
	
	
	
	/**
	 * scans textfile and returns and ArrayList of Ingredients
	 * 
	 * @param path - path of the textfile
	 * @return ArrayList of Ingredients
	 * 
	 */
	public ArrayList<Ingredient> loadIngredient(String path){
		ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
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
	
	
	public ArrayList loadCourse(String path){
		ArrayList<Course> courseList=new ArrayList<Course>();
		File file=new File(path);
		
		try{
			Scanner in=new Scanner(file);
			
			while (in.hasNext()){
				String line=in.nextLine();
				String[] corInCost=line.split(",");
				
				
				if(corInCost.length==3){
					//System.out.println(corInCost[0]+", "+corInCost[1]+", "+corInCost[2]);
					
					if(courseList.contains(corInCost[0])){
							
						System.out.println("It already exist");
						
					}else{
						
						Course course=new Course();
						course.setName(corInCost[0]);
						System.out.println("it works?"+course.getname());
						
					}
					
					
				/*	if(courseList.get(courseList.indexOf(corInCost[0])) == null){
						Course course=new Course();
						course.setName(corInCost[0]);
						System.out.println("This is working?"+course.getname());
					}*/
					
			
					
				}
			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
		return courseList;
	}
	
	/*public static ArrayList<Course> loadCourseRestriction(String path){
		
		
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoadFile load =new LoadFile();
		//load.loadtxt("ingredients.txt");
		load.loadCourse("courses.txt");
	}

}
