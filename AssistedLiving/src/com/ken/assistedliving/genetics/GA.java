package com.ken.assistedliving.genetics;

import java.util.ArrayList;

import com.ken.assistedliving.components.GuiHelper;

public class GA {
	
	ArrayList<Chromosome> theChromosomes=new ArrayList<Chromosome>();
	private GuiHelper helper=new GuiHelper();

	
	public GA(){
		helper.loadCourses();
	}
	
	
	public void startGA(int populationSize){
		//generate initial population
		generateInitialPopulation(populationSize);
		
		//select a pair of chromosomes for mating frim the current population
		
		
	}
	
	
	
	
	private void generateInitialPopulation(int populationSize){
		
		for(int i=0;i<populationSize;i++){
			theChromosomes.add(i, getARandomChromosome());
		}
	}
	
	
	
	private Chromosome getARandomChromosome(){
		Chromosome chromosome =new Chromosome();
		chromosome.addWeek(helper.createRandomMealForWeek());
		chromosome.setFitnessFunction();
		return chromosome;
	}

}
