package main;

import java.util.ArrayList;

public class Game {

	private int score;
	public ArrayList<Frame> frames;
	
	public Game() {
		frames = initializeFrames();
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
	
	public void setFrame(int frameIndex) {
		
	}

	public ArrayList<Frame> getCompletedFrames() {
		ArrayList<Frame> completedFrames = new ArrayList<Frame>();
		
		for (Frame frame: getFrames()) {
			if (frame.isComplete) {
				completedFrames.add(frame);
			}
		}
		return completedFrames;
	}
	
	private ArrayList<Frame> initializeFrames() {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		
		// add non-final frames
		for (int i = 0; i < 9; i++) {
			frames.add(new NonFinalFrame());			
		}
		
		// add final frames
		frames.add(new FinalFrame());
		
		return frames;
	}

}
