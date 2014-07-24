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
	
	public ArrayList<Course> loadCourse(String path){
		ArrayList<Course> courseList=new ArrayList<Course>();
		File file =new File(path);
		
		try{
			Scanner in=new Scanner(file);
			
			while(in.hasNext()){
				String line=in.next();
				
				//check if the course already exist
				
				//if it doesnt exist creat a new one
				
				//if it does find the index 
					//check if the ingredient exists
					//if it doesnt add it to the ingredient list
					//if it does //increment the num of units???? idk
				
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return courseList;
	}
	
	
	
	
	
	public ArrayList<String> loadCourseString(String path){
		ArrayList<String> courseList=new ArrayList<String>();
		File file=new File(path);
		
		try{
			Scanner in=new Scanner(file);
			
			while (in.hasNext()){
				String line=in.nextLine();
				
				courseList.add(line);
				
				

			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
		return courseList;
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
		load.loadCourseString("courses.txt");
	}

}
