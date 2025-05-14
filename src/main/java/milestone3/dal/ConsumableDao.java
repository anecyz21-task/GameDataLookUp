package milestone3.dal;

import milestone3.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumableDao {
	private ConsumableDao() {}
	
	public static Consumable create(Connection cxn, String itemName, int itemLevel, int itemMax, double itemPrice, String description) throws SQLException {
	    final String insertConsumable = 
    		"INSERT INTO Consumable (consumableId, description) VALUES (?, ?);";

  	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertConsumable)) {
						Item item = ItemDao.create(cxn, itemName, itemLevel, itemMax, itemPrice);
  	        insertStmt.setInt(1, item.getItemID());
  	        insertStmt.setString(2, description);
  	        insertStmt.executeUpdate();
  	        
  	        return new Consumable(item.getItemID(), itemName, itemLevel, itemMax, itemPrice, description);
  	    }    
	}
	
	public static Consumable getConsumableById(Connection cxn, int consumableId) throws SQLException {
	    String selectConsumable = """
			SELECT Item.itemName AS itemName, Item.itemLevel AS itemLevel, Item.itemMax AS itemMax, Item.itemPrice AS itemPrice, 
	    		Consumable.description AS description
			FROM Consumable INNER JOIN Item ON Consumable.consumableId = Item.itemId
			WHERE consumableId = ?""";
	    
	    try (PreparedStatement selectStmt = cxn.prepareStatement(selectConsumable)) {
	        selectStmt.setInt(1, consumableId);

	        try (ResultSet results = selectStmt.executeQuery()) {
	        	if (results.next()) {
	        		return new Consumable(
        				consumableId,
        				results.getString("itemName"),
        				results.getInt("itemLevel"),
        				results.getInt("itemMax"),
        				results.getDouble("itemPrice"),
        				results.getString("description")
    				);
	        	} else {
	        		return null;
	          }
	        }
	      }
	}
	
	public static Consumable updateDescription(Connection cxn, Consumable consumableItem, String newDescription) throws SQLException {
	    final String updateConsumable = "UPDATE Consumable SET description = ? WHERE consumableId = ?;";
	    
	    try (PreparedStatement updateStmt = cxn.prepareStatement(updateConsumable)) {
	        updateStmt.setString(1, newDescription);
	        updateStmt.setInt(2, consumableItem.getItemID());
	        updateStmt.executeUpdate();

	        consumableItem.setDescription(newDescription);
	        return consumableItem;
	      }
	}
}