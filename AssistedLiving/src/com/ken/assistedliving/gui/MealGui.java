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

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.util.ArrayList;

public class MealGui extends JFrame {
	
	
	ArrayList<DefaultListModel<String>> dlmList=new ArrayList<DefaultListModel<String>>();
	
	
	JPanel panel_1;
	
	public MealGui(){
		
		setResizable(false);
		setTitle("Assisted Living");
		setSize(760,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(6, 71, 61, 16);
		panel.add(lblBreakfast);
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setBounds(6, 167, 61, 16);
		panel.add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setBounds(6, 254, 61, 16);
		panel.add(lblDinner);
		
		JLabel lblMonday = new JLabel("Mon");
		lblMonday.setBounds(112, 32, 61, 16);
		panel.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tue");
		lblTuesday.setBounds(214, 32, 61, 16);
		panel.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wed");
		lblWednesday.setBounds(296, 32, 37, 16);
		panel.add(lblWednesday);
		
		JLabel lblThurs = new JLabel("Thurs");
		lblThurs.setBounds(378, 32, 61, 16);
		panel.add(lblThurs);
		
		JLabel lblFri = new JLabel("Fri");
		lblFri.setBounds(474, 32, 61, 16);
		panel.add(lblFri);
		
		JLabel lblSat = new JLabel("Sat");
		lblSat.setBounds(571, 32, 37, 16);
		panel.add(lblSat);
		
		JLabel lblSun = new JLabel("Sun");
		lblSun.setBounds(649, 32, 61, 16);
		panel.add(lblSun);
		
		JButton btnRandomMeals = new JButton("Random Meals");
		btnRandomMeals.setBounds(70, 460, 117, 29);
		panel.add(btnRandomMeals);
		
		 panel_1 = new JPanel();
		panel_1.setBounds(89, 71, 649, 320);
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
		
		/*JScrollPane scrollPane_8 = new JScrollPane();
		panel_1.add(scrollPane_8, "2, 2, fill, fill");
		
		
		
		JList list = new JList();
		scrollPane_8.setViewportView(list);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_1.add(scrollPane_7, "4, 2, fill, fill");
		
		JList list_3 = new JList();
		scrollPane_7.setViewportView(list_3);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel_1.add(scrollPane_6, "6, 2, fill, fill");
		
		JList list_4 = new JList();
		scrollPane_6.setViewportView(list_4);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_1.add(scrollPane_5, "8, 2, fill, fill");
		
		JList list_5 = new JList();
		scrollPane_5.setViewportView(list_5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_1.add(scrollPane_4, "10, 2, fill, fill");
		
		JList list_6 = new JList();
		scrollPane_4.setViewportView(list_6);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, "12, 2, fill, fill");
		
		JList list_7 = new JList();
		scrollPane_3.setViewportView(list_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, "14, 2, fill, fill");
		
		JList list_8 = new JList();
		scrollPane_2.setViewportView(list_8);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		panel_1.add(scrollPane_9, "2, 4, fill, fill");
		
		JList list_1 = new JList();
		scrollPane_9.setViewportView(list_1);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		panel_1.add(scrollPane_11, "4, 4, fill, fill");
		
		JList list_9 = new JList();
		scrollPane_11.setViewportView(list_9);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		panel_1.add(scrollPane_13, "6, 4, fill, fill");
		
		JList list_11 = new JList();
		scrollPane_13.setViewportView(list_11);
		
		JScrollPane scrollPane_15 = new JScrollPane();
		panel_1.add(scrollPane_15, "8, 4, fill, fill");
		
		JList list_13 = new JList();
		scrollPane_15.setViewportView(list_13);
		
		JScrollPane scrollPane_18 = new JScrollPane();
		panel_1.add(scrollPane_18, "10, 4, fill, fill");
		
		JList list_15 = new JList();
		scrollPane_18.setViewportView(list_15);
		
		JScrollPane scrollPane_19 = new JScrollPane();
		panel_1.add(scrollPane_19, "12, 4, fill, fill");
		
		JList list_17 = new JList();
		scrollPane_19.setViewportView(list_17);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "14, 4, fill, fill");
		
		JList list_19 = new JList();
		scrollPane_1.setViewportView(list_19);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		panel_1.add(scrollPane_10, "2, 6, fill, fill");
		
		JList list_2 = new JList();
		scrollPane_10.setViewportView(list_2);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		panel_1.add(scrollPane_12, "4, 6, fill, fill");
		
		JList list_10 = new JList();
		scrollPane_12.setViewportView(list_10);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		panel_1.add(scrollPane_14, "6, 6, fill, fill");
		
		JList list_12 = new JList();
		scrollPane_14.setViewportView(list_12);
		
		JScrollPane scrollPane_16 = new JScrollPane();
		panel_1.add(scrollPane_16, "8, 6, fill, fill");
		
		JList list_14 = new JList();
		scrollPane_16.setViewportView(list_14);
		
		JScrollPane scrollPane_17 = new JScrollPane();
		panel_1.add(scrollPane_17, "10, 6, fill, fill");
		
		JList list_16 = new JList();
		scrollPane_17.setViewportView(list_16);
		
		JScrollPane scrollPane_20 = new JScrollPane();
		panel_1.add(scrollPane_20, "12, 6, fill, fill");
		
		JList list_18 = new JList();
		scrollPane_20.setViewportView(list_18);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "14, 6, fill, fill");
		
		JList list_20 = new JList();
		scrollPane.setViewportView(list_20);
		
		*/
		
		
		createJList();
		for(int i=0;i<dlmList.size();i++){
			dlmList.get(i).addElement("fuck");
			dlmList.get(i).addElement("cunt");
		}
		setVisible(true);
	}
	
	public void createJList(){  //Dynamically create jlists and add DefaulListModel to ArrayList;
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
	
	public void loadTheMealsFromFile(){
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MealGui();
	}
}
