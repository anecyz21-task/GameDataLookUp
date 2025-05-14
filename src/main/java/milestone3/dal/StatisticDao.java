package milestone3.dal;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import milestone3.model.Statistic;


public class StatisticDao {

	public StatisticDao() {
	}
	
	//set statistic
	public static Statistic create(
			Connection cxn,
			Statistic.StatisticName statisticName,
			int characterId,
			int value
	)throws SQLException {
		final String insertStatistic = "INSERT INTO Statistic (statisticName, characterId, value) VALUES (?, ?, ?);";
		try (PreparedStatement stmt = cxn.prepareStatement(insertStatistic)){
			stmt.setString(1, statisticName.name());
			stmt.setInt(2, characterId);
			stmt.setInt(3, value);
			stmt.executeUpdate();
			return new Statistic(statisticName, characterId, value);
		}
	}

	//get by statisticName and characterID
	public static Statistic getByNameAndCharacterId (
			Connection cxn,
			Statistic.StatisticName statisticName,
			int characterId
	)throws SQLException {
		final String getQuery = "SELECT * FROM Statistic WHERE statisticName = ? AND characterId = ?;";
		try (PreparedStatement stmt = cxn.prepareStatement(getQuery)){
			stmt.setString(1, statisticName.name());
			stmt.setInt(2, characterId);
			try (ResultSet rs = stmt.executeQuery()){
				if (rs.next()){
					return new Statistic(
							Statistic.StatisticName.valueOf(rs.getString("statisticName")),
							rs.getInt("characterId"),
							rs.getInt("value")
					);
				} else {
					return null;
				}
			}
		}
	}
	public static List<Statistic> getAllStatsForCharacter(Connection cxn, int characterId) throws SQLException {
		  List<Statistic> result = new ArrayList<>();
		  final String query = "SELECT * FROM Statistic WHERE characterId = ?";
		  try (PreparedStatement stmt = cxn.prepareStatement(query)) {
		    stmt.setInt(1, characterId);
		    try (ResultSet rs = stmt.executeQuery()) {
		      while (rs.next()) {
		        Statistic stat = new Statistic(
		          Statistic.StatisticName.valueOf(rs.getString("statisticName")),
		          rs.getInt("characterId"),
		          rs.getInt("value")
		        );
		        result.add(stat);
		      }
		    }
		  }
		  return result;
		}

}
