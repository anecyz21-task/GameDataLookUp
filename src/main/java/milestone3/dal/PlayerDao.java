package milestone3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import milestone3.model.Player;


public class PlayerDao {

	public PlayerDao() {
	}
	
	//Create Player
	public static Player create(
		Connection cxn,
		String email,
		String firstName,
		String lastName) 
		throws SQLException {
		final String insertPlayer = "INSERT INTO Player (email, firstName, lastName) VALUES (?, ?, ?)";
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertPlayer)){
			insertStmt.setString(1, email);
			insertStmt.setString(2, firstName);
			insertStmt.setString(3, lastName);
			insertStmt.executeUpdate();
			return new Player(email, firstName, lastName);
		}
	}
	
	//Get Player by email
	public static Player getPlayerByEmail(
		Connection cxn,
		String email) 
		throws SQLException {
		final String selectEmail = "SELECT * FROM Player WHERE email = ?;";
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectEmail)) {
			selectStmt.setString(1, email);
			try (ResultSet rs = selectStmt.executeQuery()) {
				if (rs.next()) {
					return new Player(
							rs.getString("email"),
							rs.getString("firstName"),
							rs.getString("lastName")
					);
				} else {
					return null;
				}
			}
		}
	}

	//Delete Player by email
	public static void deleteByEmail (Connection cxn, String email) throws SQLException {
        String deletePlayer = "DELETE FROM Player WHERE email = ?";
        try (PreparedStatement deleteStmt = cxn.prepareStatement(deletePlayer)) {
        	deleteStmt.setString(1, email);
        	deleteStmt.executeUpdate();
        }
    }

	//Get Players by partial match on first name
	public static List<Player> getPlayersByFirstNameLike(Connection cxn, String nameLike) throws SQLException {
		List<Player> players = new ArrayList<>();
		final String query = "SELECT * FROM Player WHERE firstName LIKE ?";
		try (PreparedStatement stmt = cxn.prepareStatement(query)) {
			stmt.setString(1, "%" + nameLike + "%");
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Player player = new Player(
							rs.getString("email"),
							rs.getString("firstName"),
							rs.getString("lastName")
					);
					players.add(player);
				}
			}
		}
		return players;
	}
	
	// Update Player's firstName and lastName
	public static Player update(Connection cxn, String email, String newFirstName, String newLastName) throws SQLException {
	    final String updatePlayer = "UPDATE Player SET firstName = ?, lastName = ? WHERE email = ?";
	    try (PreparedStatement updateStmt = cxn.prepareStatement(updatePlayer)) {
	        updateStmt.setString(1, newFirstName);
	        updateStmt.setString(2, newLastName);
	        updateStmt.setString(3, email);
	        int affectedRows = updateStmt.executeUpdate();
	        if (affectedRows == 0) {
                throw new SQLException("Updating player failed.");
            }
        }
        return new Player(email, newFirstName, newLastName);
    }
}
