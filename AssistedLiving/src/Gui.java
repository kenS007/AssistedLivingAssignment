import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class Gui extends JFrame {
	
	JTextArea textArea;
	JTextArea textAreaCourse;
	JTextArea textAreaCourseRestriction;
	
	public Gui(){
		
		setResizable(false);
		setTitle("Assisted Living");
		setSize(750, 460);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		lblCourseMealOrder.setBounds(489, 40, 114, 14);
		panel.add(lblCourseMealOrder);
		
		populateTextArea();
		
		populateCourseTextA();	
		populateCourseRestrictionTextA();
		
		
		
		
		setVisible(true);
		
	}
	
	
	public void populateTextArea(){
		LoadFile load=new LoadFile();
		ArrayList<Ingredient> ingredientList =new ArrayList<Ingredient>();
		
		ingredientList=load.loadIngredient("ingredients.txt");
		for(Ingredient in: ingredientList){
			textArea.append(in.toString()+"\n");
		}
		
	}
	public void populateCourseTextA(){
		LoadFile load=new LoadFile();
		ArrayList<String> courseList=new ArrayList<String>();
		
		courseList=load.loadCourseString("courses.txt");
		for(String s:courseList){
			textAreaCourse.append(s+"\n");
		}
		
	}
	public void populateCourseRestrictionTextA(){
		LoadFile load=new LoadFile();
		ArrayList<String> cRList=new ArrayList<String>();
		
		cRList=load.loadCourseRestrictionString("courses_restriction.txt");
		for(String s:cRList){
			textAreaCourseRestriction.append(s+"\n");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();

	}
}
