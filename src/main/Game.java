package main;

import java.util.ArrayList;

public class Game {

	private int score;
	public ArrayList<Frame> frames;
	private int possible3Attempts;
	
	public Game() {
		frames = new ArrayList<Frame>();
		for (int i = 0; i < 9; i++) {
			frames.add(new Frame(2));			
		}
		frames.add(new Frame(possible3Attempts));
	}
	
	public void updateScore(int numberOfPinsKnockedDown) {
		score += numberOfPinsKnockedDown;
	}

	public int getScore() {
		return score;
	};
	
	public ArrayList<Frame> getFrames() {
		return frames;
	}

	public ArrayList<Frame> getCompletedFrames() {
		ArrayList<Frame> completedFrames = new ArrayList<Frame>();
		
		for (Frame frame: getFrames()) {
			if (frame.getCompletionStatus()) {
				completedFrames.add(frame);
			}
		}
		return completedFrames;
	}

}
