package oving4;

import java.util.ArrayList;

public class Person {
  private String name;
  private char gender;
  private Person person;
  private ArrayList<Person> children;
  
  public Person(String name, char gender) {
    this.name = name;
    this.gender = gender;
    this.person = null;
    this.children = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public char getGender() {
    return this.gender;
  }

  public Person getMother() {
    if (this.person != null) {
      if (this.person.getGender() != 'F') {
        return null;
      }
    }
    
    return this.person;
  }
  
  public Person getFather() {
    if (this.person != null) {
      if (this.person.getGender() != 'M') {
        return null;
      }
    }
    return this.person;
  }

  public int getChildCount() {
    return this.children.size();
  }

  public Person getChild(int n) {
    if (this.children.isEmpty()) {
      throw new IllegalArgumentException("Ingen barn");
    }
    else if (n < 0 && n > this.children.size()) {
      throw new IllegalArgumentException("Finnes ikke n'te barn");
    }
    return this.children.get(n);
  }
  
  public void addChild(Person child) {
    this.children.add(child);
    if (child.person != null) {
      child.person.removeChild(child);
    }
    child.person = this;
  }

  public void removeChild(Person child) {
    this.children.remove(child);
    child.person = null;
  }
  
  public void setMother(Person foreldre) {
    if (foreldre.getGender() == 'M' || this == foreldre) {
      throw new IllegalArgumentException("Mor må være dame eller seg selv");
    }
    foreldre.children.add(this);
    if (this.person != null) {
      this.person.removeChild(this);
    }
    this.person = foreldre;
  }

  public void setFather(Person foreldre) {
    if (foreldre.getGender() == 'F' || this == foreldre) {
      throw new IllegalArgumentException("Far må være mann eller seg selv");
    }
    foreldre.children.add(this);
    if (this.person != null) {
      this.person.removeChild(this);
    }
    this.person = foreldre;
  }
  
  public static void main(String[] args) {
    Person anne = new Person("Anne", 'F');
		Person hallvard = new Person("Hallvard", 'M');
		Person jens = new Person("Jens", 'M');
    Person marit = new Person("Marit", 'F');
    
    jens.setFather(hallvard);
    anne.setFather(hallvard);

    System.out.println(jens.getFather().getName());
    System.out.println(anne.getFather().getName());
  }
}
