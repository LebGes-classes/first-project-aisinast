import java.util.Scanner;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);

	public static void goToMenu(Player player) {
		Functions.clearingConsole();

		showMenu();

		while (true) {
			String letter = scanner.nextLine().toUpperCase();

			if (letter.equals("G")) {
				Functions.clearingConsole();
				Labyrinth.goToGame(player);
				break;
			} else if (letter.equals("I")) {
				Functions.clearingConsole();
				player.getInfo();
				backToMenu(player);
				break;
			} else if (letter.equals("E")) {
				Functions.clearingConsole();
				System.exit(0);
			} else if (letter.equals("R")) {
				Functions.clearingConsole();
				showRules();
				backToMenu(player);
				break;
			} else {
				System.out.println("Некорректный ввод. Введите G, I, R или Е");
			}
		}
	}

	private static void showMenu() {
		System.out.println("Выберите действие и нажмите соответствующую клавишу:");
		System.out.println("G - играть");
		System.out.println("I - посмотреть информацию об игроке");
		System.out.println("R - посмотреть правила игры");
		System.out.println("E - выйти из игры");
	}

	private static void showRules() {
		System.out.println("Правила игры:\n");
		System.out.println("1. Игрок управляет черепашкой с помощью стрелок или WASD\n");
		System.out.println("- W — вверх\n- A — влево\n- S — вниз\n- D — вправо\n");
		System.out.println("2. Цель — найти выход из лабиринта, собирая звездочки.\n");
		System.out.println("3. Собранные звездочки открывают новые уровни.\n");
		System.out.println("4. Игра заканчивается, если игрок достигает выхода.\n");
	}

	public static void backToMenu(Player player) {
		Labyrinth labyrinth = new Labyrinth();

		System.out.println("Чтобы вернуться, нажмите клавишу B");

		String symbol = scanner.nextLine().toUpperCase();
		if (symbol.equals("B")) {
			Functions.clearingConsole();
			goToMenu(player);
		} else {
			while (!symbol.equals("B")) {
				System.out.println("Нажмите клавишу B");
				symbol = scanner.nextLine().toUpperCase();
			}
			Functions.clearingConsole();
			goToMenu(player);
		}
	}
}