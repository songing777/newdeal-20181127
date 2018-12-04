package com.eomcs.lms.handler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    
    Connection con=null;
	Statement stmt=null;
	ResultSet rs = null;
	try {
		  
		
		System.out.print("내용? ");
		String content = keyboard.nextLine(); 
		
		System.out.print("작성자번호? ");
		String writeNo = keyboard.nextLine();
		System.out.print("수업번호? ");
		
		String keyboard.nextLine();
		System.out.print("번호? ");
		int no = Integer.parseInt(keyboard.nextLine());
		//MariaDB JDBC 드라이버 구현체를 로딩
		//DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		//DBMS에 연결하기
		con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
		stmt = con.createStatement();
		stmt.executeUpdate("insert into board(cont,mno,lno)"
		+" values('"+board.getContents()+"',"
		+ board.getWriterNo()+","
		+ board.getLessonNo()+ "");

		if(rs.next()) {
			System.out.printf("번호 : %d\n",rs.getInt("bno"));
			System.out.printf("내용 : %s\n",rs.getString("cont"));
			System.out.printf("작성일 : %s\n",rs.getString("cdt"));
			System.out.printf("조회수 : %d\n",rs.getInt("view"));
			System.out.printf("작성자 : %d\n",rs.getInt("mno"));
			System.out.printf("수업 : %d\n",rs.getInt("lno"));
			
		}else {System.out.println("해당 번호의 게시물이 없습니다!");}

	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {rs.close();}catch(Exception e){e.printStackTrace();}
		try {stmt.close();}catch(Exception e){e.printStackTrace();}
		try {con.close();}catch(Exception e){e.printStackTrace();}
	}
    
   
  }
}
