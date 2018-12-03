package com.eomcs.lms.handler;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

	Scanner keyboard;
	List<Board> list;

	public BoardListCommand(Scanner keyboard) {
		this.keyboard = keyboard;
		this.list = list;
	}

	@Override
	public void execute() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs = null;
		try {
			//MariaDB JDBC 드라이버 구현체를 로딩
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			//DBMS에 연결하기
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select bno,cont,cdt,view,mno,lno from board");

			while(rs.next()) {
				System.out.printf("%3d,%-20s,%s,%d\n",rs.getInt("bno"),rs.getString("cont")
						,rs.getDate("cdt"),rs.getInt("view")
						);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {rs.close();}catch(Exception e){}
			try {stmt.close();}catch(Exception e){}
			try {con.close();}catch(Exception e){}
		}

	}

}
