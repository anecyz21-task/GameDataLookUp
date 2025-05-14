package milestone3.dal;

import milestone3.model.*;
import java.sql.*;
import java.math.BigDecimal;
import milestone3.model.ConsumableBonus.BonusName;

public class ConsumableBonusDao {
    private ConsumableBonusDao() {}

    public static ConsumableBonus create(Connection cxn, int consumableId, BonusName bonusName, BigDecimal percentage, int cap) throws SQLException {
        String sql = "INSERT INTO ConsumableBonus(consumableId, bonusName, percentage, cap) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, consumableId);
            ps.setString(2, bonusName.name());
            ps.setBigDecimal(3, percentage);
            ps.setInt(4, cap);
            ps.executeUpdate();
            return new ConsumableBonus(consumableId, bonusName, percentage, cap);
        }
    }

    public static ConsumableBonus getConsumableBonusByPK(Connection cxn, int consumableId, BonusName bonusName) throws SQLException {
        String sql = "SELECT * FROM ConsumableBonus WHERE consumableId = ? AND bonusName = ?";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, consumableId);
            ps.setString(2, bonusName.name());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BigDecimal percentage = rs.getBigDecimal("percentage");
                    int cap = rs.getInt("cap");
                    return new ConsumableBonus(consumableId, bonusName, percentage, cap);
                }
            }
        }
        return null;
    }
}
