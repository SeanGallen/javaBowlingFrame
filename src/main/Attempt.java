package main;

public class Attempt {
	public int totalPinsKnockedDown = 0;

	public int getPinsKnockedDown() {
		return totalPinsKnockedDown;
	}

	public void setPinsKnockedDown(int pinsKnockedDown) {
		this.totalPinsKnockedDown += pinsKnockedDown;
	}
}
