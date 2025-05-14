package milestone3.dal;

import milestone3.model.*;
import java.sql.*;


public class GearJobDao {
  private GearJobDao() {}

  public static GearJob createGearJob(Connection cxn, int gearID, int jobID) throws SQLException {
    String sql = "INSERT INTO GearJob(gearID, jobID) VALUES (?, ?)";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, gearID);
      ps.setInt(2, jobID);
      ps.executeUpdate();
      return new GearJob(gearID, jobID);
    }
  }

  public static GearJob getGearJobByID(Connection cxn, int gearID, int jobID) throws SQLException {
    String sql = "SELECT * FROM GearJob WHERE gearID = ? AND jobID = ?";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, gearID);
      ps.setInt(2, jobID);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new GearJob(
              rs.getInt("gearID"),
              rs.getInt("jobID")
          );
        }
      }
    }
    return null;
  }
}
