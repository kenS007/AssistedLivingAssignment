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
				String line=in.nextLine();
				String[] c =line.split(",");
				c[0]=c[0].toLowerCase();
				
				Boolean courseExists=false;
				for(Course course:courseList){
					if(course.getName()==c[0]){
						System.out.println(c[0]+" it exists");
						courseExists=true;
						break;
					}
				}
				if(!courseExists){
					System.out.println(c[0]+" it doesnt exist");
					Course cor=new Course();
					cor.setName(c[0]);
					courseList.add(cor);
				}
				
				
				
			}
			
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
		//load.loadCourseString("courses.txt");
		
		load.loadCourse("courses.txt");
		
		
	}

}
