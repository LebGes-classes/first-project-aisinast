import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите ваше имя:");
		String name = scanner.nextLine();

		System.out.println("Добро пожаловать, " + name + "!\n(Для продолжения нажмите клавишу enter)");
		scanner.nextLine();

		Player player = new Player(name);

		Menu.goToMenu(player);
	}
}