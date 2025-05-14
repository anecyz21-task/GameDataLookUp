package milestone3.model;

import java.util.Objects;

public class CharacterCurrencies {
  private int characterID;
  private int currencyID;
  private int amountOwned;
  private int amountAcquiredWeekly;

  public CharacterCurrencies(int characterID, int currencyID, int amountOwned, int amountAcquiredWeekly) {
    this.characterID = characterID;
    this.currencyID = currencyID;
    this.amountOwned = amountOwned;
    this.amountAcquiredWeekly = amountAcquiredWeekly;
  }

  public int getCharacterID() {
    return characterID;
  }

  public void setCharacterID(int characterID) {
    this.characterID = characterID;
  }

  public int getCurrencyID() {
    return currencyID;
  }

  public void setCurrencyID(int currencyID) {
    this.currencyID = currencyID;
  }

  public int getAmountOwned() {
    return amountOwned;
  }

  public void setAmountOwned(int amountOwned) {
    this.amountOwned = amountOwned;
  }

  public int getAmountAcquiredWeekly() {
    return amountAcquiredWeekly;
  }

  public void setAmountAcquiredWeekly(int amountAcquiredWeekly) {
    this.amountAcquiredWeekly = amountAcquiredWeekly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacterCurrencies that = (CharacterCurrencies) o;
    return characterID == that.characterID && currencyID == that.currencyID && amountOwned == that.amountOwned
        && amountAcquiredWeekly == that.amountAcquiredWeekly;
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterID, currencyID, amountOwned, amountAcquiredWeekly);
  }

  @Override
  public String toString() {
    return "CharacterCurrencies{" +
        "characterID=" + characterID +
        ", currencyID=" + currencyID +
        ", amountOwned=" + amountOwned +
        ", amountAcquiredWeekly=" + amountAcquiredWeekly +
        '}';
  }
}

