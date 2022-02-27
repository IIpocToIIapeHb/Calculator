package by.home.java_fundamentals.calc;



public class Calculator {
	public double calculate(String expression) {
		LexemeStorageCreator lexemeStorageCreator = new LexemeStorageCreator();
		LexemeStorage lexemeStorage = lexemeStorageCreator.createFromExpression(expression);		
		LexemeProcessor lexemeProcessor = new LexemeProcessor();
		
		double result = lexemeProcessor.calculate(lexemeStorage);
		
		return result;
	}
}
