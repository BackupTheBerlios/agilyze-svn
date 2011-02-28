package edu.umich.umms.profile.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String roleLevel;

  private Integer version;

  public Person() {

  }

  public Person(String firstName, String lastName, String username,
      String password, String roleLevel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.roleLevel = roleLevel;
  }

  @XmlTransient
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
	return getLastName() + ", " + getFirstName();
}

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRoleLevel() {
    return roleLevel;
  }

  public void setRoleLevel(String roleLevel) {
    this.roleLevel = roleLevel;
  }

  @Version
  public Integer getVersion() {
    System.out.println("getting version " + getLastName());
    return version == null ? 1 : version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public enum RoleLevel {
    ADMIN(1), GUEST(2), PUBLIC(3);
    private final int level;

    RoleLevel(int value) {
      this.level = value;
    }

    public static RoleLevel getLevel(String roleName) {
      return RoleLevel.valueOf(roleName);
    }

    public int getLevel() {
      return this.level;
    }
  }

}