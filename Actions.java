import java.util.Scanner;

public class Actions {
	private static final Scanner scanner = new Scanner(System.in);

	public static void play(Player player, int actualI, int actualJ, String[][] maze, int finalI, int finalJ) { 
		player.setLevelPoints(0);
		player.setActualI(actualI);
		player.setActualJ(actualJ);

		String symbol;

		boolean isGaming = true; 

		String[][] mazeWithStars = Labyrinth.randomStars(player, maze);
		Functions.printArray(mazeWithStars);

		while (isGaming) {
			System.out.println("Введите символ действия (AWSD)");
			symbol = scanner.nextLine().toUpperCase();

			switch (symbol){
			case "A":
				action(player, mazeWithStars, 0, -1, finalI, finalJ);
				break;
			case "D":
				action(player, mazeWithStars, 0, 1, finalI, finalJ); 
				break;
			case "W":
				action(player, mazeWithStars, -1, 0, finalI, finalJ); 
				break;
			case "S":
				action(player, mazeWithStars, 1, 0, finalI, finalJ); 
				break;
			default:
				System.out.println("Некорректный ввод. Введите A, W, S или D.\n(Для продолжения нажмите клавишу enter)");
				scanner.nextLine();
			}

			if (finalI == player.getActualI() && finalJ == player.getActualJ()) {
				isGaming = false;
				break;
			}

			Functions.clearingConsole();
			Functions.printArray(mazeWithStars);
		}
	}

	private static void action(Player player, String[][] maze, int deltaI, int deltaJ, int finalI, int finalJ) {
		int newI = player.getActualI() + deltaI;
		int newJ = player.getActualJ() + deltaJ;

		if (newI >= maze.length || newI < 0 || newJ >= maze[0].length || newJ < 0 || maze[newI][newJ].equals("██")) {
			System.out.println("Стена! Вы не можете туда идти \n(Для продолжения нажмите клавишу enter)");
			scanner.nextLine();
			return;
		} else {
			if (maze[newI][newJ].equals("☆ ")) {
				player.setLevelPoints(player.getLevelPoints() + 1);
			} else if (newI == finalI && newJ == finalJ) {
				System.out.println("Выход найден!");
				exitMaze(player);
			}
			maze[newI][newJ] = "𓆉 ";
			maze[player.getActualI()][player.getActualJ()] = "  ";
			player.setActualI(newI);
			player.setActualJ(newJ);
		}
	}

	private static void exitMaze(Player player) {
		player.setPoints(player.getPoints() + player.getLevelPoints());
		player.setCompletedLevels(player.getCompletedLevels() + 1);

		System.out.println("Вы набрали " + player.getLevelPoints() + " балла(-ов)");
		System.out.println("Выберите действие и нажмите соответствующую клавишу:");
		System.out.println("N - следующий уровень\nB - вернуться в меню");

		String symbol = scanner.nextLine().toUpperCase();

		switch (symbol) {
		case "B":
			Menu.goToMenu(player);
			break;
		case "N":
			Functions.clearingConsole();
			if (player.getCurrentLevel() == 1) {
				Labyrinth.level2(player);
			} else if (player.getCurrentLevel() == 2) {
				Labyrinth.level3(player);
			} else if (player.getCurrentLevel() == 3) {
				System.out.println("Уровень в разработке… \n(Для перехода в меню нажмите клавишу enter)");
				scanner.nextLine();
				Menu.goToMenu(player);
			}
			break;
		default:
            System.out.println("Некорректный ввод. Попробуйте снова.");
            exitMaze(player); 
            break;
		}
	}
}