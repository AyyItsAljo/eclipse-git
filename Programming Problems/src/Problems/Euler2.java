package Problems;

public class Euler2 {
	public static void main(String[] args) {
		int sum=0;
		int lasti=1;
		for(int i = 1;i<4000000;lasti=i-lasti) { //ta zanka se�teva soda �tevila Fibona�ijevega zaporedja do �tevila
			i += lasti;
			if(i%2 == 0) sum+=i;
		}
		System.out.println(sum);//4613732

	}
}
