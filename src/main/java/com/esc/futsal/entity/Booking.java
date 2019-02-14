package com.esc.futsal.entity;

import javax.persistence.*;


@Entity
@Table(name = "tbl_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @Column(name = "booking_date")
    private String bookingDate;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

   @Column(name = "member_full_name")
    private String memberFullName;

   @Column(name = "username")
   private String username;

   @Column(name = "datetime")
   private String datetime;

   @Column(name ="approved")
   private Boolean approved;

   @Column(name = "played")
   private Boolean played;





    public Booking() {
    }

    public Booking(String bookingDate, String date, String time, String memberFullName, String username, String datetime, Boolean approved, Boolean played) {
        this.bookingDate = bookingDate;
        this.date = date;
        this.time = time;
        this.memberFullName = memberFullName;
        this.username = username;
        this.datetime = datetime;
        this.approved = approved;
        this.played = played;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getPlayed() {
        return played;
    }

    public void setPlayed(Boolean played) {
        this.played = played;
    }
}
