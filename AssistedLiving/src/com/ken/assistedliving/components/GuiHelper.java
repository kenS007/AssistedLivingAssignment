package com.ken.assistedliving.components;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import org.hamcrest.CoreMatchers;

public class GuiHelper {

	Random randomGenerator = new Random();  //random generator

	ArrayList<Meal> mealList = new ArrayList<Meal>();  //currently not used
	
	ArrayList<Course> courseList = new ArrayList<Course>();

	ArrayList<Day> tempDay = new ArrayList<Day>(); // used to store used courses
													// in a day to prevent
													// duplicate

	private LoadFile load = new LoadFile(); //new instance of load file class
	
	//hash table to store course restrictions the arraylist is the indec of that course in the courselist Arraylist
	private Hashtable<String, ArrayList<Integer>> courseRes = new Hashtable<String, ArrayList<Integer>>(); 
	
	//hashtable used to record the index of the combo of used courses in meal. this is used for checkin ifcourse combo
	//already exist
	private Hashtable<String, ArrayList<IndexCombo>> usedCombo = new Hashtable<String, ArrayList<IndexCombo>>();

	public GuiHelper() {
		//creating arraylists for the CourseRes hashtable
		ArrayList<Integer> b1 = new ArrayList<Integer>();
		ArrayList<Integer> b2 = new ArrayList<Integer>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		ArrayList<Integer> d1 = new ArrayList<Integer>();
		ArrayList<Integer> d2 = new ArrayList<Integer>();
		ArrayList<Integer> d3 = new ArrayList<Integer>();

		//adding it to the hashtable
		//the b1,b2,l1 etc means the course num in the meal
		courseRes.put("b1", b1);
		courseRes.put("b2", b2);
		courseRes.put("l1", l1);
		courseRes.put("l2", l2);
		courseRes.put("l3", l3);
		courseRes.put("d1", d1);
		courseRes.put("d2", d2);
		courseRes.put("d3", d3);
		comboArray();

	}

	private void comboArray() { //add arraylist to the combo hashtable
		ArrayList<IndexCombo> b = new ArrayList<IndexCombo>();
		ArrayList<IndexCombo> l = new ArrayList<IndexCombo>();
		ArrayList<IndexCombo> d = new ArrayList<IndexCombo>();

		usedCombo.put("breakfast", b);
		usedCombo.put("lunch", l);

		usedCombo.put("dinner", d);
	}

	private void loadMeals() {  //currently not used will delete this soon
		mealList = load.loadEverything();
		System.out.println(mealList.toString());
	}

	public void loadCourses() { //load courses
		load.loadEverything2();
		courseList = load.getCourseList();
		System.out.println(courseList.toString());

		mapRestrictions(); //
		System.out.println(courseRes);
		System.out.println("================================================");
		test();
	}

	private void mapRestrictions() { //map the course restiction this will add the index of this 
									//course to the hashtable with the appropriate key
		
		for (int i = 0; i < courseList.size(); i++) {
			// if(courseList.get(i).getRestrictions())
			for (Restriction restriction : courseList.get(i).getRestrictions()) { // check
																					// restrictions

				if (restriction.getMealType().equalsIgnoreCase("breakfast")) {
					if (restriction.getSlot() == 1) {
						// add in b1
						courseRes.get("b1").add(i);
					}
					if (restriction.getSlot() == 2) {
						// add b2
						courseRes.get("b2").add(i);
					}
				}
				if (restriction.getMealType().equalsIgnoreCase("lunch")) {
					if (restriction.getSlot() == 1) {
						// add l1
						courseRes.get("l1").add(i);

					}
					if (restriction.getSlot() == 2) {
						// add l2
						courseRes.get("l2").add(i);

					}
					if (restriction.getSlot() == 3) {
						// add l3
						courseRes.get("l3").add(i);
					}

				}
				if (restriction.getMealType().equalsIgnoreCase("dinner")) {
					if (restriction.getSlot() == 1) {
						// add d1
						courseRes.get("d1").add(i);

					}
					if (restriction.getSlot() == 2) {
						// add d2
						courseRes.get("d2").add(i);

					}
					if (restriction.getSlot() == 3) {
						// add d3
						courseRes.get("d3").add(i);
					}

				}

			}
		}

	}

	

	// ////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Day> createRandomMealForWeek() {
		ArrayList<Day> week = new ArrayList<Day>();

		for (int i = 0; i < 7; i++) { // loop 7 for 7 days
			//System.out.println("new Day");
			Day day = new Day(); // today

			// generate 2 breakfast and 3 lunch and dinner

			boolean breakExist = true;
			while (breakExist) { // generate breakfast without duplicate
				int key1 = randomGenerator.nextInt(courseRes.get("b1").size());// slot
																				// 1
				int key2 = randomGenerator.nextInt(courseRes.get("b2").size());// slot
																				// 2
				IndexCombo c = new IndexCombo();
				c.setBreakfastIndex(key1, key2);
				if (!usedCombo.get("breakfast").contains(c)) {
					usedCombo.get("breakfast").add(c);
					day.addBreakfast(courseList.get(courseRes.get("b1").get(key1)));
					day.addBreakfast(courseList.get(courseRes.get("b2").get(key2)));
					breakExist = false;
				}
				else{
					//System.out.println("breakfast duplicate");
				}

			}
			boolean lunchExist = true;
			while (lunchExist) { // generate breakfast without duplicate
				int key1 = randomGenerator.nextInt(courseRes.get("l1").size());// slot
																				// 1
				int key2 = randomGenerator.nextInt(courseRes.get("l2").size());// slot
																				// 2
				int key3 = randomGenerator.nextInt(courseRes.get("l3").size());
				IndexCombo c = new IndexCombo();
				c.setLunchIndex(key1, key2,key3);
				if (!usedCombo.get("lunch").contains(c)) {
					usedCombo.get("lunch").add(c);
					day.addLunch(courseList.get(courseRes.get("l1").get(key1)));
					day.addLunch(courseList.get(courseRes.get("l2").get(key2)));
					day.addLunch(courseList.get(courseRes.get("l3").get(key3)));
					
					lunchExist = false;
				}else{
					//System.out.println("lunch duplicate");
				}

			}
			
			boolean dinnerExist=true;
			while (dinnerExist){  //generate breakfast without duplicate
				int key1=randomGenerator.nextInt(courseRes.get("d1").size());//slot 1
				int key2=randomGenerator.nextInt(courseRes.get("d2").size());//slot 2
				int key3=randomGenerator.nextInt(courseRes.get("d3").size());
				IndexCombo c =new IndexCombo();
				c.setDinnerIndex(key1, key2,key3);
				if(!usedCombo.get("dinner").contains(c)){
					usedCombo.get("dinner").add(c);
					day.addDinner(courseList.get(courseRes.get("d1").get(key1)));
					day.addDinner(courseList.get(courseRes.get("d2").get(key2)));
					day.addDinner(courseList.get(courseRes.get("d3").get(key3)));
					dinnerExist=false;
				}
				else{
					//System.out.println("dinner duplicate");
				}
			
				week.add(day);
			
				
			}
		}
		clearUsedCombo();
		return week;

	}
	private void clearUsedCombo(){
		usedCombo.get("breakfast").clear();
		usedCombo.get("lunch").clear();
		usedCombo.get("dinner").clear();
	}

	// /////////////////////////////////////////////////////////////////

	public void mutationHelper(ArrayList<Day> week,String res,Course otherCourse,String type){
	
		//we need to check if there is a duplicate
		
		
		//first map the courses comos in the chromosome
		
	
		
		
		
		
		for(int i=0;i<7;i++){
			
			IndexCombo icB = new IndexCombo();
			icB.setBreakfastIndex(getKey(week.get(i).getBreakfastItem(0)), getKey(week.get(i).getBreakfastItem(2)));
		//	if (!usedCombo.get("breakfast").contains(icB)) {
				usedCombo.get("breakfast").add(icB);
			
			//}
			
			IndexCombo icL=new IndexCombo();
			icL.setLunchIndex(getKey(week.get(i).getLunchItem(0)), 
							getKey(week.get(i).getLunchItem(1)), 
							getKey(week.get(i).getLunchItem(2)));
			
			//if(!usedCombo.get("lunch").contains(icL)){
				usedCombo.get("lunch").add(icL);
				
			//}
			
			
			IndexCombo icD=new IndexCombo();
			icL.setDinnerIndex(getKey(week.get(i).getDinnerItem(0)), 
					getKey(week.get(i).getDinnerItem(1)), 
					getKey(week.get(i).getDinnerItem(2)));

			//if(!usedCombo.get("dinner").contains(icD)){
				usedCombo.get("dinner").add(icD);
				

			
		}
		//finished mapping 
		//now we get a random course
		Course tempC =new Course();
		
		int newkey=randomGenerator.nextInt(courseRes.get("res").size());
			
		
		
		
		if(type=="breakfast"){
			if(res=="b1"){
				int slot1=courseRes.get("res").size(); //this will be random
				int slot2=getKey(otherCourse);
				
			}
			if(res=="b2"){
				int slot1=getKey(otherCourse);
				int slot2=courseRes.get("res").size(); //this will be random
;
				
			}
		}
		if(type=="lunch"){
			if(res=="l1"){
			
				
			}
			if(res=="l2"){
				
			}
			if(res=="l3"){
				
			}
			
			
		}
		if(type=="dinner"){
			if(res=="d1"){
				
			}
			if(res=="d1"){
				
			}
			if(res=="d1"){
				
			}
		}
		
		
		
		
		
	}
	
	private int getKey(Course cor){
		//courseList.indexOf(cor);
		
		return courseList.indexOf(cor);
	}
	
	
	private void test(){
		System.out.println(courseList.get(2));
		Course ct=courseList.get(2);
		System.out.println(getKey(ct));
	}
	
	

	public static void main(String[] args) { //for testing
		// TODO Auto-generated method stub
		GuiHelper h = new GuiHelper();
		h.loadCourses();
		
		
		

	}

}
