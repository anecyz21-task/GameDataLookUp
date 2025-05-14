package milestone3.dal;

import milestone3.model.*;
import java.sql.*;


public class CharacterCurrenciesDao {
  private CharacterCurrenciesDao() {}

  public static CharacterCurrencies createCharacterCurrencies(Connection cxn, int characterID, int currencyID, int amountOwned, int amountAcquiredWeekly) throws SQLException {
    String sql = "INSERT INTO CharacterCurrencies(characterID, currencyID, amountOwned, amountAcquiredWeekly) VALUES (?, ?, ?, ?)";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, characterID);
      ps.setInt(2, currencyID);
      ps.setInt(3, amountOwned);
      ps.setInt(4, amountAcquiredWeekly);
      ps.executeUpdate();
      return new CharacterCurrencies(characterID, currencyID, amountOwned, amountAcquiredWeekly);
    }
  }

  public static CharacterCurrencies getCharacterCurrenciesByID(Connection cxn, int characterID, int currencyID) throws SQLException {
    String sql = "SELECT * FROM CharacterCurrencies WHERE characterID = ? AND currencyID = ?";
    try (PreparedStatement ps = cxn.prepareStatement(sql)) {
      ps.setInt(1, characterID);
      ps.setInt(2, currencyID);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new CharacterCurrencies(
              rs.getInt("characterID"),
              rs.getInt("currencyID"),
              rs.getInt("amountOwned"),
              rs.getInt("amountAcquiredWeekly")
          );
        }
      }
    }
    return null;
  }
}