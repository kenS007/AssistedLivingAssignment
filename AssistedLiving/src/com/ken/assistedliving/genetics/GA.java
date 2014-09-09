package com.ken.assistedliving.genetics;

import java.util.ArrayList;

import com.ken.assistedliving.components.GuiHelper;

public class GA {
	
	ArrayList<Chromosome> theChromosomes=new ArrayList<Chromosome>();
	private GuiHelper helper=new GuiHelper();

	
	public GA(){
		helper.loadCourses();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public void generateInitialPopulation(int populationSize){
		
		for(int i=0;i<populationSize;i++){
			theChromosomes.add(i, getARandomChromosome());
		}
	}
	
	
	
	private Chromosome getARandomChromosome(){
		Chromosome chromosome =new Chromosome();
		chromosome.addWeek(helper.createRandomMealForWeek());
		
		return chromosome;
	}

}
