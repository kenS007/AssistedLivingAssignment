import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class LoadFile {
	
	
	
	
	
	public ArrayList<Ingredient> loadtxt(String path){
		ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
		File file=new File(path);
		try{
			Scanner in=new Scanner(file);
			
			while(in.hasNext()){
				//read line then split name and cost
				String line=in.nextLine();
				String[] inNameCost=line.split(",");
				
				if (inNameCost.length==2){
				Ingredient ingredient=new Ingredient(inNameCost[0],Double.parseDouble(inNameCost[1]));
				//System.out.println(inNameCost[0]+" "+inNameCost[1]);
					ingredientList.add(ingredient);
				}
			}
			System.out.println(ingredientList.toString());
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return ingredientList;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoadFile load =new LoadFile();
		load.loadtxt("ingredients.txt");

	}

}
