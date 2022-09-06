package com.fpt.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpt.edu.dao.TicketDao;

/**
 * Servlet implementation class TicketList
 */
@WebServlet("/TicketList")
public class TicketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketList() {
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
		
		if(request.getParameter("idMovie") == null) {
			response.getWriter().append("Not Found Ticket ");
		}
		
		int idMovie = Integer.valueOf(request.getParameter("idMovie"));
		
		request.setAttribute("tickets", ticketDao.findAllByIdMovie(idMovie));
		request.getRequestDispatcher("TicketList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		if(session.getAttribute("name") == null || session.getAttribute("name").equals("")) {
			response.sendRedirect("Login");
		}
	}

}
