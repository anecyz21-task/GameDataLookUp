package milestone3.dal;

import milestone3.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GearDao {
	private GearDao() {}
	
	public static Gear create(Connection cxn, String itemName, int itemLevel, int itemMax, double itemPrice, int requiredLevel) throws SQLException {
	    final String insertGear = 
    		"INSERT INTO Gear (gearId, requiredLevel) VALUES (?, ?);";

	    Item item = ItemDao.create(cxn, itemName, itemLevel, itemMax, itemPrice);
	    
  	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertGear)) {
  	        insertStmt.setInt(1, item.getItemID());
  	        insertStmt.setInt(2, requiredLevel);
  	        insertStmt.executeUpdate();
  	        
  	        return new Gear(item.getItemID(), itemName, itemLevel, itemMax, itemPrice, requiredLevel);
  	    }
	}
	
	public static Gear getGearById(Connection cxn, int gearId) throws SQLException {
	    String selectGear = """
			SELECT Item.itemName AS itemName, Item.itemLevel AS itemLevel, Item.itemMax AS itemMax, Item.itemPrice AS itemPrice, 
	    		Gear.requiredLevel AS requiredLevel
			FROM Gear INNER JOIN Item ON Gear.gearId = Item.itemId
			WHERE gearId = ?""";
	    
	    try (PreparedStatement selectStmt = cxn.prepareStatement(selectGear)) {
	        selectStmt.setInt(1, gearId);

	        try (ResultSet results = selectStmt.executeQuery()) {
	        	if (results.next()) {
	        		return new Gear(
        				gearId,
        				results.getString("itemName"),
        				results.getInt("itemLevel"),
        				results.getInt("itemMax"),
        				results.getDouble("itemPrice"),
        				results.getInt("requiredLevel")
    				);
	        	} else {
	        		return null;
	          }
	        }
	      }
	}
	
	public static List<Gear> getGearByName(Connection cxn, String name) throws SQLException {
		List<Gear> gears = new ArrayList<>();
		
	    String selectGear = """
			SELECT Item.itemId AS itemId, Item.itemLevel AS itemLevel, Item.itemMax AS itemMax, Item.itemPrice AS itemPrice, 
	    		Gear.requiredLevel AS requiredLevel
			FROM Gear INNER JOIN Item ON Gear.gearId = Item.itemId
			WHERE Item.itemName = ?""";
	    
	    try (PreparedStatement selectStmt = cxn.prepareStatement(selectGear)) {
	    	selectStmt.setString(1, name);
	    	
	        try (ResultSet results = selectStmt.executeQuery()) {
	            while (results.next()) {
	            	gears.add(
	                new Gear(
	                  results.getInt("itemId"),
	                  name,
		              results.getInt("itemLevel"),
		              results.getInt("itemMax"),
		              results.getDouble("itemPrice"),
		              results.getInt("requiredLevel")
	                )
	              );
	            }
	            return gears;
	          }
	    }
	}
	
}