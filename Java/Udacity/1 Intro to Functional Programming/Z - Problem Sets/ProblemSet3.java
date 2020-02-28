/*

Problem Set - https://d17h27t6h515a5.cloudfront.net/topher/2016/July/57881f16_problem-set-3/problem-set-3.pdf (01/03/2019)

Q1 - B: float (public FLOAT squareRoot(int x)

Q2 - 
public boolean isPrime(int x)

Q3 - A: public getAccountBalance(long accountNumber) (It has no return type)

Q4 - 
public double absoluteValue(double x){
	if(x < 0){
		return -x;
	} else {
		return x;
	}
}

Q5 - 
public double calculateTip(double costOfMeal){
	double tip = costOfMeal * 0.15
	return tip;
}

Q6 - 
public String nametagText(String name){
	String hello = "Hello, my name is " + name
	return hello;
}

Q7 - 
/**
* This function converts a double of temperature in Fahrenheit and returns the equivalent temperature in Celsius.
*
* @param tempInFahrenheit the temperature in Fahrenheit
*
* @return tempInCelsius returns the equivalent Fahrenheit temperature in Celsius.
public double fahrenheitToCelsius(double tempInFahrenheit){
	return ((tempInFahrenheit - 32) * 5) / 9;
}

/**
* This function prints both the temperature in Fahrenheit and Celsius
*
* @param tempInFahrenheit the temperature in Fahrenheit
*
* @return tempInCelsius returns the equivalent Fahrenheit temperature in Celsius.
public void printTemperature(double tempInFahrenheit){
	System.out.println("F: " + tempInFahrenheit);
	System.out.println("C: " + fahrenheitToCelsius(tempInFahrenheit));
}

Q8 - 
public int rollDice(int sides){
	double randomRoll = Math.random() * sides;
	randomRoll = randomRoll + 1;
	return (int) randomRoll;
}
public int monopolyRoll(){
	int roll1 = rollDice(6);
	int roll2 = rollDice(6);
	int total = roll1 + roll2
	if(roll1 == roll2){
		int roll3 = rollDice(6);
		int roll4 = rollDice(6);
		total = total + roll3 + roll4
	}
	return total;
}

*/