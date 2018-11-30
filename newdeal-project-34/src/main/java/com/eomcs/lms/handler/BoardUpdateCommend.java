package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;

public class BoardUpdateCommend implements Command{

	Scanner keyboard;
	List<Board> list;

	public BoardUpdateCommend(Scanner keyboard, List<Board> list) {
		this.keyboard = keyboard;
		this.list = list;
	}

	public void execute() {
	    System.out.print("번호? ");
	    int no = Integer.parseInt(keyboard.nextLine());

	    int index = indexOfBoard(no);
	    if (index == -1) {
	      System.out.println("해당 게시글을 찾을 수 없습니다.");
	      return;
	    }
	    
	    list.remove(index);
	    
	    System.out.println("게시글을 삭제했습니다.");
	  }
	private int indexOfBoard(int no) {
	    for (int i = 0; i < list.size(); i++) {
	      Board b = list.get(i);
	      if (b.getNo() == no)
	        return i;
	    }
	    return -1;
	  }
}
