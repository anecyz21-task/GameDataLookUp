package milestone3.dal;

import milestone3.model.*;
import java.sql.*;

public class CurrenciesDao {
  private CurrenciesDao() {}

  public static Currencies create(Connection cxn, String currencyName, Integer cap, Integer weeklyCap) throws SQLException {
    String sql = "INSERT INTO Currencies(currencyName, cap, weeklyCap) VALUES (?, ?, ?)";
    try (PreparedStatement ps = cxn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, currencyName);
      if (cap != null) ps.setInt(2, cap); else ps.setNull(2, Types.INTEGER);
      if (weeklyCap != null) ps.setInt(3, weeklyCap); else ps.setNull(3, Types.INTEGER);
      ps.executeUpdate();
      return new Currencies(Utils.getAutoIncrementKey(ps), currencyName, cap, weeklyCap);
    }
  }

  public static Currencies getCurrencyByID(Connection cxn, int currencyID) throws SQLException {
    String sql = "SELECT * FROM Currencies WHERE currencyID = ?";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, currencyID);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new Currencies(
              rs.getInt("currencyID"),
              rs.getString("currencyName"),
              rs.getObject("cap", Integer.class),
              rs.getObject("weeklyCap", Integer.class)
          );
        }
      }
    }
    return null;
  }
}
