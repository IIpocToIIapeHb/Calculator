package by.home.java_fundamentals.calc;


public class Main {

	public static void main(String[] args) {
		
		String expression = "2+(2*2)";
		Calculator calculator = new Calculator();
		double result = calculator.calculate(expression);
		System.out.println(result);
		
	}

}
