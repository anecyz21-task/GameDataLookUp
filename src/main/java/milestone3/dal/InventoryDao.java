package milestone3.dal;

import milestone3.model.Inventory;
import java.sql.*;

public class InventoryDao {
    private InventoryDao() {}

    public static Inventory create(Connection cxn, int characterId, int slotId, Integer itemId, int quantity) throws SQLException {
        String sql = "INSERT INTO Inventory(characterId, slotId, itemId, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, characterId);
            ps.setInt(2, slotId);
            if (itemId != null) {
                ps.setInt(3, itemId);
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setInt(4, quantity);
            ps.executeUpdate();
            return new Inventory(characterId, slotId, itemId, quantity);
        }
    }

    public static Inventory getInventoryByPK(Connection cxn, int characterId, int slotId) throws SQLException {
        String sql = "SELECT * FROM Inventory WHERE characterId = ? AND slotId = ?";
        try (PreparedStatement ps = cxn.prepareStatement(sql)) {
            ps.setInt(1, characterId);
            ps.setInt(2, slotId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Integer itemId = rs.getObject("itemId", Integer.class);
                    int quantity = rs.getInt("quantity");
                    return new Inventory(characterId, slotId, itemId, quantity);
                }
            }
        }
        return null;
    }
}
