package com.fpt.edu.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpt.edu.dao.MovieDao;
import com.fpt.edu.dao.TypeMovieDao;
import com.fpt.edu.entity.Movie;

/**
 * Servlet implementation class create
 */
@WebServlet("/MovieCreate")
public class MovieCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDao movieDao;
	TypeMovieDao typeMovieDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieCreate() {
        super();
        // TODO Auto-generated constructor stub
        movieDao = new MovieDao();
        typeMovieDao = new TypeMovieDao();
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
		request.setAttribute("typeMovies", typeMovieDao.findAll());
		request.getRequestDispatcher("MovieCreate.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		String name = request.getParameter("name");
		String link = request.getParameter("link");
		int year =  Integer.valueOf(request.getParameter("year"));
		int idTypeMovie = Integer.valueOf(request.getParameter("idTypeMovie"));
		String description = request.getParameter("description");

		LocalDateTime startTime =  LocalDateTime.parse(request.getParameter("startTime"));
		LocalDateTime endTime = LocalDateTime.parse(request.getParameter("endTime"));
		Movie movie = new Movie(name,link,year,idTypeMovie,description,startTime,endTime); 
		
		if(movieDao.save(movie)) {
			request.setAttribute("submitDone","done");
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);
		} else {
			response.getWriter().append("Create movie "+ name +" false: ");
		}
	}

}
