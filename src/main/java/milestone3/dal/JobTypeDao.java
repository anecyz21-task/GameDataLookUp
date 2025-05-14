package milestone3.dal;

import milestone3.model.*;
import java.sql.*;

public class JobTypeDao {
  private JobTypeDao() {}

  public static JobType createJobType(Connection cxn, String jobName) throws SQLException {
    String sql = "INSERT INTO JobType(jobName) VALUES (?)";
    try (PreparedStatement ps = cxn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, jobName);
      ps.executeUpdate();
      return new JobType(Utils.getAutoIncrementKey(ps), jobName);
    }
  }

  public static JobType getJobTypeByID(Connection cxn, int jobID) throws SQLException {
    String sql = "SELECT * FROM JobType WHERE jobID = ?";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, jobID);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new JobType(
              rs.getInt("jobID"),
              rs.getString("jobName")
          );
        }
      }
    }
    return null;
  }
}