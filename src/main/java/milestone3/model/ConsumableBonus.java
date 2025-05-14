package milestone3.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ConsumableBonus {
    private int consumableId;
    private BonusName bonusName;
    private BigDecimal percentage;
    private int cap;

    public enum BonusName{
        Strength,
        Dexterity,
        Magic,
        Spirit,
        Vitality
    }

    public ConsumableBonus(int consumableId, BonusName bonusName, BigDecimal percentage, int cap) {
        this.consumableId = consumableId;
        this.bonusName = bonusName;
        this.percentage = percentage;
        this.cap = cap;
    }

    public int getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(int consumableId) {
        this.consumableId = consumableId;
    }

    public BonusName getBonusName() {
        return bonusName;
    }

    public void setBonusName(BonusName bonusName) {
        this.bonusName = bonusName;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumableBonus)) return false;
        ConsumableBonus that = (ConsumableBonus) o;
        return consumableId == that.consumableId &&
                cap == that.cap &&
                Objects.equals(bonusName, that.bonusName) &&
                Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumableId, bonusName, percentage, cap);
    }

    @Override
    public String toString() {
        return "ConsumableBonus{" +
                "consumableId=" + consumableId +
                ", bonusName='" + bonusName + '\'' +
                ", percentage=" + percentage +
                ", cap=" + cap +
                '}';
    }
}
