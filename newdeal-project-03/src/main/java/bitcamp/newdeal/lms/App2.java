package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);

		final int DEFAULT_SIZE = 20;
		int[] no = new int[DEFAULT_SIZE];
		String[] email = new String[DEFAULT_SIZE];
		String[] name = new String[DEFAULT_SIZE];
		String[] pass = new String[DEFAULT_SIZE];
		String[] picture = new String[DEFAULT_SIZE];
		String[] phone = new String[DEFAULT_SIZE];
		Date[] today = new Date[DEFAULT_SIZE];


		int len = 0;



		for(int i=0;i<DEFAULT_SIZE;i++) {
			System.out.print("번호?");
			no[i] = Integer.parseInt(keyIn.nextLine());

			System.out.print("이름?");
			name[i] = keyIn.nextLine();
			System.out.print("이메일?");
			email[i] = keyIn.nextLine();
			System.out.print("암호?");
			pass[i] = keyIn.nextLine();
			System.out.print("사진?");
			picture[i] = keyIn.nextLine();
			System.out.print("전화?");
			phone[i] = keyIn.nextLine();
			today[i] = new Date(System.currentTimeMillis());

			len++;

			System.out.print("계속하시겠습니까?(Y/n)");
			String input = keyIn.nextLine();
			if(input.equals("")||input.equalsIgnoreCase("y")) {
				continue;
			}
			break;
		}


		keyIn.close();


		System.out.println(); // 빈 줄 출력
		for(int i=0;i<len;i++) {

			System.out.printf("%d,%s,%s,%s,%s,%s,%s",no[i],name[i],email[i],pass[i],picture[i],phone[i],today[i]);

		}

	}

}
