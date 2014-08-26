package com.ken.assistedliving.genetics;

import java.util.ArrayList;
import java.util.Random;

public class MainTest {
	Random randomGenerator=new Random();
	ArrayList<Chromosome> theChromosomes=new ArrayList<Chromosome>();
	ArrayList<Chromosome> newChromosomes=new ArrayList<Chromosome>();
	double averageFitness=0;
	int numberOfGenerationsRun=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainTest mainTest=new MainTest();
	}
	
	public MainTest(){
		
		System.out.println("------------------------new Run----------------");
		System.out.println("------------------------new Run----------------");
		
		theChromosomes.clear();
		
		//step 1 page 222
		int popupationSize=100;
		
		//step3
		for(int i=0;i< popupationSize;i++){
			theChromosomes.add(i,getARandomChromosome());
		}
			
			//so now have the 6 chromosome with their fitness already calculated
			
			//now need to select 3 pairs of cchromosomes and do the mating
			//so that we end up with 6 new chromosomes
			
			while(terminationCriterionHasBeenMet()==false){
				//step 5 select two chromosomes based on their fitness function, this is getting tricky see page 225
				
				//step a: sum of the fitness values so can calculate the % that each gets
				
				double sumOfFitnessFunctions=0;
				for(Chromosome chromosome: theChromosomes){
					sumOfFitnessFunctions+=chromosome.getTheChromosomeFitness();
					
				}
				//display the current total fitness so can see how it changes
				System.out.println("The current average fitness for generation "+ numberOfGenerationsRun+" is: "+sumOfFitnessFunctions/6);
				
				//step b: set the percentage of fitness for each generation
				for(Chromosome chromosome:theChromosomes){
					double fitness=chromosome.getTheChromosomeFitness();
					double fitnessPercentageOfCurrentPopulation=fitness/sumOfFitnessFunctions;
					chromosome.setFitnessPercentageOfCurrentPopulation(fitnessPercentageOfCurrentPopulation);
				}
				
				//check that the percentages add up to 1
				double totalOfFitnessPercentages=0;
				for(Chromosome chromosome:theChromosomes){
					totalOfFitnessPercentages+=chromosome.getFitnessPercentageOfCurrentPopulation();
				}
				//System.out.println("The total fitness percentage of the population is: "+totalOfFitenessPercentage);
				
				//step c: set the place/area on the 'roulette wheel' that eachchromosome occupies
				
				double rouletteStartPosition=0;
				for(Chromosome chromosome:theChromosomes){
					chromosome.setRouletteStartPosition(rouletteStartPosition);
					double rouletteFinishPosition=rouletteStartPosition+chromosome.getFitnessPercentageOfCurrentPopulation();
					chromosome.setRouletteFinishPosition(rouletteFinishPosition);
					rouletteStartPosition=rouletteFinishPosition; //for the next chromosome
				}
				
				//step 5 
				newChromosomes.clear();
				//see what the current Strings are before I mate them.
				int count=1;
				for(Chromosome chromosome:theChromosomes){
					//System.out.println("The Chromosome String is: "+chromosome.getTheChromosomeString);
					if(count%2==0){
						//system.out.println();
					}
					count++;
				}
				
				for(int i=0;i<3;i++){
					double aRouletteSpin1=randomGenerator.nextDouble();
					double aRouletteSpin2=randomGenerator.nextDouble();
					
					Chromosome mumChromosome=findChromosomeFromRouletteSpin(aRouletteSpin1);
					Chromosome dadChromosome=findChromosomeFromRouletteSpin(aRouletteSpin2);
					
					
					crossover(mumChromosome, dadChromosome);
				}
				
				//step9
				theChromosomes.clear();
				theChromosomes.addAll(newChromosomes);
				
				
				
			}//end of while
		
		
	}



	private boolean terminationCriterionHasBeenMet(){
		numberOfGenerationsRun++;
		if(numberOfGenerationsRun>1000){
			return true;
		}else{
			return false;
		}
	}
	
	private void crossover(Chromosome mumChromosome,Chromosome dadChromosome){
		Chromosome child1=null;
		Chromosome child2=null;
		
		double crossoverRate=0.7;
		double random=randomGenerator.nextDouble();
		
		if(random<crossoverRate){
			
			int crossoverPoint=randomGenerator.nextInt(3)+1;
			
			String mumChromosomeBeforeCrossoverPoint=mumChromosome.getTheChromosomeString().substring(0, crossoverPoint);
			String dadChromosomeBeforeCrossoverPoint=dadChromosome.getTheChromosomeString().substring(0, crossoverPoint);
			
			//get the String after the crossover point of the mumChromosome
			String mumChromosomeAfterCrossoverPoint=mumChromosome.getTheChromosomeString().substring(crossoverPoint,4);
			String dadChromosomeAfterCrossoverPoint=dadChromosome.getTheChromosomeString().substring(crossoverPoint,4);
			
			String child1String=mumChromosomeBeforeCrossoverPoint+dadChromosomeAfterCrossoverPoint;
			String child2String=dadChromosomeBeforeCrossoverPoint+mumChromosomeAfterCrossoverPoint;
			
			child1=new Chromosome(child1String);
			child2=new Chromosome(child2String);
			
		}else{
			//do nothing
			child1= new Chromosome(mumChromosome.getTheChromosomeString());
			child2= new Chromosome(dadChromosome.getTheChromosomeString());
			
		}
		
		//step 6 Mutation
		child1=mutate(child1);
		child2=mutate(child2);
		
		//step 7 place the created offspring in the new population
		newChromosomes.add(child1);
		newChromosomes.add(child2);
		
		
	}
	
	private Chromosome mutate(Chromosome chromosome){
		double mutationRate=0.005; //see page 226
		double randomForDecidingIfToMutate=randomGenerator.nextDouble();
		
		if(randomForDecidingIfToMutate<mutationRate){
			//going to mutate
			//select a gene (one of the letters) at random
			int theGeneToMutateInt=randomGenerator.nextInt(4);//chooses either 0,1,2,3
			String chromosomeString =chromosome.getTheChromosomeString();
			char[] chromosomeCharArray=chromosomeString.toCharArray();
			Character theGeneToMutateChar=chromosomeCharArray[theGeneToMutateInt];
			
			if(theGeneToMutateChar.equals('1')){
				chromosomeCharArray[theGeneToMutateInt]='0';
				
			}else{
				chromosomeCharArray[theGeneToMutateInt]='1';
			}
			chromosomeString=new String(chromosomeCharArray);
			return new Chromosome(chromosomeString);
		}else{
			return chromosome;
		}
	}
	
	private Chromosome findChromosomeFromRouletteSpin(double aRouletteSpin1){
		for(Chromosome chromosome:theChromosomes){
			if((aRouletteSpin1>chromosome.getRouletteStartPosition()) && (aRouletteSpin1<chromosome.getRouletteFinishPosition())){
				return chromosome;
			}
		}
		
		return null;//something went wrong
	}
	
	private Chromosome getARandomChromosome(){
		String theChromosomeString="";
		for(int i=0;i<4;i++){
			theChromosomeString=theChromosomeString + getARandomOneOrZero();
		}
		return new Chromosome(theChromosomeString);
	}
	
	private String getARandomOneOrZero(){
		int randomInt=randomGenerator.nextInt(2);
		return String.valueOf(randomInt);
	}
	
	
	
	
	
	
	
	
}

