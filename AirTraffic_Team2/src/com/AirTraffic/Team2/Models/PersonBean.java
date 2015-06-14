/**
 * 
 */
package com.AirTraffic.Team2.Models;

import java.util.Date;

/**
 * @author JOY
 *
 */
public class PersonBean {
  private int person_id;
  private String person_fname;
  private String person_lname;
  private String person_gender;
  private String person_official_id;
  private String perosn_official_id_type;
  private Date person_dob;
  private String person_mobile;
  private String person_email;
  private String person_telephone;
  private LocationBean location_id;
  /**
   * @return the person_id
   */
  public int getPerson_id() {
    return person_id;
  }
  /**
   * @param person_id the person_id to set
   */
  public void setPerson_id(int person_id) {
    this.person_id = person_id;
  }
  /**
   * @return the person_fname
   */
  public String getPerson_fname() {
    return person_fname;
  }
  /**
   * @param person_fname the person_fname to set
   */
  public void setPerson_fname(String person_fname) {
    this.person_fname = person_fname;
  }
  /**
   * @return the person_lname
   */
  public String getPerson_lname() {
    return person_lname;
  }
  /**
   * @param person_lname the person_lname to set
   */
  public void setPerson_lname(String person_lname) {
    this.person_lname = person_lname;
  }
  /**
   * @return the person_gender
   */
  public String getPerson_gender() {
    return person_gender;
  }
  /**
   * @param person_gender the person_gender to set
   */
  public void setPerson_gender(String person_gender) {
    this.person_gender = person_gender;
  }
  /**
   * @return the person_official_id
   */
  public String getPerson_official_id() {
    return person_official_id;
  }
  /**
   * @param person_official_id the person_official_id to set
   */
  public void setPerson_official_id(String person_official_id) {
    this.person_official_id = person_official_id;
  }
  /**
   * @return the perosn_official_id_type
   */
  public String getPerosn_official_id_type() {
    return perosn_official_id_type;
  }
  /**
   * @param perosn_official_id_type the perosn_official_id_type to set
   */
  public void setPerosn_official_id_type(String perosn_official_id_type) {
    this.perosn_official_id_type = perosn_official_id_type;
  }
  /**
   * @return the person_dob
   */
  public Date getPerson_dob() {
    return person_dob;
  }
  /**
   * @param person_dob the person_dob to set
   */
  public void setPerson_dob(Date person_dob) {
    this.person_dob = person_dob;
  }
  /**
   * @return the person_mobile
   */
  public String getPerson_mobile() {
    return person_mobile;
  }
  /**
   * @param person_mobile the person_mobile to set
   */
  public void setPerson_mobile(String person_mobile) {
    this.person_mobile = person_mobile;
  }
  /**
   * @return the person_email
   */
  public String getPerson_email() {
    return person_email;
  }
  /**
   * @param person_email the person_email to set
   */
  public void setPerson_email(String person_email) {
    this.person_email = person_email;
  }
  /**
   * @return the person_telephone
   */
  public String getPerson_telephone() {
    return person_telephone;
  }
  /**
   * @param person_telephone the person_telephone to set
   */
  public void setPerson_telephone(String person_telephone) {
    this.person_telephone = person_telephone;
  }
  /**
   * @return the location_id
   */
  public LocationBean getLocation_id() {
    return location_id;
  }
  /**
   * @param location_id the location_id to set
   */
  public void setLocation_id(LocationBean location_id) {
    this.location_id = location_id;
  }
}
