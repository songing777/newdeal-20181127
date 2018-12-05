package com.eomcs.lms.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
// 서블릿을 만들었으면 톰켓서버에 알려줘야한다.
// 서블릿에 URL을 부여한다.
// URL은 항상 루트'/'로 시작한다.
// 서블릿을 추가했으면 톰캣서버를 재시작해야 시작할 수 있다.
// 한번 톰캣 서버에 서블릿을 추가한 후 서블릿을 변경한다면 
// 일정 시간이 지난 후에 자동으로 해당 서블릿을 재적재한다.
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApplicationContext iocContainer;
	BoardDao boardDao;
	@Override
	public void init() throws ServletException {
		// 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 바로 호출된다.
		// 원래는 ServletConfig init가 먼저 호출되고,
		// ServletConfig init가 이 init를 호출한다.
		ServletContext sc = this.getServletContext();
		iocContainer =  (ApplicationContext)sc.getAttribute("iocContainer");
		try{
			boardDao = iocContainer.getBean(BoardDao.class);
		}catch(Exception e){e.printStackTrace();}
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		

		
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("게시물 목록(강사)");
		
		
		try {
			BoardDao boardDao = iocContainer.getBean(BoardDao.class);
			List<Board> list = boardDao.findAll();

			for (Board board : list) {
				out.printf("%3d, %-20s, %s, %d\n", 
						board.getNo(), 
						board.getContents(), 
						board.getCreatedDate(), 
						board.getViewCount());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
