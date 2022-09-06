package com.fpt.edu.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpt.edu.dao.MovieDao;
import com.fpt.edu.dao.RoomDao;
import com.fpt.edu.dao.ShowTimeDao;
import com.fpt.edu.dao.TicketDao;
import com.fpt.edu.entity.Room;
import com.fpt.edu.entity.Ticket;

/**
 * Servlet implementation class TicketCreate
 */
@WebServlet("/TicketCreate")
public class TicketCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RoomDao roomDao;
    MovieDao movieDao;
    ShowTimeDao showTimeDao;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketCreate() {
        super();
        // TODO Auto-generated constructor stub
        roomDao= new RoomDao();
        movieDao = new MovieDao();
        showTimeDao = new ShowTimeDao();
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
		request.setAttribute("rooms", roomDao.findAllGroupByName());
		request.setAttribute("movies", movieDao.findAll());
		request.setAttribute("showtimes", showTimeDao.findAll());
		request.getRequestDispatcher("TicketCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		int idRoom = Integer.valueOf(request.getParameter("idRoom"));
		int idMovie = Integer.valueOf(request.getParameter("idMovie"));
		int idShowTime = Integer.valueOf(request.getParameter("idShowTime"));
		String startDateStr  = request.getParameter("dateStart");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate;
		try {
			startDate = sdf.parse(startDateStr);
			Ticket ticket = new Ticket(idShowTime,startDate);
			Room room = roomDao.findById(idRoom);
			for (int i = 0; i < room.getNum(); i++) {
				ticketDao.save(idRoom, idMovie, ticket);
			}
			response.sendRedirect("MovieList.jsp");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			response.getWriter().append("Create ticket false: ");
		}
	}

}
