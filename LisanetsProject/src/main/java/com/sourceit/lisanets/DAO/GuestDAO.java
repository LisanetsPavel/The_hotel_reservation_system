package com.sourceit.lisanets.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.bean.Guest;
import com.sourceit.lisanets.exceptions.DataBaseExceprion;
import com.sourceit.lisanets.servlet.ServletController;

public class GuestDAO {

	private static final Logger logger = Logger.getLogger(GuestDAO.class);
	
	public List<Guest> getAll() {
		List<Guest> list = null;

		try (Connection c = ConnectionFactory.getConnection();
				Statement st = c.createStatement()) {

			ResultSet result = st.executeQuery("select * from Guest");
			list = new ArrayList<>();

			while (result.next()) {

				Guest g = new Guest();
				g.setIdGuest(result.getInt(1));
				g.setFirstName(result.getString(2));
				g.setLastName(result.getString(3));
				g.setPhone(result.getString(4));
				g.setEmail(result.getString(5));
				g.setPassword(result.getString(6));

				list.add(g);

			}

		} catch (SQLException e) {
			logger.error(e);
            throw new DataBaseExceprion(e);
		}
		return list;
	}

	public void add(Guest guest) throws SQLException {

		Connection c = ConnectionFactory.getConnection();
		java.sql.PreparedStatement st = c
				.prepareStatement("insert into Guest VALUES (?, ?,?,?, ?, ?) ");

		st.setInt(1, guest.getIdGuest());
		st.setString(2, guest.getFirstName());
		st.setString(3, guest.getLastName());
		st.setString(4, guest.getPhone());
		st.setString(5, guest.getEmail());
		st.setString(6, guest.getPassword());
		st.execute();
		c.close();
		st.close();
        logger.info("Guest is added " + guest.toString());
	}

	public void delete(int id) {

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("delete from guest where id_guest = ? ")) {

			st.setInt(1, id);
			st.execute();

		} catch (Exception e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}

	}

	public Guest getGuest(String email) {
		Guest guest = null;

		try (Connection c = ConnectionFactory.getConnection();
				java.sql.PreparedStatement st = c
						.prepareStatement("SELECT * FROM newhotel.guest where email = ? ")) {

			st.setString(1, email);
			ResultSet result = st.executeQuery();
			guest = new Guest();
			while (result.next()) {

				guest.setIdGuest(result.getInt(1));
				guest.setFirstName(result.getString(2));
				guest.setLastName(result.getString(3));
				guest.setPhone(result.getString(4));
				guest.setEmail(result.getString(5));
				guest.setPassword(result.getString(6));

			}

		} catch (SQLException e) {
			logger.error(e);
			 throw new DataBaseExceprion(e);
		}
		return guest;
	}

	
	
	
	
}
