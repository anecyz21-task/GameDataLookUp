package milestone3.dal;

import milestone3.model.*;
import java.sql.*;
import milestone3.model.BodySlot.PositionName;

public class BodySlotDao {
    private BodySlotDao() {}

    public static BodySlot create(Connection cxn, int characterId, PositionName positionName, Integer itemID) throws SQLException {
        String sql = "INSERT INTO BodySlot(characterId, positionName, itemID) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, characterId);
            ps.setString(2, positionName.name());
            if (itemID != null) {
                ps.setInt(3, itemID);
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.executeUpdate();
            return new BodySlot(characterId, positionName, itemID);
        }
    }

    public static BodySlot getBodySlotByPK(Connection cxn, int characterId, PositionName positionName) throws SQLException {
        String sql = "SELECT * FROM BodySlot WHERE characterId = ? AND positionName = ?";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, characterId);
            ps.setString(2, positionName.name());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int itemID = rs.getInt("itemID");
                    return new BodySlot(characterId, positionName, itemID);
                }
            }
        }
        return null;
    }
}
