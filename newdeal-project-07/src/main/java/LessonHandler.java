import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
	//이 클래스는 keyboard 객체가 있어야한다.
	//이 클래스의 메서드를 사용하기 전에 반드시 keyboard 객체를 꼽아줘야한다.
	static Scanner keyboard;
	static final int LENGTH = 10;
	static Lesson[] lessons = new Lesson[LENGTH];
	static int lessonIdx = 0;

	
	
	
	public static void listLesson() {
		for (int j = 0; j < lessonIdx; j++) {
			System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
					lessons[j].no, lessons[j].title, lessons[j].startDate, 
					lessons[j].endDate, lessons[j].totalHours);
		}
	}

	public static void addLesson() {
		Lesson lesson = new Lesson();

		System.out.print("번호? ");
		lesson.no = Integer.parseInt(keyboard.nextLine());

		System.out.print("수업명? ");
		lesson.title = keyboard.nextLine();

		System.out.print("설명? ");
		lesson.contents = keyboard.nextLine();

		System.out.print("시작일? ");
		lesson.startDate = Date.valueOf(keyboard.nextLine());

		System.out.print("종료일? ");
		lesson.endDate = Date.valueOf(keyboard.nextLine());

		System.out.print("총수업시간? ");
		lesson.totalHours = Integer.parseInt(keyboard.nextLine());

		System.out.print("일수업시간? ");
		lesson.dayHours = Integer.parseInt(keyboard.nextLine());

		// i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
		lessons[lessonIdx] = lesson;
		lessonIdx++;

		System.out.println("저장하였습니다.");
	}
}
