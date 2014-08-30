package com.ken.assistedliving.components.hashtables;

import java.util.Hashtable;

import com.ken.assistedliving.components.Course;

public class CourseTable {
	
	Hashtable<Integer,Course> courseHT=new Hashtable<Integer,Course>();
	int keyCount=0;
	
	public void addToHT(Course course){
		keyCount++;
		courseHT.put(keyCount, course);
	}
	public Course getCourse(int key){
		return courseHT.get(key);
	}
	
	public int getID(Course course){
		int id=0;
	
		//add stuff
		
		
		return id;
	}
	 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
