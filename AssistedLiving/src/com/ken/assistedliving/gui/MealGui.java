package com.ken.assistedliving.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.ken.assistedliving.components.Course;
import com.ken.assistedliving.components.Day;
import com.ken.assistedliving.components.GuiHelper;
import com.ken.assistedliving.genetics.GA;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MealGui extends JFrame {
	
	
	ArrayList<DefaultListModel<String>> dlmList=new ArrayList<DefaultListModel<String>>();
	
	GuiHelper helper=new GuiHelper();
	
	ArrayList<Day> week=new ArrayList<Day>();
	
	GA genetic=new GA();
	
	
	
	JPanel panel_1;
	private JTextField textField_population;
	private JTextField textFieldmutate;
	private JTextField textFieldCrossover;
	private JTextField textFieldMaxGen;
	private JTextField textFieldMaxCost;
	JProgressBar progressBar;
	
	public MealGui(){
		
		setResizable(false);
		setTitle("Assisted Living");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(6, 71, 61, 16);
		panel.add(lblBreakfast);
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setBounds(6, 188, 61, 16);
		panel.add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setBounds(6, 290, 61, 16);
		panel.add(lblDinner);
		
		JLabel lblMonday = new JLabel("Mon");
		lblMonday.setBounds(126, 32, 61, 16);
		panel.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tue");
		lblTuesday.setBounds(231, 32, 61, 16);
		panel.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wed");
		lblWednesday.setBounds(338, 32, 37, 16);
		panel.add(lblWednesday);
		
		JLabel lblThurs = new JLabel("Thurs");
		lblThurs.setBounds(445, 32, 61, 16);
		panel.add(lblThurs);
		
		JLabel lblFri = new JLabel("Fri");
		lblFri.setBounds(570, 32, 61, 16);
		panel.add(lblFri);
		
		JLabel lblSat = new JLabel("Sat");
		lblSat.setBounds(680, 32, 37, 16);
		panel.add(lblSat);
		
		JLabel lblSun = new JLabel("Sun");
		lblSun.setBounds(767, 32, 61, 16);
		panel.add(lblSun);
		
		JButton btnRandomMeals = new JButton("Random Meals");
		btnRandomMeals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getWeekFromFile();
			}
		});
		btnRandomMeals.setBounds(70, 430, 117, 29);
		panel.add(btnRandomMeals);
		
		 panel_1 = new JPanel();
		panel_1.setBounds(72, 71, 808, 320);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		 progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setBounds(29, 552, 363, 20);
		panel.add(progressBar);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(41, 529, 61, 16);
		panel.add(lblStatus);
		
		JButton btnStartGa = new JButton("Start G.A.");
		btnStartGa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				startGA();
			}
		});
		btnStartGa.setBounds(70, 470, 117, 29);
		panel.add(btnStartGa);
		
		
		
		createJList();

		
		
		progressBar.setIndeterminate(true);
		
		JLabel lblGaParameters = new JLabel("GA parameters");
		lblGaParameters.setBounds(231, 412, 130, 16);
		panel.add(lblGaParameters);
		
		textField_population = new JTextField();
		textField_population.setText("100");
		textField_population.setBounds(325, 429, 134, 28);
		panel.add(textField_population);
		textField_population.setColumns(10);
		
		JLabel lblPopulation = new JLabel("population:");
		lblPopulation.setBounds(241, 435, 88, 16);
		panel.add(lblPopulation);
		
		JLabel lblCriteria = new JLabel("max: $");
		lblCriteria.setBounds(241, 513, 75, 16);
		panel.add(lblCriteria);
		
		JLabel lblMutationRate = new JLabel("Mutation probability:");
		lblMutationRate.setBounds(505, 435, 160, 20);
		panel.add(lblMutationRate);
		
		JLabel lblCrossoverProbability = new JLabel("Crossover probability:");
		lblCrossoverProbability.setBounds(494, 475, 160, 16);
		panel.add(lblCrossoverProbability);
		
		textFieldmutate = new JTextField();
		textFieldmutate.setText("0.005");
		textFieldmutate.setBounds(656, 429, 134, 28);
		panel.add(textFieldmutate);
		textFieldmutate.setColumns(10);
		
		textFieldCrossover = new JTextField();
		textFieldCrossover.setText("0.7");
		textFieldCrossover.setBounds(656, 475, 134, 28);
		panel.add(textFieldCrossover);
		textFieldCrossover.setColumns(10);
		
		JButton btnDefault = new JButton("Default");
		btnDefault.setBounds(483, 524, 117, 29);
		panel.add(btnDefault);
		
		JLabel lblMaxGenerations = new JLabel("Max Generations:");
		lblMaxGenerations.setBounds(199, 475, 117, 16);
		panel.add(lblMaxGenerations);
		
		textFieldMaxGen = new JTextField();
		textFieldMaxGen.setText("1000");
		textFieldMaxGen.setBounds(325, 471, 134, 28);
		panel.add(textFieldMaxGen);
		textFieldMaxGen.setColumns(10);
		
		textFieldMaxCost = new JTextField();
		textFieldMaxCost.setText("100");
		textFieldMaxCost.setBounds(325, 512, 134, 28);
		panel.add(textFieldMaxCost);
		textFieldMaxCost.setColumns(10);
		
		
		
		
		
		setVisible(true);
		progressBar.setVisible(true);
		
		
		helper.loadCourses();  //load the courses from the text file
		
		
		progressBar.setVisible(false);
		
		System.out.println("loaded yea!");
		
	}
	
	
	
	
	private void createJList(){  //Dynamically create jlists and add DefaulListModel to ArrayList;
		for(int i=1;i<=7;i++){
			for(int j=1;j<=3;j++){
				DefaultListModel<String> dlmd=new DefaultListModel<String>();
				dlmList.add(dlmd);
				JScrollPane sp=new JScrollPane();
				int x = i*2;
				int y = j*2;
				String constraints=x+", "+y+", fill, fill";
				panel_1.add(sp,constraints);
				
				JList<String> listd =new JList<String>(dlmd);
				sp.setViewportView(listd);
				
			}
		}
	}
	
	private void getWeekFromFile(){
		
		week.clear();
		for(int i=0;i<dlmList.size();i++){
			dlmList.get(i).clear();
		}
		week=helper.createRandomMealForWeek();
		sevenDays();
	}
	
	private void sevenDays(){
		
		
		
		int count=0;
		int dayCount=0;
		for(int i=0;i<dlmList.size();i++){
			count++;
			if(count==1){//breakfast
				//dlmList.get(i).addElement("breakfast");
				//dlmList.get(i).addElement(week.get(dayCount).getBreakfastList().);
				ArrayList<Course> temp =new ArrayList<Course>();
				temp =week.get(dayCount).getBreakfastList();
				
				for(int j=0;j<temp.size();j++){
					dlmList.get(i).addElement(temp.get(j).getName());
				}
				
			}
			if(count==2){//lunch
			//	dlmList.get(i).addElement("lunch");
				
				ArrayList<Course> temp =week.get(dayCount).getLunchList();
				
				for(int j=0;j<temp.size();j++){
					dlmList.get(i).addElement(temp.get(j).getName());
				}
				
			}
			if(count==3){//dinner
			//	dlmList.get(i).addElement("dinner");
				
				ArrayList<Course> temp =week.get(dayCount).getDinnerList();
				
				for(int j=0;j<temp.size();j++){
					dlmList.get(i).addElement(temp.get(j).getName());
				}
				
				
				count=0;
				dayCount++;
			}
			
				
		}
		
	}
	
	
	
	private void startGA(){
		
		progressBar.setVisible(true);
		
		//genetic.startGA(populationSize, crossoverProb, mutationProb, maxGen,maxCost); //start GA pass the parameters(pop size and criterion)
		//progressBar.setVisible(false);
		
		Thread t = new Thread() {
		    public void run() {
		    	int populationSize=Integer.parseInt(textField_population.getText().trim());
				double crossoverProb=Double.parseDouble(textFieldCrossover.getText().trim());
				double mutationProb=Double.parseDouble(textFieldmutate.getText().trim());
				double maxCost=Double.parseDouble(textFieldMaxCost.getText().trim());
				int maxGen=Integer.parseInt(textFieldMaxGen.getText().trim());
				
		    	
		    	
		    	genetic.startGA(populationSize, crossoverProb, mutationProb, maxGen,maxCost); //start GA pass the parameters(pop size and criterion)
				progressBar.setVisible(false);
		    }
		};
		t.start();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MealGui();
	}
}
