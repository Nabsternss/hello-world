package GuessTheGame;

public class test {

	public static void main(String[] args) {
		String word = "bannanas";
		String guess = "n";
		int index = word.indexOf(guess);
		while (index >= 0) {
		    System.out.println(index);
		    index = word.indexOf(guess, index + 1);
		}
	}

}
