import java.util.HashSet;

public class CD
{
	public static void main(String[] args) {
		Kattio scanner = new Kattio(System.in);
		while (true) {
			HashSet<Integer> cdJack = new HashSet<Integer>();
			int matches = 0;
			int amntJack = scanner.getInt();
			int amntJill = scanner.getInt();
			if (amntJack == 0 && amntJill == 0) {
				scanner.close();
				return;
			}
			for (int i = 0; i < amntJack; i++) {
				cdJack.add(scanner.getInt());
			}
			for (int i = 0; i < amntJill; i++) {
				if (cdJack.contains(scanner.getInt())) {
					matches++;
				}
			}
			System.out.println(matches);
		}
	}
}
