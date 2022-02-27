package by.home.java_fundamentals.calc;


public class Lexeme {
	private LexemeType type;
	private String value;
	
	public Lexeme(LexemeType type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public Lexeme(LexemeType type, char value) {
		this.type = type;
		this.value = String.valueOf(value);
	}
	
	

	public LexemeType getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "Lexeme [type=" + type + ", value=" + value + "]";
	}
}
