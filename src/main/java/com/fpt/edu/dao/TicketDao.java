package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.MovieDetail;
import com.fpt.edu.entity.Refund;
import com.fpt.edu.entity.ShowTime;
import com.fpt.edu.entity.Ticket;
import com.fpt.edu.entity.TicketDashBoadTop;




public class TicketDao {
	public List<Ticket> findAll() {
		List<Ticket> listAll = new ArrayList<>();
		String query = "SELECT * FROM tickets";
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                int id = rs.getInt("id");
                int idMovieDetail = rs.getInt("idMovieDetail");
                int idShowTime = rs.getInt("idShowTime");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                Date dateStart = rs.getDate("dateStart");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Ticket obj = new Ticket(id,idMovieDetail,idShowTime,price,status,dateStart,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<TicketDashBoadTop> findAllTopMovieByCreate(String start, String end) {
		List<TicketDashBoadTop> listAll = new ArrayList<>();
		String query = String.format("SELECT movies.name, TopMovieDay.totalPrice\r\n"
				+ "FROM movies JOIN (SELECT movie_details.idMovie, SUM(tickets.price) AS totalPrice \r\n"
				+ "FROM `tickets` JOIN `movie_details` ON tickets.idMovieDetail = movie_details.id\r\n"
				+ "WHERE tickets.status = 2 OR tickets.status = 3 AND tickets.createdAt BETWEEN '%s 00:00:00' AND '%s 00:00:00'\r\n"
				+ "GROUP BY movie_details.idMovie\r\n"
				+ "ORDER BY totalPrice DESC) as TopMovieDay ON movies.id = TopMovieDay.idMovie\r\n"
				+ "ORDER BY TopMovieDay.totalPrice DESC",start,end);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                String name = rs.getString("name");
                int totalPrice = rs.getInt("totalPrice");
                TicketDashBoadTop obj = new TicketDashBoadTop(name,totalPrice);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<TicketDashBoadTop> findAllTopShowTime() {
		List<TicketDashBoadTop> listAll = new ArrayList<>();
		String query = String.format("SELECT showtimes.name, COUNT(tickets.idShowTime) as countShowTime\r\n"
				+ "FROM tickets JOIN showtimes ON tickets.idShowTime = showtimes.id\r\n"
				+ "WHERE tickets.status = 2\r\n"
				+ "GROUP BY tickets.idShowTime\r\n"
				+ "ORDER By tickets.idShowTime DESC ");
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                String name = rs.getString("name");
                int num = rs.getInt("countShowTime");
                TicketDashBoadTop obj = new TicketDashBoadTop(name,num);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public Ticket findById(int idTicket) {
		Ticket ticket = null;
		String query = String.format("SELECT * FROM `tickets` Where id = %d",idTicket);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				int id = rs.getInt("id");
                int idMovieDetail = rs.getInt("idMovieDetail");
                int idShowTime = rs.getInt("idShowTime");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                Date dateStart = rs.getDate("dateStart");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                ticket = new Ticket(id,idMovieDetail,idShowTime,price,status,dateStart,createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
	}
	
	public List<Ticket> findAllByIdMovie(int idMovie) {
		List<Ticket> ticketList = new ArrayList<>();
		
		String query = String.format("SELECT tickets.*\r\n"
				+ "FROM `tickets` JOIN `movie_details` ON tickets.idMovieDetail = movie_details.id\r\n"
				+ "JOIN movies ON movies.id = movie_details.idMovie\r\n"
				+ "WHERE movies.id = %d",idMovie);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				int id = rs.getInt("id");
                int idMovieDetail = rs.getInt("idMovieDetail");
                int idShowTime = rs.getInt("idShowTime");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                Date dateStart = rs.getDate("dateStart");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Ticket ticket = new Ticket(id,idMovieDetail,idShowTime,price,status,dateStart,createdAt);
                ticketList.add(ticket);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
	}
	
	public boolean refundTicket(int ticketId) {
		Ticket ticket = findById(ticketId);
		ShowTimeDao showTimeDao = new ShowTimeDao();
		ShowTime showTimeTicket = showTimeDao.findById(ticket.getIdShowTime());
		LocalDate localDateStart = LocalDate.parse(ticket.getDateStart().toString());
		LocalDateTime dateRefund = LocalDateTime.of(localDateStart,
				showTimeTicket.getStart_time().toLocalTime());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime dateTimeNow = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d1 = null;

		java.util.Date d2 = null;

        try {
        	d1 = formatDate.parse(dateRefund.format(format));
			d2 = formatDate.parse(dateTimeNow.format(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long diff = d1.getTime() - d2.getTime();
		long check = diff / (60 * 1000);
		int checkTime = (int) check;
		int idRefund = checkRefund(checkTime);
		if(idRefund==0) {
			try {
				throw new Exception("Error refund");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		RefundDao refundDao = new RefundDao();
		Refund refund = refundDao.findById(idRefund);
		double priceRefund = ticket.getPrice() - (ticket.getPrice() * refund.getPercent());
		double price = ticket.getPrice() - priceRefund;
		
		String query = String.format("update tickets set status = 3, price = %f, idRefund = %d where id = %d",price,idRefund ,ticketId);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			    
            if(preparedStatement.executeUpdate()>0) {
            	return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	
	public int checkRefund(int checkTime){
		int idRefund = 0;
        if (checkTime >=  48*60){
        	idRefund = 1;
            return idRefund;
        }
        if (checkTime >= 24*60){
        	idRefund = 2;
            return idRefund;
        }
        if (checkTime >= 12*60){
        	idRefund = 3;
            return idRefund;
        }
        if (checkTime >= 6){
        	idRefund = 4;
            return idRefund;
        }
        if (checkTime < 6){
        	idRefund = 5;
            return idRefund;
        }
        return idRefund;
    }
	
	public boolean buyTicket(int ticketId) {
		String query = String.format("update tickets set status = 2 where id = %d", ticketId);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			    
            if(preparedStatement.executeUpdate()>0) {
            	return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	
	public boolean save(int idRoom,int idMovie,Ticket obj) {
		String query1 = "INSERT INTO movie_details (idRoom,idMovie) VALUES (?,?)";
		String query2 = "INSERT INTO tickets (idMovieDetail,idShowTime,price,dateStart,createdAt) VALUES (?,?,?,?,?)";
		ShowTimeDao showTimeDao = new ShowTimeDao();
		double price = showTimeDao.findById(obj.getIdShowTime()).getPrice();
		try {
			Connection cnn = UserDao.getConnection();
            if (cnn == null){
                return false;
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idRoom);
            preparedStatement.setInt(2, idMovie);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idMovieDetail = 0;
            if (rs.next()){
                idMovieDetail = rs.getInt(1);
            }
            
			PreparedStatement preparedStatement2 = cnn.prepareStatement(query2);
            preparedStatement2.setInt(1, idMovieDetail);
            preparedStatement2.setInt(2, obj.getIdShowTime());
            preparedStatement2.setDouble(3, price);
            preparedStatement2.setDate(4, new Date(obj.getDateStart().getTime()));
            preparedStatement2.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			if(preparedStatement2.executeUpdate()>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
