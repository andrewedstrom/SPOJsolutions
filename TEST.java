import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		boolean meaningOfLife = false;
		int tmp;
		
		while(!meaningOfLife) {
			tmp = stdin.nextInt();
			if(tmp == 42) {
				meaningOfLife = true;
			}
			else {
				System.out.println(tmp);
			}
		}

		System.exit(0);
	}
}