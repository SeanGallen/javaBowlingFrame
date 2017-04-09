package main;

import java.util.ArrayList;

public class ScoringManager {
	private int gameScore;
	private int frameScore;
	private ArrayList<Frame> frames;

	public int score(Game game) {

		frames = game.getFrames();

		for (int i = 0; i < frames.size(); i++) {

			if (i == 8) {
				frameScore = helperFrameScore(9, 9);

			}

			else if (i == 9) {
				frameScore = 0;
				for (Attempt attempt : frames.get(i).getAttempts()) {
					frameScore += attempt.getPinsKnockedDown();
				}

			} else {
				// process strike
				if (frames.get(i).getAttempts().get(0).getPinsKnockedDown() == 10) {
					// score frame based on next two rolls
					if (frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown() == 10) {
						frameScore = helperFrameScore(i+1, i+2, 0);
						// frames.get(i).setScore(frameScore);
					} else {
						frameScore = helperFrameScore(i+1, i+1);

					}
				}

				// process spare
				else if (frames.get(i).getAttempts().get(0).getPinsKnockedDown()
						+ frames.get(i).getAttempts().get(1).getPinsKnockedDown() == 10) {
					// mark frame as spare
					frames.get(i).isSpare = true;

					frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown();
				}
				// process regular
				else {
					frameScore = 0;
					for (Attempt attempt : frames.get(i).getAttempts()) {
						frameScore += attempt.getPinsKnockedDown();
					}

				}
			}
			frames.get(i).setScore(frameScore);

		}

		return totalEachFrameScore(frames);
	}

	public int totalEachFrameScore(ArrayList<Frame> frames) {
		// total each frame score to get game score
		for (Frame frame : frames) {
			if (frame.isComplete) {
				gameScore += frame.getScore();
			}
		}
		return gameScore;
	}

	public int helperFrameScore(int nextFrameNeeded, int nextFramesScore, int getInt) {
	
		frameScore = 10 + frames.get(nextFrameNeeded).getAttempts().get(getInt).getPinsKnockedDown()
				+ frames.get(nextFramesScore).getAttempts().get(getInt).getPinsKnockedDown();
		return frameScore;
		
		
	}
	
	public int helperFrameScore(int nextFrameNeeded, int nextFramesScore) {
		
		frameScore = 10 + frames.get(nextFrameNeeded).getAttempts().get(0).getPinsKnockedDown()
				+ frames.get(nextFramesScore).getAttempts().get(1).getPinsKnockedDown();
		return frameScore;		
		
	}

	public void processStrikes(Game game) {
		ArrayList<Frame> frames = game.getFrames();

		for (int i = 0; i < frames.size(); i++) {

			// score final frame
			if (i == 9) {
				frameScore = frames.get(9).getAttempts().get(0).getPinsKnockedDown()
						+ frames.get(9).getAttempts().get(1).getPinsKnockedDown()
						+ frames.get(9).getAttempts().get(2).getPinsKnockedDown();
			}
			// score strike frame
			else if (frames.get(i).isStrike) {
				if (frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown() == 10) {
					frameScore = helperFrameScore(i+1, i+2, 0);

				} else {
					frameScore = helperFrameScore(i+1, i+2);

				}

			}

			// score spare frame
			else if (frames.get(i).isSpare) {
				frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown();

			}
			frames.get(i).setScore(frameScore);
		}

	}

}
