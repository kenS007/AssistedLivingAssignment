import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;


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
	
	public Gui(){
		
		setResizable(false);
		setTitle("Assisted Living");
		setSize(750, 533);
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
		
		JLabel lblMissingIngredients = new JLabel("Missing Ingredients");
		lblMissingIngredients.setBounds(27, 336, 146, 14);
		panel.add(lblMissingIngredients);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(27, 361, 421, 144);
		panel.add(scrollPane_3);
		
		 textAreaMissingIn = new JTextArea();
		scrollPane_3.setViewportView(textAreaMissingIn);
		
		
		ingredientList=load.loadIngredient("ingredients.txt");
		courseList=load.loadCourse("courses.txt");
		missingIngredientList=load.getMissingIngredients();
		
		
		populateTextArea();
		
		populateCourseTextA();	
		populateMissingTextA();
		//populateCourseRestrictionTextA();
		
		
		
		
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();

	}
}
