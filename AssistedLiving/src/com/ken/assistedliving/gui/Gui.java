package com.ken.assistedliving.gui;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import com.ken.assistedliving.components.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Gui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea;
	JTextArea textAreaCourse;
	JTextArea textAreaCourseRestriction;
	JTextArea textAreaMissingIn;
	LoadFile load=new LoadFile();
	ArrayList<Ingredient> ingredientList =new ArrayList<Ingredient>();
	ArrayList<Course> courseList=new ArrayList<Course>();
	ArrayList<String> cRList=new ArrayList<String>();
	ArrayList<String> missingIngredientList=new ArrayList<String>();
	ArrayList<Meal> mealList =new ArrayList<Meal>();
	ArrayList<Meal> breakfastList=new ArrayList<Meal>();
	ArrayList<Meal> lunchList =new ArrayList<Meal>();
	ArrayList<Meal> dinnerList=new ArrayList<Meal>();
	
	JButton btnNewButton;
	
	DefaultListModel<String> dlmBreakfast=new DefaultListModel<String>();
	DefaultListModel<String> dlmLunch=new DefaultListModel<String>();
	DefaultListModel<String> dlmDinner=new DefaultListModel<String>();
	private JList<String> listBreakfast;
	private JList<String> listDinner;
	
	public Gui(){
		
		setResizable(false);
		setTitle("Assisted Living");
		setSize(750, 568);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JTabbedPane jTab=new JTabbedPane();
		getContentPane().add(jTab, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		//getContentPane().add(panel, BorderLayout.CENTER);
		jTab.add(panel,"tab1");
		panel.setLayout(null);
		
		JPanel panel2=new JPanel();
		panel.setLayout(null);
		jTab.add(panel2,"tab2");
		panel2.setLayout(null);
		
		 btnNewButton = new JButton("Go");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateMeals();
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(46, 420, 117, 29);
		panel2.add(btnNewButton);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(52, 47, 192, 306);
		panel2.add(scrollPane_4);
		
		listBreakfast = new JList<String>(dlmBreakfast);
		scrollPane_4.setViewportView(listBreakfast);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(52, 19, 67, 16);
		panel2.add(lblBreakfast);
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setBounds(290, 19, 61, 16);
		panel2.add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setBounds(505, 19, 61, 16);
		panel2.add(lblDinner);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(282, 47, 192, 306);
		panel2.add(scrollPane_5);
		
		JList<String> listLunch = new JList<String>(dlmLunch);
		scrollPane_5.setViewportView(listLunch);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(505, 47, 192, 306);
		panel2.add(scrollPane_6);
		
		listDinner = new JList<String>(dlmDinner);
		scrollPane_6.setViewportView(listDinner);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomMeals();
			}
		});
		btnRandom.setBounds(175, 420, 117, 29);
		panel2.add(btnRandom);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(313, 420, 117, 29);
		panel2.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 65, 211, 259);
		panel.add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblIngredientNameCost = new JLabel("Ingredient name, Cost per unit");
		lblIngredientNameCost.setBounds(27, 40, 178, 14);
		panel.add(lblIngredientNameCost);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(248, 64, 211, 259);
		panel.add(scrollPane_1);
		
		 textAreaCourse = new JTextArea();
		scrollPane_1.setViewportView(textAreaCourse);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(469, 65, 211, 259);
		panel.add(scrollPane_2);
		
		 textAreaCourseRestriction = new JTextArea();
		scrollPane_2.setViewportView(textAreaCourseRestriction);
		
		JLabel lblNewLabel = new JLabel("Course name, Ingredient, number of units");
		lblNewLabel.setBounds(248, 40, 224, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCourseMealOrder = new JLabel("Course, Meal, Order");
		lblCourseMealOrder.setBounds(489, 40, 178, 14);
		panel.add(lblCourseMealOrder);
		
		JLabel lblMissingIngredients = new JLabel("Missing Ingredients");
		lblMissingIngredients.setBounds(27, 336, 146, 14);
		panel.add(lblMissingIngredients);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(27, 361, 421, 144);
		panel.add(scrollPane_3);
		
		 textAreaMissingIn = new JTextArea();
		scrollPane_3.setViewportView(textAreaMissingIn);
		
		
		//ingredientList=load.loadIngredient("ingredients.txt");
		//courseList=load.loadCourse("courses.txt");
		missingIngredientList=load.getMissingIngredients();
		mealList=load.loadMeal("courses_restriction.txt");
		organizeMeals();// put meals in appropriate array list based on their type;
		
		
		populateTextArea();
		
		populateCourseTextA();	
		populateMissingTextA();
		populateCourseRestrictionTextA();
		
		
		
		
		setVisible(true);
		
	}
	
	
	public void populateTextArea(){
		
		
		
		
		for(Ingredient in: ingredientList){
			textArea.append(in.toString()+"\n");
		}
		
	}
	public void populateCourseTextA(){
		
		for(Course course:courseList){
			ArrayList<Ingredient> corInList=course.getIngredientlist();
			for(Ingredient ingredient:corInList){
				textAreaCourse.append(course.getName()+", "+ingredient.getName()+", "+ingredient.getUnits()+"\n");
			}
			
		}
		
		
		/*for(String s:courseList){
			textAreaCourse.append(s+"\n");
		}*/
		
	}
	public void populateCourseRestrictionTextA(){
		
		
		
		cRList=load.loadCourseRestrictionString("courses_restriction.txt");
		for(String s:cRList){
			textAreaCourseRestriction.append(s+"\n");
		}
	}
	public void populateMissingTextA(){
		for(String s:missingIngredientList){
			textAreaMissingIn.append(s+"\n");
		}
	}
	
	public void organizeMeals(){   //put meals into arraylists based on their meal type
		for(Meal meal:mealList){
			if(meal.getMealType().equals("breakfast")){
				if(breakfastList.contains(meal)){
					System.out.println("the meal "+meal.course.getName()+ " was not added in breakfast. it already exist");
				}else{
					breakfastList.add(meal);
				}
			}
			if(meal.getMealType().equals("lunch")){
				if(lunchList.contains(meal)){
					System.out.println("the meal "+meal.course.getName()+ " was not added in lunch. it already exist");
				}else{
					lunchList.add(meal);
				}
				
			}if(meal.getMealType().equals("dinner")){
				if(dinnerList.contains(meal)){
					System.out.println("the meal "+meal.course.getName()+ " was not added in dinner. it already exist");
				}else{
					dinnerList.add(meal);
				}
			}
		}
	}
	
	
	public void populateMeals(){
		if(breakfastList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more breakfast");
		}
		if(lunchList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more lunch");
		}
		if(dinnerList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more dinner");
		}
		
		for(int i=0;i<2;i++){
			
			dlmBreakfast.addElement(breakfastList.get(i).course.getName());
			breakfastList.remove(i);
			
			
		}
		for(int i=0;i<3;i++){
			dlmLunch.addElement(lunchList.get(i).course.getName());
			lunchList.remove(i);
			
			dlmDinner.addElement(dinnerList.get(i).course.getName());
			dinnerList.remove(i);
		}
		
		
		
	}
	public void randomMeals(){
		if(breakfastList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more breakfast");
		}
		if(lunchList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more lunch");
		}
		if(dinnerList.isEmpty()){
			JOptionPane.showMessageDialog(btnNewButton, "No more dinner");
		}
		
		for(int i=0;i<2;i++){
			int rand=(int)(Math.random()*breakfastList.size());
			dlmBreakfast.addElement(breakfastList.get(rand).course.getName());
			breakfastList.remove(rand);
			
			
		}
		for(int i=0;i<3;i++){
			
			int rand=(int)(Math.random()*lunchList.size());
			dlmLunch.addElement(lunchList.get(rand).course.getName());
			lunchList.remove(rand);
			
			int rand2=(int)(Math.random()*dinnerList.size());
			dlmDinner.addElement(dinnerList.get(rand2).course.getName());
			dinnerList.remove(rand2);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();

	}
}
