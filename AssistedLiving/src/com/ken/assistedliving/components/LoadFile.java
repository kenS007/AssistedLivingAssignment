package com.ken.assistedliving.components;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class LoadFile {
	public  ArrayList<Course> courseList = new ArrayList<Course>();
	public ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	public ArrayList<String> missingIngredientList =new ArrayList<String>();
	public ArrayList<Meal> mealList=new ArrayList<Meal>();


	/**
	 * scans textfile and returns and ArrayList of Ingredients
	 * 
	 * @param path
	 *            - path of the textfile
	 * @return ArrayList of Ingredients
	 * 
	 */
	public ArrayList<Ingredient> loadIngredient(String path) {
		// ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
		File file = new File(path);
		try {
			Scanner in = new Scanner(file);

			while (in.hasNext()) {

				String line = in.nextLine(); // read line then split name and
												// cost
				String[] inNameCost = line.split(",");
				inNameCost[0]=inNameCost[0].toLowerCase().trim();

				if (inNameCost.length == 2) {
					Ingredient ingredient = new Ingredient(inNameCost[0],
							Double.parseDouble(inNameCost[1]));
					 System.out.println(inNameCost[0]+" "+inNameCost[1]);
					ingredientList.add(ingredient);
				}
			}
			System.out.println(ingredientList.toString());
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ingredientList;

	}

	public void addInToCourse() {

	}

	public int getIngredientIndex(String ingName) {
	
		for (int i = 0; i < ingredientList.size(); i++) {
			//System.out.println("trololololo "+ingredientList.get(i).getName());
			//if (ingredientList.get(i).getName().equals(ingName)) {
			if (ingredientList.get(i).getName().equals(ingName)) {
				System.out.println("gII"+ingredientList.get(i).getName());
				return i;
			}
		}

		return -1; // return -1 if the ingredient doesnt exist
	}

	public ArrayList<Course> loadCourse(String path) {
		// ArrayList<Course> courseList=new ArrayList<Course>();
		File file = new File(path);

		try {
			Scanner in = new Scanner(file);

			while (in.hasNext()) {
				String line = in.nextLine();  //get line from the txt file
				String[] c = line.split(",");  //put the contents into an array
				
				Boolean courseExists = false; 
				
				if (c.length == 3) { 

					c[0] = c[0].toLowerCase().trim(); //set course to lowercase and trim whitespace
					c[1]=c[1].toLowerCase().trim();  //set ingredient to lowercase and trim whitespace
					double unit = Double.parseDouble(c[2]); // get the unit and convert it
					

					if (!courseList.isEmpty()) { //check if the arraylist is empty
						
						for (Course course : courseList) { //loop each course ing the course arraylist
							
							if (course.getName().equals(c[0])) {     //if the course name in the array list is equals to the course in the file
								System.out.println("yes !!!"+c[0]+" exists");
								
								courseExists=true;  //set course exist to true
								
								int indx = getIngredientIndex(c[1]); //get the index in the arraylist
								if (indx != -1) { //if the ingreient exist ing the course
									
									int ingIndx = course
											.getCourseIngredientIndex(c[1]);  //get index of the ingredient in the course
									if (ingIndx != -1) {// it already exist it
														// course ingredients

									} else {// doesnt exist yet
										course.addIngredient(
												ingredientList.get(indx), unit);
									}
								

								} else {  //ingredient doesnt exist
									System.out.println("Error: ingredient "
											+ c[1] + " doesnt exist");
									missingIngredientList.add(line.toLowerCase()); //add to missing ingredient
								}

								break;  //break loop 
							}
						}
					}
					if (!courseExists) {
						System.out.println(c[0] + " it doesnt exist");
						Course cor = new Course();
						cor.setName(c[0]);
						
						Boolean inExists=false;
						
						for(Ingredient ing:ingredientList){
							if(ing.name.equals(c[1])){
								System.out.println("ingredient exists: "+ing.getName());
								inExists=true;
								
								
								
								cor.addIngredient(ing,unit);
							
								break;
							}
						}
						if(!inExists){
							System.out.println("doesnt exist"+c[1]);
							missingIngredientList.add(line.toLowerCase());
						}
						courseList.add(cor);
						/* // add ingredient
						int indx = getIngredientIndex(c[1]);
						
						if (indx != -1) {// if ingredient is in the list
							System.out.println("this lol "+ingredientList.get(indx));
  							cor.addIngredient(ingredientList.get(indx));
  							//cor.addIngredient(ingredientList.get(1));
					
							System.out.println(c[1]+"added");

						} else {
							System.out.println("!error:ingredient: " + c[1]
									+ " doesnt exist");
						}
						courseList.add(cor);
						
						*/

					}
					//System.out.println(courseList.toString());

				}
			}
			in.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(courseList);
		System.out.println("missing ingredients:");
		for(int i=0;i<missingIngredientList.size();i++){
			System.out.println(missingIngredientList.get(i));
		}

		return courseList;
	}
	
	

	public ArrayList<Meal> loadMeal(String path) {
		ArrayList<Meal> mealList = new ArrayList<Meal>();
		File file = new File(path);

		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] m = line.split(",");
				Boolean courseExists=false;
				
				if(m.length==3){
					m[0]=m[0].toLowerCase().trim();
					m[1]=m[1].toLowerCase().trim();
					int order=Integer.parseInt(m[2].trim());
					
					//check if course exists
					for(Course course:courseList){
						if(course.getName().equals(m[0])){
							System.out.println("!");
							courseExists=true;
							//if(doesMealExists(m[1],course)){
							//	System.out.println(m[1]+" is "+m[0]);
							//}
							Meal meal=new Meal();
							meal.setMealType(m[1]);
							meal.addCourse(course);
							meal.setOrder(order);
							
							mealList.add(meal);
	
							break;
						}
					}
					if(!courseExists){
						System.out.println("the course: "+m[0]+" doesnt exist");
					}
					
					
				}
				
				

			}

			
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mealList;
	}

	public ArrayList<String> loadCourseString(String path) {
		ArrayList<String> courseListS = new ArrayList<String>();
		File file = new File(path);

		try {
			Scanner in = new Scanner(file);

			while (in.hasNext()) {
				String line = in.nextLine();

				courseListS.add(line);

			}

			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return courseListS;
	}

	public ArrayList<String> loadCourseRestrictionString(String path) {
		ArrayList<String> cRList = new ArrayList<String>();
		File file = new File(path);
		try {
			Scanner in = new Scanner(file);

			while (in.hasNext()) {
				String line = in.nextLine();

				cRList.add(line);
			}

			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cRList;
	}
	public ArrayList<String> getMissingIngredients(){
		return missingIngredientList;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoadFile load = new LoadFile();
		// load.loadtxt("ingredients.txt");
		// load.loadCourseString("courses.txt");
		load.loadIngredient("ingredients.txt");
		load.loadCourse("courses.txt");
		load.loadMeal("courses_restriction.txt");
		
		

	}

}
