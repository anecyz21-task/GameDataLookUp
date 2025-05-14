package milestone3.model;

import java.util.Objects;

public class BodySlot {
    private int characterId;
    private PositionName positionName;
    private int itemID;

    public enum PositionName {
        Head, Feet, Arm, MainHand, RightHand, LeftHand
    }

    public BodySlot(int characterId, PositionName positionName, Integer itemID) {
        this.characterId = characterId;
        this.positionName = positionName;
        this.itemID = itemID;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BodySlot)) return false;
        BodySlot bodySlot = (BodySlot) o;
        return characterId == bodySlot.characterId &&
                Objects.equals(positionName, bodySlot.positionName) &&
                Objects.equals(itemID, bodySlot.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, positionName, itemID);
    }

    @Override
    public String toString() {
        return "BodySlot{" +
                "characterId=" + characterId +
                ", positionName='" + positionName + '\'' +
                ", itemID=" + itemID +
                '}';
    }
}
