package app.domain;

class SecretCombination extends Combination {

	public SecretCombination() {
		super();
		this.randomFill();
	}

	public void randomFill() {
		int i = 0;
		while (i < this.getColors().length) {
			Color randomColor = Color.random();
			if (!this.contains(randomColor)) {
				this.getColors()[i] = randomColor;
				i++;
			}
		}
	}

}
