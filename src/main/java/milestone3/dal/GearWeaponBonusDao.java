package milestone3.dal;

import milestone3.model.GearWeaponBonus;
import java.sql.*;
import java.math.BigDecimal;
import milestone3.model.GearWeaponBonus.BonusName;

public class GearWeaponBonusDao {
    private GearWeaponBonusDao() {}

    public static GearWeaponBonus create(Connection cxn, int gearId, BonusName bonusName, BigDecimal bonusValue) throws SQLException {
        String sql = "INSERT INTO GearWeaponBonus(gearId, bonusName, bonusValue) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, gearId);
            ps.setString(2, bonusName.name());
            ps.setBigDecimal(3, bonusValue);
            ps.executeUpdate();
            return new GearWeaponBonus(gearId, bonusName, bonusValue);
        }
    }

    public static GearWeaponBonus getGearWeaponBonusByPK(Connection cxn, int gearId, BonusName bonusName) throws SQLException {
        String sql = "SELECT * FROM GearWeaponBonus WHERE gearId = ? AND bonusName = ?";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, gearId);
            ps.setString(2, bonusName.name());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BigDecimal bonusValue = rs.getBigDecimal("bonusValue");
                    return new GearWeaponBonus(gearId, bonusName, bonusValue);
                }
            }
        }
        return null;
    }
}
