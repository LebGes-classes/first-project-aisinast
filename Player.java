public class Player {
	private final String name;
	private int points;
	private int currentLevel;

	private int levelPoints;
	private int actualI;
	private int actualJ;

	public Player(String name) {
		this.name = name;
		points = 0;
		currentLevel = 0;
	}

	public String getName() {
		return name;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public void setLevelPoints(int levelPoints) {
		this.levelPoints = levelPoints;
	}

	public int getLevelPoints() {
		return levelPoints;
	}

	public void setActualI (int actualI) {
		this.actualI = actualI;
	}

	public int getActualI () {
		return actualI;
	}

	public void setActualJ (int actualJ) {
		this.actualJ = actualJ;
	}

	public int getActualJ () {
		return actualJ;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void getInfo() {
		System.out.println("Имя пользователя: " + name);
		System.out.println("Набранные очки: " + points);
		if (currentLevel == 0) {
			System.out.println("Не пройдено ни одного уровня");
		} else {
			System.out.println("Пройдено уровней: " + currentLevel);
		}
	}
}