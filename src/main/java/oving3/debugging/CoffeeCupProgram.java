package oving3.debugging;

import java.util.Random;

public class CoffeeCupProgram {

	private CoffeeCup cup;
	private Random r;

	public void run() {
		this.part1();
		this.part2();
	}

	private void part1() {
		this.cup = new CoffeeCup();
		this.r = new Random(123456789L);
		this.cup.increaseCupSize(40.0);
		this.cup.fillCoffee(20.5);
		this.cup.drinkCoffee(Math.floor(this.r.nextDouble() * 20.5));
		this.cup.fillCoffee(32.5);
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 38.9));
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 42));
		this.cup.increaseCupSize(17);
		this.cup.drinkCoffee(40);
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 42));
		this.cup.drinkCoffee(Math.floor(this.r.nextDouble() * 20.5));
		this.cup.fillCoffee(32.5);
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 38.9));
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 42));
		this.cup.increaseCupSize(17);
	}

	private void part2() {
		this.cup = new CoffeeCup(40.0, 20.5);
		this.r = new Random(987654321L);
		this.cup.drinkCoffee(Math.floor(this.r.nextDouble() * 20.5));
		this.cup.fillCoffee(Math.floor(this.r.nextDouble() * 30));
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 38.9));
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 42));
		this.cup.increaseCupSize(Math.floor(this.r.nextDouble() * 26));
		this.cup.fillCoffee(Math.ceil(this.r.nextDouble() * 59));
		this.cup.drinkCoffee(Math.ceil(this.r.nextDouble() * 42));
		this.cup.increaseCupSize(Math.floor(this.r.nextDouble() * 35));
		this.cup.fillCoffee(Math.floor(this.r.nextDouble() * 30));
		this.cup.increaseCupSize(Math.floor(this.r.nextDouble() * 26));
	}

	public static void main(String[] args) {
		CoffeeCupProgram program = new CoffeeCupProgram();
		program.run();
	}
}
