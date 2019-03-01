package com.wsf.model;

public class TBook {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private Integer bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_no
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private String bookNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_name
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private String bookName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_author
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private String bookAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_num
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private Integer bookNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.book_status
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private Integer bookStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_book.cata_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    private Integer cataId;

    private String cataName;

    private Integer cataParent;

    public Integer getCataParent() {
        return cataParent;
    }

    public void setCataParent(Integer cataParent) {
        this.cataParent = cataParent;
    }

    public String getCataName() {
        return cataName;
    }


    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_id
     *
     * @return the value of t_book.book_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_id
     *
     * @param bookId the value for t_book.book_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_no
     *
     * @return the value of t_book.book_no
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public String getBookNo() {
        return bookNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_no
     *
     * @param bookNo the value for t_book.book_no
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_name
     *
     * @return the value of t_book.book_name
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_name
     *
     * @param bookName the value for t_book.book_name
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_author
     *
     * @return the value of t_book.book_author
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_author
     *
     * @param bookAuthor the value for t_book.book_author
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_num
     *
     * @return the value of t_book.book_num
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public Integer getBookNum() {
        return bookNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_num
     *
     * @param bookNum the value for t_book.book_num
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.book_status
     *
     * @return the value of t_book.book_status
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public Integer getBookStatus() {
        return bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.book_status
     *
     * @param bookStatus the value for t_book.book_status
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_book.cata_id
     *
     * @return the value of t_book.cata_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public Integer getCataId() {
        return cataId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_book.cata_id
     *
     * @param cataId the value for t_book.cata_id
     *
     * @mbggenerated Sat Feb 23 19:38:38 CST 2019
     */
    public void setCataId(Integer cataId) {
        this.cataId = cataId;
    }

    @Override
    public String toString() {
        return "TBook{" +
                "bookId=" + bookId +
                ", bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookNum=" + bookNum +
                ", bookStatus=" + bookStatus +
                ", cataId=" + cataId +
                ", cataName='" + cataName + '\'' +
                '}';
    }
}