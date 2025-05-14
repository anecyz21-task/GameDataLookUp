package milestone3.dal;

import milestone3.model.*;
import java.sql.*;

public class CharacterJobDao {
  private CharacterJobDao() {}

  public static CharacterJob createCharacterJob(Connection cxn, int characterID, int jobID, int level, int xp, boolean unlock) throws SQLException {
    String sql = "INSERT INTO CharacterJob(characterID, jobID, `level`, xp, `unlock`) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, characterID);
      ps.setInt(2, jobID);
      ps.setInt(3, level);
      ps.setInt(4, xp);
      ps.setBoolean(5, unlock);
      ps.executeUpdate();
      return new CharacterJob(characterID, jobID, level, xp, unlock);
    }
  }

  public static CharacterJob getCharacterJobByID(Connection cxn, int characterID, int jobID) throws SQLException {
    String sql = "SELECT * FROM CharacterJob WHERE characterID = ? AND jobID = ?";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, characterID);
      ps.setInt(2, jobID);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new CharacterJob(
              rs.getInt("characterID"),
              rs.getInt("jobID"),
              rs.getInt("level"),
              rs.getInt("xp"),
              rs.getBoolean("unlock")
          );
        }
      }
    }
    return null;
  }
}