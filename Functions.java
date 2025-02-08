public class Functions {
	public static void printArray(String[][] arr){
		int strCount = arr.length;
		int elementCount = arr[0].length;

		for (int i = 0; i < strCount; i++) {
			for (int j = 0; j < elementCount; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void clearingConsole() {
		try {
    		new ProcessBuilder("/bin/bash", "-c", "clear").inheritIO().start().waitFor();
		} catch (Exception E) {
    		System.out.println(E);
		}
	}
}