package main;

import java.util.ArrayList;

public abstract class Frame {
	protected ArrayList<Attempt> attempts;
	public Boolean isComplete = false;
	public Boolean isStrike = false;
	public Boolean isSpare = false;
	private int score = 0;

	public void markAsComplete() {
		isComplete = true;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		this.score = newScore;
	}

	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
	
	protected ArrayList<Attempt> initializeAttempts(int maxAttempts) {
		ArrayList<Attempt> attempts = new ArrayList<Attempt>();
		for (int i = 0; i < maxAttempts; i++) {
			attempts.add(new Attempt());
		}
		
		return attempts;
	}

}
