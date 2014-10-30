package com.ken.assistedliving.genetics;

import java.util.ArrayList;
import java.util.Random;

import com.ken.assistedliving.components.Course;
import com.ken.assistedliving.components.Day;
import com.ken.assistedliving.components.GuiHelper;

public class GA {

	ArrayList<Chromosome> currentPopulation = new ArrayList<Chromosome>();
	ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();
	private GuiHelper helper = new GuiHelper();
	int numOfGensRun = 0; // number of generations
	int maxGen=0;
	Random genRandom = new Random();
	int mutationCount=0;

	private int populationSize = 0;
	private double crossoverProb = 0;
	private double mutationProb = 0;
	private double maxCost=0;
	
	

	public GA() {
		helper.loadCourses();
	}

	public void startGA(int populationSize, double crossoverProb,
			double mutationProb, int maxGen,double maxCost) {
		this.populationSize = populationSize;
		this.crossoverProb = crossoverProb;
		this.mutationProb = mutationProb;
		this.maxCost=maxCost;
		this.maxGen=maxGen;
		numOfGensRun=0;

		// generate initial population
		generateInitialPopulation();

		// while (numOfGensRun != 100) {
		while (terminationCriteriaHasBeenMet()==false) {
			numOfGensRun++;

			System.out.println(" ");
			System.out
					.println("===========================================================");
			System.out.println("Generation: " + numOfGensRun);
			System.out.println(" ");

			// select a pair of chromosomes for mating from the current
			// population

			// step 1 sum the fitness values so we can calculate the % that each
			// gets

			double sumOfFitnessFunctions = 0;
			for (Chromosome chromosome : currentPopulation) {
				// System.out.println("The fitness is: "+chromosome.getTheChromosomeFitness());
				sumOfFitnessFunctions += chromosome.getTheChromosomeFitness();
			}

			// Display the current total fitness so we can see how it changes
			System.out
					.println("The current average fitness for each generation "
							+ numOfGensRun + " is: " + sumOfFitnessFunctions);

			// step 2 set the percentage of fitness for each chromosome

			for (Chromosome chromosome : currentPopulation) {
				double fitness = chromosome.getTheChromosomeFitness();
				double fitnessPercentageOfCurrentPopulation = fitness
						/ sumOfFitnessFunctions;
				chromosome
						.setFitnessPercentageOfCurrentPopulation(fitnessPercentageOfCurrentPopulation);

			}

			// check that the percentages add up to 1
			double totalOfFitnessPercentages = 0;
			for (Chromosome chromosome : currentPopulation) {
				totalOfFitnessPercentages += chromosome
						.getFitnessPercentageOfCurrentPopulation();
			}
			System.out.println("The total fitness percentages of Gen: "
					+ numOfGensRun + " is: " + totalOfFitnessPercentages);

			// step c: Set the place/area on the'roulette wheel' that each
			// chromosome occupies
			// http://stackoverflow.com/questions/1575061/ga-written-in-java
			// says:
			// Just a point worth mentioning. The Roulette wheel selection (as
			// indicated in the pseudo-code)
			// will not work for minimization problems - it is, however, valid
			// for
			// maximization problems.
			double rouletteStartPosition = 0;
			for (Chromosome chromosome : currentPopulation) {
				chromosome.setRouletteStartPosition(rouletteStartPosition);
				double rouletteFinishPosition = rouletteStartPosition
						+ chromosome.getFitnessPercentageOfCurrentPopulation();
				chromosome.setRouletteFinishPosition(rouletteFinishPosition);
				rouletteStartPosition = rouletteFinishPosition; // for the next
																// chromosome;
			}

			// step 5
			newPopulation.clear();

			System.out.println("Step 8");

			for (int i = 0; i < populationSize / 2; i++) { // step 8
				System.out.println("Mating " + i);

				double rouletteSpin1 = genRandom.nextDouble();
				double rouletteSpin2 = genRandom.nextDouble();

				Chromosome parent1 = findChromosomeFromRoulleteSpin(rouletteSpin1);
				 System.out.println("parent1: "
				 + parent1.getTheChromosomeFitness() + "   "
				 + parent1.getFitnessPercentageOfCurrentPopulation());
				Chromosome parent2 = findChromosomeFromRoulleteSpin(rouletteSpin2);
				 System.out.println("parent2: "

				 + parent2.getFitnessPercentageOfCurrentPopulation());

				crossover2(parent1, parent2);

			}

			// currentPopulation=null;

			currentPopulation.clear();

			currentPopulation.addAll(newPopulation);

		}

	}
	
	private boolean terminationCriteriaHasBeenMet(){
		
		if(numOfGensRun>maxGen){
			System.out.println("criteria has been met: Max generations has been run!!");
			return true;
		}
		
		
		for(Chromosome c:currentPopulation){
			if(c.getTotalCost()<maxCost){
				System.out.println("Criteria has been met");
				return true;
			}
		}
		
		
		return false;
		
	}
	

	private Chromosome findChromosomeFromRoulleteSpin(double rouletteSpin) {
		for (Chromosome chromosome : currentPopulation) {
			if ((rouletteSpin > chromosome.getRouletteStartPosition())
					&& (rouletteSpin < chromosome.getRouletteFinishPosition())) {
				return chromosome;
			}

		}

		return null;
	}

	private void crossover(Chromosome parent1, Chromosome parent2) {
		Chromosome child1 = new Chromosome();
		Chromosome child2 = new Chromosome();

		int crossoverPointForWeek = genRandom.nextInt(6) + 1;
		System.out.println("week cutpoint: " + crossoverPointForWeek);

		/*
		 * 
		 * int crossoverPointForB = genRandom.nextInt(1)+1;
		 * //System.out.println("B cutpoint: "+crossoverPointForB); int
		 * crossoverPointForL = genRandom.nextInt(2)+1;
		 * //System.out.println("L cutpoint: "+crossoverPointForL); int
		 * crossoverpointForD = genRandom.nextInt(2)+1;
		 * //System.out.println("D cutpoint: "+crossoverpointForD);
		 */

		System.out.println("the cost of parent 1: $" + parent1.getTotalCost());
		System.out.println("the cost of parent 2: $" + parent2.getTotalCost());

		ArrayList<Day> weekC1 = new ArrayList<Day>();
		ArrayList<Day> weekC2 = new ArrayList<Day>();

		for (int i = 0; i < crossoverPointForWeek; i++) {

			Day dayC1 = new Day();
			Day dayC2 = new Day();

			dayC1.setBreakfast(parent1.getDay(i).getBreakfastList());
			dayC2.setBreakfast(parent2.getDay(i).getBreakfastList());

			dayC1.setLunch(parent1.getWeek().get(i).getLunchList());
			dayC2.setLunch(parent2.getWeek().get(i).getLunchList());

			dayC1.setDinner(parent1.getWeek().get(i).getDinnerList());
			dayC2.setDinner(parent2.getWeek().get(i).getDinnerList());

			weekC1.add(dayC1);
			weekC2.add(dayC2);

		}

		for (int i = crossoverPointForWeek; i < 7; i++) {

			Day dayC1 = new Day();
			Day dayC2 = new Day();

			dayC1.setBreakfast(parent2.getDay(i).getBreakfastList());
			dayC2.setBreakfast(parent1.getDay(i).getBreakfastList());

			dayC1.setLunch(parent2.getWeek().get(i).getLunchList());
			dayC2.setLunch(parent1.getWeek().get(i).getLunchList());

			dayC1.setDinner(parent2.getWeek().get(i).getDinnerList());
			dayC2.setDinner(parent1.getWeek().get(i).getDinnerList());

			weekC1.add(dayC1);
			weekC2.add(dayC2);
		}

		child1.addWeek(weekC1);
		child2.addWeek(weekC2);

		System.out.println("the cost of child 1: $" + child1.getTotalCost());
		System.out.println("the cost of child 2: $" + child2.getTotalCost());

		// add children to new population
		newPopulation.add(child1);
		newPopulation.add(child2);

	}

	public void crossover2(Chromosome parent1, Chromosome parent2) {
		Chromosome child1 = new Chromosome();
		Chromosome child2 = new Chromosome();

		System.out.println("the cost of parent 1: $" + parent1.getTotalCost());
		System.out.println("the cost of parent 2: $" + parent2.getTotalCost());

		double randCrossoverProb = genRandom.nextDouble();

		if (randCrossoverProb < crossoverProb) {

			int cpCount = 0;
			int crossoverPoint = genRandom.nextInt(55) + 1;

			ArrayList<Day> weekC1 = new ArrayList<Day>();
			ArrayList<Day> weekC2 = new ArrayList<Day>();

			for (int i = 0; i < 7; i++) {
				Day dayC1 = new Day();
				Day dayC2 = new Day();

				// breakfast
				for (int j = 0; j < 2; j++) {
					cpCount++;
					if (cpCount < crossoverPoint) { // less than crossover point
						dayC1.addBreakfast(parent1.getWeek().get(i)
								.getBreakfastItem(j));
						dayC2.addBreakfast(parent2.getWeek().get(i)
								.getBreakfastItem(j));
					} else {
						dayC1.addBreakfast(parent2.getWeek().get(i)
								.getBreakfastItem(j));
						dayC2.addBreakfast(parent1.getWeek().get(i)
								.getBreakfastItem(j));
					}

				}
				// lunch
				for (int j = 0; j < 3; j++) {
					cpCount++;
					if (cpCount < crossoverPoint) {
						dayC1.addLunch(parent1.getWeek().get(i).getLunchItem(j));
						dayC2.addLunch(parent2.getWeek().get(i).getLunchItem(j));
					} else {
						dayC1.addLunch(parent2.getWeek().get(i).getLunchItem(j));
						dayC2.addLunch(parent1.getWeek().get(i).getLunchItem(j));
					}

				}
				// dinner
				for (int j = 0; j < 3; j++) {
					cpCount++;
					if (cpCount < crossoverPoint) {
						dayC1.addDinner(parent1.getWeek().get(i)
								.getLunchItem(j));
						dayC2.addDinner(parent2.getWeek().get(i)
								.getLunchItem(j));
					} else {
						dayC1.addDinner(parent2.getWeek().get(i)
								.getLunchItem(j));
						dayC2.addDinner(parent1.getWeek().get(i)
								.getLunchItem(j));
					}
				}

				weekC1.add(dayC1);
				weekC2.add(dayC2);

			}
			child1.addWeek(weekC1);
			child2.addWeek(weekC2);

			child1.setFitnessFunction();
			child2.setFitnessFunction();

			System.out
					.println("the cost of child 1: $" + child1.getTotalCost());
			System.out
					.println("the cost of child 2: $" + child2.getTotalCost());

			// add children to new population

			if (newPopulation.size() != populationSize) {
				newPopulation.add(child1);
			}
			if (newPopulation.size() != populationSize) {
				newPopulation.add(child2);
			}

		} else {

			child1.addWeek(parent1.getWeek());
			child2.addWeek(parent2.getWeek());

			child1.setFitnessFunction();
			child2.setFitnessFunction();
			
			newPopulation.add(child1);
			newPopulation.add(child2);
		}
	}

	private void mutate(Chromosome chromosome) {
		int mutationDay = genRandom.nextInt(7);
		int mutationMeal = genRandom.nextInt(3);
		mutationCount++;

		Course tempCourse = new Course();

		if (mutationMeal == 0) {// breakfast
			int mutationSlot = genRandom.nextInt(1);//slot
			if(mutationSlot==0){
				
				helper.mutationHelper(chromosome.getWeek(), "b1",tempCourse,"breakfast");
			}
			if(mutationSlot==1){
				helper.mutationHelper(chromosome.getWeek(), "b2",tempCourse,"breakfast");
			}

		}
		if (mutationMeal == 1) {// lunch
			int mutationSlot = genRandom.nextInt(3);//slot
			if(mutationSlot==0){
				helper.mutationHelper(chromosome.getWeek(), "l1",tempCourse,"Lunch");
			}
			if(mutationSlot==1){
				helper.mutationHelper(chromosome.getWeek(), "l2",tempCourse,"Lunch");
			}
			if(mutationSlot==2){
				helper.mutationHelper(chromosome.getWeek(), "l3",tempCourse,"Lunch");
			}
			
		}
		if (mutationMeal == 2) {// dinner
			int mutationSlot = genRandom.nextInt(3);//slot

			if(mutationSlot==0){
				helper.mutationHelper(chromosome.getWeek(), "d1",tempCourse,"Dinner");
			}
			if(mutationSlot==1){
				helper.mutationHelper(chromosome.getWeek(), "d2",tempCourse,"Dinner");
			}
			if(mutationSlot==2){
				helper.mutationHelper(chromosome.getWeek(), "d3",tempCourse,"Dinner");
			}
			
			
			
		}

	}
	
	
	

	private void generateInitialPopulation() {

		for (int i = 0; i < populationSize; i++) {
			currentPopulation.add(i, getARandomChromosome());
		}
	}

	private Chromosome getARandomChromosome() {
		Chromosome chromosome = new Chromosome();
		chromosome.addWeek(helper.createRandomMealForWeek());
		chromosome.setFitnessFunction();
		return chromosome;
	}

}
