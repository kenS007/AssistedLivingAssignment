package com.ken.assistedliving.genetics;

import java.util.ArrayList;

import com.ken.assistedliving.components.Day;

public class Chromosome {
	
	
	//private Day[] dayChromosome=new Day[7]; //this is the chromosome of 7 days
	private ArrayList<Day> week=new ArrayList<Day>();
	
	private String theChromosomeString="";
	private double theChromosomeFitness=-1;
	private double fitnessPercentageOfCurrentPopulation=0;
	private double rouletteStartPosition;
	private double rouletteFinishPosition;
	
	
	public double getTotalCost(){
		double total=0;
		for(Day d:week){
			total=total+d.getTotalCost();
		}
		return total;
	}
	
	public void setFitnessFunction(){  //fitness function for the week
		
		
		
		//first calculate the total cost of the chromosome(week)
		double total=0;
		for(Day d:week){
			total=total+d.getTotalCost();
		}
		
		System.out.println("Total week$: "+total);
		System.out.println("Fitness: "+ 1/total);
		//then return inverse
		//return 1/total;
		theChromosomeFitness=1/total;
	}
	
	public void addWeek(ArrayList<Day> week){
		this.week=week;
	}
	//public void setFitnessFunction(){
		//theChromosomeFitness=fitnessFuction();
	//}
	
	public Chromosome(){
		//theChromosomeFitness=fitnessFuction();
	}
	
	
	
	public Chromosome(String theChromosomeString){ ///////
		this.theChromosomeString=theChromosomeString;
		
		//step 4
		theChromosomeFitness=fitnessFuction(theChromosomeString);
		
	}
	
	//step 2
	private int fitnessFuction(String aChromosome){
		int aChromosomeInt=convertChromosomeStringToInt(aChromosome);
		
		return (15*aChromosomeInt) - (aChromosomeInt*aChromosomeInt);
	}
	
	
	
	
	private int convertChromosomeStringToInt(String aChromosome){
		int int8=Integer.parseInt(Character.toString(aChromosome.charAt(0)));
		int int4=Integer.parseInt(Character.toString(aChromosome.charAt(1)));
		int int2=Integer.parseInt(Character.toString(aChromosome.charAt(2)));
		int intU=Integer.parseInt(Character.toString(aChromosome.charAt(3)));
		
		return int8 * 8 + int4 * 4 + int2 * 2 + intU;
	}
	
	
	
	
	
	public String getTheChromosomeString() {
		return theChromosomeString;
	}

	public void setTheChromosomeString(String theChromosomeString) {
		this.theChromosomeString = theChromosomeString;
	}

	public double getTheChromosomeFitness() {
		return theChromosomeFitness;
	}

	public void setTheChromosomeFitness(double theChromosomeFitness) {
		this.theChromosomeFitness = theChromosomeFitness;
	}

	public double getFitnessPercentageOfCurrentPopulation() {
		return fitnessPercentageOfCurrentPopulation;
	}

	public void setFitnessPercentageOfCurrentPopulation(
			double fitnessPercentageOfCurrentPopulation) {
		this.fitnessPercentageOfCurrentPopulation = fitnessPercentageOfCurrentPopulation;
	}

	public double getRouletteStartPosition() {
		return rouletteStartPosition;
	}

	public void setRouletteStartPosition(double rouletteStartPosition) {
		this.rouletteStartPosition = rouletteStartPosition;
	}

	public double getRouletteFinishPosition() {
		return rouletteFinishPosition;
	}

	public void setRouletteFinishPosition(double rouletteFinishPosition) {
		this.rouletteFinishPosition = rouletteFinishPosition;
	}

	
	public ArrayList<Day> getWeek(){
		return week;
	}
	
	
	public Day getDay(int indx){
		return week.get(indx);
		
	}
	
	

}
