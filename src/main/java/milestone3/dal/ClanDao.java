package milestone3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import milestone3.model.Clan;
import milestone3.model.Clan.RaceName;

public class ClanDao {

	public ClanDao() {
	}
	
	//Insert Clan
	public static Clan create(
		Connection cxn,
		String clanName,
		RaceName raceName
		)throws SQLException {
		final String insertClan = "INSERT INTO Clan (clanName, raceName) VALUES (?, ?);";
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertClan)){
			insertStmt.setString(1, clanName);
			insertStmt.setString(2, raceName.name());	// Convert enum to String
			insertStmt.executeUpdate();
			return new Clan(clanName, raceName);
		}
	}
	
	//get by Clan name
	public static Clan getClanByName(Connection cxn, String clanName) throws SQLException {
		final String getByName = "SELECT * FROM Clan WHERE clanName = ?";
		try (PreparedStatement getStmt = cxn.prepareStatement(getByName)) {
			getStmt.setString(1, clanName);
			try (ResultSet rs = getStmt.executeQuery()) {
				if (rs.next()) {
					return new Clan(
							rs.getString("clanName"),
							RaceName.valueOf(rs.getString("raceName"))
					);
				} else {
					return null;
				}
			}
		}
	}
}
