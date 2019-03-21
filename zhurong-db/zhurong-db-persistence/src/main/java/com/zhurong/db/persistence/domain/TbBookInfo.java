package com.zhurong.db.persistence.domain;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class TbBookInfo {

    @NotNull(message = "id是主键不能为空啊")
    private String id;

    private String categoryCode;

    @NotNull(message = "{TbBookInfo.bookName.NotNull}")
    private String bookName;

    private String isbn;

    private String bookWriter;

    private String bookTranslator;

    private String bookPress;

    private Float bookPrice;

    private Date publishDate;

    private String coverPicPath;

    private String contentBrief;

    private String writerBrief;

    private String bookCatalog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter == null ? null : bookWriter.trim();
    }

    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator == null ? null : bookTranslator.trim();
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress == null ? null : bookPress.trim();
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverPicPath() {
        return coverPicPath;
    }

    public void setCoverPicPath(String coverPicPath) {
        this.coverPicPath = coverPicPath == null ? null : coverPicPath.trim();
    }

    public String getContentBrief() {
        return contentBrief;
    }

    public void setContentBrief(String contentBrief) {
        this.contentBrief = contentBrief == null ? null : contentBrief.trim();
    }

    public String getWriterBrief() {
        return writerBrief;
    }

    public void setWriterBrief(String writerBrief) {
        this.writerBrief = writerBrief == null ? null : writerBrief.trim();
    }

    public String getBookCatalog() {
        return bookCatalog;
    }

    public void setBookCatalog(String bookCatalog) {
        this.bookCatalog = bookCatalog == null ? null : bookCatalog.trim();
    }
}