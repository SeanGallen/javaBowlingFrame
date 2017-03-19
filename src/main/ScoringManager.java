package main;

import java.util.ArrayList;

public class ScoringManager {
	
	private Game  game = new Game();;
	private int currentFrame;
	private ArrayList<Frame>  firstGame;
	
	private int score;
	
	public ScoringManager() {
		   firstGame = game.getFrames();
	}
	
	public int rollScore(int first, int second, int currentScore) {

			firstGame.get(currentFrame).attempts.get(0).setPinsKnockedDown(first);
			firstGame.get(currentFrame).attempts.get(1).setPinsKnockedDown(second);
		
		    score = firstGame.get(currentFrame).attempts.get(0).getPinsKnockedDown();
			score += firstGame.get(currentFrame).attempts.get(1).getPinsKnockedDown();
			score += currentScore;
	
	
		return score;
	}

  

	public int score() {		
		return score;
	}

}
