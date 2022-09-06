package com.fpt.edu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpt.edu.dao.TicketDao;

/**
 * Servlet implementation class TicketDashBoadTopMovie
 */
@WebServlet("/TicketDashBoadTopMovie")
public class TicketDashBoadTopMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDashBoadTopMovie() {
        super();
        // TODO Auto-generated constructor stub
        ticketDao = new TicketDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("Login");
			return;
		}	
		if(session.getAttribute("name") == null) {
			response.sendRedirect("Login");
			return;
		}
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		if(start == null || end == null) {
			request.getRequestDispatcher("TicketListTopMovieStartEnd.jsp").forward(request, response);
		} else {
			LocalDate startFormat = LocalDate.parse(start);
			LocalDate endFormat = LocalDate.parse(end);
			
			request.setAttribute("topMovies", ticketDao.findAllTopMovieByCreate(startFormat.toString(),endFormat.toString()));
			request.getRequestDispatcher("TicketListTop.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
