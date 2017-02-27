package models.pojo;


public class Users {

  private int id;
  private String user_name;
  private String password;
  private String email;
  private String lastName;
  private String firstName;
  private String middleName;
  private Boolean isActive;
  private int roleId;
  private String phone;
  private String address;

  public Users(int id, String user_name, String password, String email,
               String lastName, String firstName,
               String middleName, int roleId, Boolean isActive, String phone, String address) {
    this.id = id;
    this.user_name = user_name;
    this.password = password;
    this.email = email;
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.roleId = roleId;
    this.isActive = isActive;
    this.phone = phone;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUserName() {
    return user_name;
  }

  public void setUserName(String user_name) {
    this.user_name = user_name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }


  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }


  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
