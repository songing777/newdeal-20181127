package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);

		System.out.print("번호?");
		int no = Integer.parseInt(keyIn.nextLine());

		System.out.print("이름?");
		String name = keyIn.nextLine();
		System.out.print("이메일?");
		String email = keyIn.nextLine();
		System.out.print("암호?");
		String pass = keyIn.nextLine();
		System.out.print("사진?");
		String picture = keyIn.nextLine();
		System.out.print("전화?");
		String phone = keyIn.nextLine();
		Date today = new Date(System.currentTimeMillis());

		keyIn.close();

		System.out.println(); // 빈 줄 출력

		System.out.printf("번호: %d\n", no);
		System.out.printf("이름: %s\n", name);
		System.out.printf("이메일: %s\n", email);
		System.out.printf("암호: %s\n", pass);
		System.out.printf("사진: %s\n", picture);
		System.out.printf("전화: %s\n", phone);
		System.out.printf("가입일: %s\n", today);


	}

}
