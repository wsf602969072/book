package com.wsf.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TBorrow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    private Integer borrowId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.stu_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    private Integer stuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.book_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    private Integer bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.start_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.end_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.isLose
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    private Integer islose;

    private String bookName;
    private String bookNo;
    private String stuName;
    private String stuNo;
    private String bookAuthor;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_id
     *
     * @return the value of t_borrow.borrow_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Integer getBorrowId() {
        return borrowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_id
     *
     * @param borrowId the value for t_borrow.borrow_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.stu_id
     *
     * @return the value of t_borrow.stu_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Integer getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.stu_id
     *
     * @param stuId the value for t_borrow.stu_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.book_id
     *
     * @return the value of t_borrow.book_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.book_id
     *
     * @param bookId the value for t_borrow.book_id
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.start_time
     *
     * @return the value of t_borrow.start_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.start_time
     *
     * @param startTime the value for t_borrow.start_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.end_time
     *
     * @return the value of t_borrow.end_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.end_time
     *
     * @param endTime the value for t_borrow.end_time
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.isLose
     *
     * @return the value of t_borrow.isLose
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public Integer getIslose() {
        return islose;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.isLose
     *
     * @param islose the value for t_borrow.isLose
     *
     * @mbggenerated Mon Feb 25 20:32:41 CST 2019
     */
    public void setIslose(Integer islose) {
        this.islose = islose;
    }

    @Override
    public String toString() {
        return "TBorrow{" +
                "borrowId=" + borrowId +
                ", stuId=" + stuId +
                ", bookId=" + bookId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", islose=" + islose +
                '}';
    }
}