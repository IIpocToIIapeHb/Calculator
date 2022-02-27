package by.home.java_fundamentals.calc;

import java.util.List;

public class LexemeStorage {
	private int position;
	public List<Lexeme> lexemes;

	public LexemeStorage(List<Lexeme> lexemes) {
		
		this.lexemes = lexemes;

	}	
	
	
	public  int getPosition() {
		return position;
	}
	
	
	public Lexeme next() {
		return lexemes.get(position++);
	}

	
	public int backPosition() {
		return position--;
	}	
	
	public void deleteLexeme() {
		lexemes.remove(position);
	}
	
	public void addLexeme(Lexeme lexeme, int position) {
		lexemes.add(position, lexeme);
	}
}
