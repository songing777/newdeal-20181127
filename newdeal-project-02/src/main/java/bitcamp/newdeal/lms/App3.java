package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

	public static void main(String[] args) {

		Scanner keyIn = new Scanner(System.in);

		final int DEFAULT_SIZE = 20;
		int[] no = new int[DEFAULT_SIZE];
		int[] viewCount = new int[DEFAULT_SIZE];
		String[] contents = new String[DEFAULT_SIZE];
		Date[] today = new Date[DEFAULT_SIZE];


		int len = 0;

		for(int i=0;i<DEFAULT_SIZE;i++) {
			System.out.print("번호?");
			no[i] = Integer.parseInt(keyIn.nextLine());

			System.out.print("내용?");
			contents[i] = keyIn.nextLine();

			today[i] = new Date(System.currentTimeMillis());

			keyIn.close();

			viewCount[i] = 0;

			System.out.print("계속하시겠습니까?(Y/n)");
			String input = keyIn.nextLine();
			if(input.equals("")||input.equalsIgnoreCase("y")) {
				continue;
			}
			break;

		}

		keyIn.close();


		System.out.println();

		for(int i=0;i<len;i++) {
			System.out.printf("%d,%s,%s,%d",no[i],contents[i],today[i],viewCount[i]);

		}


	}

}
