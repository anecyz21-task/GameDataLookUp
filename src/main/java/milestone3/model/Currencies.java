package milestone3.model;

import java.util.Objects;

public class Currencies {
  private int currencyID;
  private String currencyName;
  private Integer cap;
  private Integer weeklyCap;

  public Currencies(int currencyID, String currencyName, Integer cap, Integer weeklyCap) {
    this.currencyID = currencyID;
    this.currencyName = currencyName;
    this.cap = cap;
    this.weeklyCap = weeklyCap;


  }


  public int getCurrencyID() {
    return currencyID;
  }

  public void setCurrencyID(int currencyID) {
    this.currencyID = currencyID;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public Integer getCap() {
    return cap;
  }

  public void setCap(Integer cap) {
    this.cap = cap;
  }

  public Integer getWeeklyCap() {
    return weeklyCap;
  }

  public void setWeeklyCap(Integer weeklyCap) {
    this.weeklyCap = weeklyCap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Currencies that = (Currencies) o;
    return currencyID == that.currencyID && Objects.equals(currencyName, that.currencyName)
        && Objects.equals(cap, that.cap) && Objects.equals(weeklyCap, that.weeklyCap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyID, currencyName, cap, weeklyCap);
  }

  @Override
  public String toString() {
    return "Currencies{" +
        "currencyID=" + currencyID +
        ", currencyName='" + currencyName + '\'' +
        ", cap=" + cap +
        ", weeklyCap=" + weeklyCap +
        '}';
  }
}



