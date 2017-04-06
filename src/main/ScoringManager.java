package main;

import java.util.ArrayList;

public class ScoringManager {
	private int gameScore;
	private ArrayList<Frame> frames;

	public int score(Game game) {

		frames = game.getFrames();

		for (int i = 0; i < frames.size(); i++) {

			if (i == 8) {
				int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown()
						+ frames.get(i + 1).getAttempts().get(1).getPinsKnockedDown();
				frames.get(i).setScore(frameScore);
			}

			else if (i == 9) {
				int frameScore = 0;
				for (Attempt attempt : frames.get(i).getAttempts()) {
					frameScore += attempt.getPinsKnockedDown();
				}

				frames.get(i).setScore(frameScore);
			} else {
				// process strike
				if (frames.get(i).getAttempts().get(0).getPinsKnockedDown() == 10) {

					// mark frame as strike
					frames.get(i).isStrike = true;

					// score frame based on next two rolls
					if (frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown() == 10) {
						int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown()
								+ frames.get(i + 2).getAttempts().get(0).getPinsKnockedDown();
						frames.get(i).setScore(frameScore);
					} else {
						int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown()
								+ frames.get(i + 1).getAttempts().get(1).getPinsKnockedDown();
						frames.get(i).setScore(frameScore);
					}
				}

				// process spare
				else if (frames.get(i).getAttempts().get(0).getPinsKnockedDown()
						+ frames.get(i).getAttempts().get(1).getPinsKnockedDown() == 10) {
					// mark frame as spare
					frames.get(i).isSpare = true;

					int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown();
					frames.get(i).setScore(frameScore);
				}

				// process regular
				else {
					int frameScore = 0;
					for (Attempt attempt : frames.get(i).getAttempts()) {
						frameScore += attempt.getPinsKnockedDown();
					}

					frames.get(i).setScore(frameScore);
				}
			}

		}

		// total each frame score to get game score
		for (Frame frame : frames) {
			if (frame.isComplete) {
				gameScore += frame.getScore();
			}
		}

		return gameScore;
	}

	public void processStrikes(Game game) {
		ArrayList<Frame> frames = game.getFrames();

		for (int i = 0; i < frames.size(); i++) {

			// score final frame
			if (i == 9) {
				int frameScore = frames.get(i).getAttempts().get(0).getPinsKnockedDown()
						+ frames.get(i).getAttempts().get(1).getPinsKnockedDown()
						+ frames.get(i).getAttempts().get(2).getPinsKnockedDown();
				frames.get(i).setScore(frameScore);
			}

			// score strike frame
			else if (frames.get(i).isStrike) {
				if (frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown() == 10) {
					int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown()
							+ frames.get(i + 2).getAttempts().get(0).getPinsKnockedDown();
					frames.get(i).setScore(frameScore);
				} else {
					int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown()
							+ frames.get(i + 1).getAttempts().get(1).getPinsKnockedDown();
					frames.get(i).setScore(frameScore);
				}

			}

			// score spare frame
			else if (frames.get(i).isSpare) {
				int frameScore = 10 + frames.get(i + 1).getAttempts().get(0).getPinsKnockedDown();
				frames.get(i).setScore(frameScore);
			}
		}
	}

}
