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
 * Servlet implementation class TicketBuy
 */
@WebServlet("/TicketBuy")
public class TicketBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketBuy() {
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
		int id = Integer.valueOf(request.getParameter("id"));
		int idMovie = Integer.valueOf(request.getParameter("idMovie"));
		
		if(ticketDao.buyTicket(id)) {
			response.sendRedirect("TicketList?idMovie="+idMovie);
			
			
//			
//			request.setAttribute("tickets", ticketDao.findAllByIdMovie(idMovie));
//			request.getRequestDispatcher("TicketList.jsp").forward(request, response);
		}
		
		response.getWriter().append("Có lỗi mua");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
