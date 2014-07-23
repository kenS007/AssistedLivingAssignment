import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Gui extends JFrame {
	
	JTextArea textArea;
	
	public Gui(){
		
		setResizable(false);
		setTitle("Ingredients List");
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 64, 272, 179);
		panel.add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		populateTextArea();
		
		System.out.println("test");
		
		
		
		
		
		setVisible(true);
		
	}
	
	
	public void populateTextArea(){
		LoadFile load=new LoadFile();
		ArrayList<Ingredient> ingredientList =new ArrayList<Ingredient>();
		
		ingredientList=load.loadtxt("ingredients.txt");
		for(Ingredient in: ingredientList){
			textArea.append(in.toString()+"\n");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui();

	}
}
