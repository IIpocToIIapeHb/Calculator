package by.home.java_fundamentals.calc;



public class LexemeProcessor {
public double calculate(LexemeStorage storage) {
		
		Lexeme lexeme = storage.next();
		if (lexeme.getType() == LexemeType.END) {
			throw new  IllegalArgumentException("Expression is empty");
		}
		storage.backPosition();
		
		return plusOrMinus(storage);
	}

	private double plusOrMinus(LexemeStorage storage) {
		double value = multipleOrDivide(storage);
		while (true) {
			Lexeme lexeme = storage.next();
			switch (lexeme.getType()) {
				case PLUS:
					value += multipleOrDivide(storage);
					break;
				case MINUS:
					value -= multipleOrDivide(storage);
					break;
				case END:
				case RIGHT_BRACKET:
					storage.backPosition();
					return value;
				default:
					throw new IllegalArgumentException("Unexpected token: " + lexeme.getValue());
			}
		}

	}

	private double multipleOrDivide(LexemeStorage storage) {
		double value = numberOrBracket(storage);

		while (true) {
			Lexeme lexeme = storage.next();
			switch (lexeme.getType()) {
				case MULTIPL:
					value *= numberOrBracket(storage);
					break;
				case DIV:
					value /= numberOrBracket(storage);
					break;
				case RIGHT_BRACKET:
				case PLUS:
				case MINUS:
				case END:
					storage.backPosition();
					return value;
	
				default:
					throw new IllegalArgumentException("Unexpected token: " + lexeme.getValue());
				}

		}
	}

	private double numberOrBracket(LexemeStorage storage) {
		Lexeme lexeme = storage.next();
		switch (lexeme.getType()) {
			case NUMBER:
				return Integer.parseInt(lexeme.getValue());
				
	
			case LEFT_BRACKET:
				
				/*
				 * if (storage.next().getType() == LexemeType.MINUS) { storage.addLexeme(new
				 * Lexeme(LexemeType.NUMBER, "0"), storage.getPosition());
				 * storage.backPosition(); }
				 */
				 
				double value = plusOrMinus(storage);
				lexeme = storage.next();
				if (lexeme.getType() != LexemeType.RIGHT_BRACKET) {
					throw new RuntimeException("Unexpected token:" + lexeme.getValue());
				}
				return value;
			default:
				throw new IllegalArgumentException("Unexpected token:[[[[ " + lexeme.getValue());
			}
	}
}
