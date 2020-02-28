/*

Problem Set - https://d17h27t6h515a5.cloudfront.net/topher/2016/July/57881f24_problem-set-4/problem-set-4.pdf (15/03/2019)

Q1 - D: 80 (n = 10. n is less than 50 so it will be doubled. n = 20. n is still less than 50 so it will be doubled. n = 40. n is still less than 50 so it will be doubled again. n = 80. n is now greater than 50 so it will exit the while loop and n will be printed, which is 80)

Q2 - 
public int factorial(int n) {
	int factorial = 1;
	for(int i = 1; i <= n; i++) {
		factorial = factorial * i;
	}
	return factorial;
}

Q3 - 
public int indexOfFirstOccurrence(String[] stringArray, String target) {
	for(int i; i < stringArray.length; i++) {
		if(stringArray[i].equals(target)) {
			return i;
		}
	}
	return -1;
}

Q4 - 
public int yearsTilOneMillion(double initialBalance) {
	int years = 0;
	double rollingBalance = initialBalance;
	while(rollingBalance < 1000000) {
		rollingBalance = rollingBalance * 1.05;	
		years++;
	}
	return years;
}

Q5 - 
public void printInReverse(String[] stringArray) {
	for(int i = stringArray.length - 1; i >= 0; i--) {
		System.out.println(stringArray[i]);
	}
}

Q6 - 
public int findRange(int[] intArray) {
	if(intArray.length == 0) {
		return -1;
	}
	int largestInt = intArray[0];
	int smallestInt = intArray[0];
	for(int i = 1; i < intArray.length; i++) {
		if(intArray[i] > largestInt) {
			largestInt = intArray[i];
		} else if(intArray[i] < smallestInt) {
			smallestInt = intArray[i];
		}
	}
	return largestInt - smallestInt;
}

Q7 - 
#
##
###

Q8 - 
public int rollDice(int sides) {
	double randomRoll = Math.random() * sides;
	randomRoll = randomRoll + 1;
	return (int) randomRoll;
}
public int monopolyRoll() {
	int roll1 = rollDice(6);
	int roll2 = rollDice(6);
	int numberOfRolls = 1;
	int total = roll1 + roll2;
	while(roll1 == roll2) {
		if(numberOfRolls >= 3) return -1;
		roll1 = rollDice(6);
		roll2 = rollDice(6);
		numberOfRolls = numberOfRolls + 1
		total = roll1 + roll2;
	}
	return total;
}
Recursive Function
public int monopolyRoll() {
	int roll1 = diceRoll(6);
	int roll2 = diceRoll(6);
	if(roll1 != roll2) {
		return roll1 + roll2
	} else {
		return roll1 + roll2 + monopolyRoll();
	}

}

*/