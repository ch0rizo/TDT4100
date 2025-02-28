package oving5;

public class Person1 implements Named {
  private String givenName;
  private String familyName;

  public Person1(String givenName, String familyName) {
    this.givenName = givenName;
    this.familyName = familyName;
  }

  @Override
  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  @Override
  public String getGivenName() {
    return this.givenName;
  }

  @Override
  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  @Override
  public String getFamilyName() {
    return this.familyName;
  }

  @Override
  public void setFullName(String fullName) {
    String[] names = fullName.split(" ");
    this.givenName = names[0];
    this.familyName = names[1];
  }

  @Override
  public String getFullName() {
    return this.givenName + " " + this.familyName;
  }

}
