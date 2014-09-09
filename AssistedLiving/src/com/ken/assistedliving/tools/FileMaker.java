package com.ken.assistedliving.tools;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import com.ken.assistedliving.components.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileMaker extends JFrame {
	private JTextField textFieldIngredient;
	private JTextField textFieldInCost;
	private JTextField textField_1;

	private DefaultListModel<String> dlmIngredient = new DefaultListModel<String>();

	ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private LoadFile load = new LoadFile();
	private JTextArea textAreaLogIn;

	public FileMaker() {

		setResizable(false);
		setTitle("Assisted Living");
		setSize(628, 555);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Ingredients", null, panel, null);
		panel.setLayout(null);
		panel.setLayout(null);

		JButton btnMakefile = new JButton("Make new File");
		btnMakefile.setBounds(135, 304, 117, 29);
		panel.add(btnMakefile);

		JButton btnAppendFile = new JButton("append File");
		btnAppendFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAppendFile.setBounds(6, 304, 117, 29);
		panel.add(btnAppendFile);

		JButton btnLoadFile = new JButton("Load ingredient File");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInFile();
			}
		});
		btnLoadFile.setBounds(6, 6, 142, 39);
		panel.add(btnLoadFile);

		JLabel lblIngredients = new JLabel("Ingredients  ಠ_ಠ");
		lblIngredients.setBounds(158, 6, 222, 16);
		panel.add(lblIngredients);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 25, 181, 292);
		panel.add(scrollPane);

		JList<String> listIngredient = new JList<String>(dlmIngredient);
		scrollPane.setViewportView(listIngredient);

		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setBounds(35, 71, 74, 16);
		panel.add(lblIngredient);

		JLabel lblCost = new JLabel("cost $");
		lblCost.setBounds(185, 71, 61, 16);
		panel.add(lblCost);

		JLabel lblIngredientsPresent = new JLabel("Ingredients present");
		lblIngredientsPresent.setBounds(377, 6, 166, 16);
		panel.add(lblIngredientsPresent);

		textFieldIngredient = new JTextField();
		textFieldIngredient.setBounds(14, 88, 134, 28);
		panel.add(textFieldIngredient);
		textFieldIngredient.setColumns(10);

		textFieldInCost = new JTextField();
		textFieldInCost.setBounds(170, 88, 74, 28);
		panel.add(textFieldInCost);
		textFieldInCost.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addIngredient();
			}
		});
		btnAdd.setBounds(248, 89, 74, 29);
		panel.add(btnAdd);

		JLabel lblMultiPasta = new JLabel(
				"Multi Pasta- Format: Ingredient, Cost");
		lblMultiPasta.setBounds(6, 128, 329, 16);
		panel.add(lblMultiPasta);

		JButton btnAddMulti = new JButton("add Multi");
		btnAddMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddMulti.setBounds(6, 257, 117, 29);
		panel.add(btnAddMulti);

		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(16, 345, 61, 16);
		panel.add(lblLog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 148, 329, 97);
		panel.add(scrollPane_2);

		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(14, 373, 366, 97);
		panel.add(scrollPane_3);

		textAreaLogIn = new JTextArea();
		scrollPane_3.setViewportView(textAreaLogIn);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Course", null, panel2, null);
		panel2.setLayout(null);

		JButton btnLoadCourseFile = new JButton("Load course File");
		btnLoadCourseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoadCourseFile.setBounds(6, 6, 135, 29);
		panel2.add(btnLoadCourseFile);

		JLabel lblCourse = new JLabel("Course ¯\\_(ツ)_/¯ You will need ingredients for this to work");
		lblCourse.setBounds(153, 11, 392, 16);
		panel2.add(lblCourse);

		JButton btnNewCourseFile = new JButton("new Course File");
		btnNewCourseFile.setBounds(167, 452, 135, 29);
		panel2.add(btnNewCourseFile);

		JButton btnAppendCourseFile = new JButton("Append Course File");
		btnAppendCourseFile.setBounds(6, 452, 151, 29);
		panel2.add(btnAppendCourseFile);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(426, 42, 170, 272);
		panel2.add(scrollPane_1);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(80, 90, 123, 29);
		panel2.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(80, 128, 111, 27);
		panel2.add(comboBox_1);

		textField_1 = new JTextField();
		textField_1.setBounds(220, 131, 64, 28);
		panel2.add(textField_1);
		textField_1.setColumns(10);

		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(56, 167, 117, 29);
		panel2.add(btnAddCourse);

		JLabel lblCName = new JLabel("C name");
		lblCName.setBounds(16, 96, 61, 16);
		panel2.add(lblCName);

		JLabel lblIngredient_1 = new JLabel("Ingredient");
		lblIngredient_1.setBounds(6, 131, 93, 16);
		panel2.add(lblIngredient_1);

		JLabel lblNumOfUnits = new JLabel("num of units");
		lblNumOfUnits.setBounds(220, 119, 81, 16);
		panel2.add(lblNumOfUnits);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(6, 316, 392, 113);
		panel2.add(textArea_1);

		JLabel lblMultiPasta_1 = new JLabel(
				"Multi Pasta- yo make sure format is correct");
		lblMultiPasta_1.setBounds(6, 293, 330, 16);
		panel2.add(lblMultiPasta_1);

		JButton btnAddCMulti = new JButton("Add C multi");
		btnAddCMulti.setBounds(24, 427, 117, 29);
		panel2.add(btnAddCMulti);

		JPanel panel3 = new JPanel();
		tabbedPane.addTab("course Restriction", null, panel3, null);
		panel3.setLayout(null);

		JButton btnLoadRestriction = new JButton("Load Restriction");
		btnLoadRestriction.setBounds(6, 6, 151, 29);
		panel3.add(btnLoadRestriction);

		JLabel lblCourseRestriction = new JLabel(
				"Course Restriction (╯'□')╯︵ ┻━┻");
		lblCourseRestriction.setBounds(169, 11, 267, 16);
		panel3.add(lblCourseRestriction);

		JLabel lblCourse_1 = new JLabel("Course");
		lblCourse_1.setBounds(20, 60, 61, 16);
		panel3.add(lblCourse_1);

		JLabel lblMeal = new JLabel("Meal");
		lblMeal.setBounds(117, 60, 61, 16);
		panel3.add(lblMeal);

		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(201, 60, 61, 16);
		panel3.add(lblOrder);

		setVisible(true);
	}

	private void loadInFile() {
		//ingredientList = load.loadIngredient("ingredients.txt");

		for (Ingredient ingredient : ingredientList) {
			dlmIngredient.addElement(ingredient.getName());
		}

	}

	private void addIngredient() {
		String inName = textFieldIngredient.getText().trim();
		double inCost = Double.parseDouble(textFieldInCost.getText().trim());

		// check if ingredient name already exist
		
		
		boolean doesInExist=false;
		if (ingredientList.isEmpty()) {
			// its empty
			Ingredient tempIn = new Ingredient();
			tempIn.setName(inName);
			tempIn.setCost(inCost);
			ingredientList.add(tempIn);
			dlmIngredient.addElement(inName);
			textAreaLogIn.append(inName + ", " + inCost + " Added!\n");
			
		} else {
			for (Ingredient ingredient : ingredientList) {
				if (ingredient.getName().equals(inName)) {

					// it already exist
					textAreaLogIn.append(inName + " already exists!\n");
					doesInExist=true;
					break;
				} 
			}
			if(!doesInExist){
				Ingredient tempIn = new Ingredient();
				tempIn.setName(inName);
				tempIn.setCost(inCost);
				ingredientList.add(tempIn);
				dlmIngredient.addElement(inName);
				textAreaLogIn.append(inName + ", " + inCost + " Added!\n");
			}
		}
	}
	
	
	public static void addMulti(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileMaker();

	}
}
