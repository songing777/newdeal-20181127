package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;

public class HelloCommand implements Command{
	Scanner keyboard;
	
	 public  HelloCommand(Scanner keyboard) {
		    this.keyboard = keyboard;
		  }
	 
	@Override
	public void execute() {
		// TODO Auto-generated method stub\
		System.out.print("이름은 ? ");
		String name = keyboard.nextLine();
		
		System.out.printf("%5s님 안녕하세요",name);
		
	}

}
