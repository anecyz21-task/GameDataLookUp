package milestone3.model;

import java.math.BigDecimal;
import java.util.Objects;

public class GearWeaponBonus {
    private int gearId;
    private BonusName bonusName;
    private BigDecimal bonusValue;

    public enum BonusName{
        Strength,
        Dexterity,
        Magic,
        Spirit,
        Vitality
    }

    public GearWeaponBonus(int gearId, BonusName bonusName, BigDecimal bonusValue) {
        this.gearId = gearId;
        this.bonusName = bonusName;
        this.bonusValue = bonusValue;
    }

    public int getGearId() {
        return gearId;
    }

    public void setGearId(int gearId) {
        this.gearId = gearId;
    }

    public BonusName getBonusName() {
        return bonusName;
    }

    public void setBonusName(BonusName bonusName) {
        this.bonusName = bonusName;
    }

    public BigDecimal getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(BigDecimal bonusValue) {
        this.bonusValue = bonusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GearWeaponBonus)) return false;
        GearWeaponBonus that = (GearWeaponBonus) o;
        return gearId == that.gearId &&
                Objects.equals(bonusName, that.bonusName) &&
                Objects.equals(bonusValue, that.bonusValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gearId, bonusName, bonusValue);
    }

    @Override
    public String toString() {
        return "GearWeaponBonus{" +
                "gearId=" + gearId +
                ", bonusName='" + bonusName + '\'' +
                ", bonusValue=" + bonusValue +
                '}';
    }
}
