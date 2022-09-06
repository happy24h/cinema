package com.fpt.edu.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpt.edu.dao.TicketDao;

/**
 * Servlet implementation class TicketRefund
 */
@WebServlet("/TicketRefund")
public class TicketRefund extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketRefund() {
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
		if(ticketDao.refundTicket(id)) {
			response.sendRedirect("TicketList?idMovie="+idMovie);
		} else {
			response.getWriter().append("Có lỗi Refund ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

}
