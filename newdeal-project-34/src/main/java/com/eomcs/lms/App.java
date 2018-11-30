package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.BoardAddCommend;
import com.eomcs.lms.handler.BoardDeleteCommend;
import com.eomcs.lms.handler.BoardDetailCommend;
import com.eomcs.lms.handler.BoardListCommend;
import com.eomcs.lms.handler.BoardUpdateCommend;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  
  public static void main(String[] args) {
    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new LinkedList<>());
    ArrayList<Board> boards = new ArrayList<>();
   
    
    HashMap<String,Command> commandMap = new HashMap();
    commandMap.put("/board/list", new BoardListCommend(keyboard, boards));
    commandMap.put("/board/update", new BoardUpdateCommend(keyboard, boards));
    commandMap.put("/board/add", new BoardAddCommend(keyboard, boards));
    commandMap.put("/board/detail", new BoardDetailCommend(keyboard, boards));
    commandMap.put("/board/delete", new BoardDeleteCommend(keyboard, boards));
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      
      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();
      
      } else if (command.equals("/lesson/detail")) {
        lessonHandler.detailLesson();
      
      } else if (command.equals("/lesson/update")) {
        lessonHandler.updateLesson();
      
      } else if (command.equals("/lesson/delete")) {
        lessonHandler.deleteLesson();
      
      } else if (command.equals("/member/add")) {
        memberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        memberHandler.listMember();
        
      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();
      
      } else if (command.equals("/member/update")) {
        memberHandler.updateMember();
      
      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();
      
      } else if (command.equals("/board/add")) {
        boardHandler1.addBoard();
        
      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();
        
      } else if (command.equals("/board/detail")) {
        boardHandler1.detailBoard();
      
      } else if (command.equals("/board/update")) {
        boardHandler1.updateBoard();
      
      } else if (command.equals("/board/delete")) {
        boardHandler1.deleteBoard();
      
      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();
        
      } else if (command.equals("/board2/detail")) {
        boardHandler2.detailBoard();
      
      } else if (command.equals("/board2/update")) {
        boardHandler2.updateBoard();
      
      } else if (command.equals("/board2/delete")) {
        boardHandler2.deleteBoard();
      
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory();
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  
  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
