package oving5;

public class Person2 implements Named {
  private String fullName;

  public Person2(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public void setGivenName(String givenName) {
    String[] names = fullName.split(" ");
    this.fullName = givenName + " " + names[1];
  }

  @Override
  public String getGivenName() {
    String[] names = fullName.split(" ");
    return names[0];
  }

  @Override
  public void setFamilyName(String familyName) {
    String[] names = fullName.split(" ");
    this.fullName = names[0] + " " + familyName;
  }

  @Override
  public String getFamilyName() {
    String[] names = fullName.split(" ");
    return names[1];
  }

  @Override
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public String getFullName() {
    return this.fullName;
  }
  
}
