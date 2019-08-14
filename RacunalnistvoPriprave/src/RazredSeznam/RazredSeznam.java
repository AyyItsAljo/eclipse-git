package RazredSeznam;

import java.util.*;

public class RazredSeznam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Vna�anje ne�tevila ali zapolnitev seznama spro�i kon�ni prikaz.");
		System.out.print("Velikost tabele: ");
		Seznam mojaTabela = new Seznam(scn.nextInt());
		while (scn.hasNextLine()) {
			try {
				System.out.print("Vrednost vnosa: ");
				mojaTabela.vnesi(scn.nextInt());
				System.out.println(mojaTabela);
			} catch (Exception ex) {
				break;
			}
		}
		scn.close();
		System.out.println(mojaTabela.koncniPrikaz());
	}
}

class Seznam {
	int[] tabelca;
	int fullness; // �e je seznam poln, ne moremo dodati nobenega elementa ve�. To omogo�a tudi
					// vna�anje ni�el

	public String toString() {
		String str = "";
		for (int i : tabelca)
			str += i + " ";
		str.trim();
		return str;
	}

	public String koncniPrikaz() { // koda za kon�en prikaz
		return "\r\n" + this + (this.fullness == this.tabelca.length ? "\r\n(Vne�enih preve� elementov.)"
				: "\r\n(Vne�enih " + (this.tabelca.length - this.fullness) + " elementov premalo.)");
	}

	public Seznam(int len) {
		tabelca = new int[len];
		fullness = 0;
	}

	public void vnesi(int vnos) {

		if (this.fullness == this.tabelca.length) {
			System.out.println("Napaka; poln seznam.");
			throw new IndexOutOfBoundsException(); // exception zaradi try stavka v 10. vrstici
		}

		this.fullness++;

		for (int i = 0; i < tabelca.length; i++) {
			if (tabelca[i] > vnos) {
				int temp = tabelca[i];
				tabelca[i] = vnos;
				vnos = temp;
			} else if (this.fullness - 1 == i) { // �e je ve�ja od vseh levih elementov, ga lahko postavi zadnjega v
													// vrsto.
				tabelca[i] = vnos;
				break;
			}
		}
	}
}