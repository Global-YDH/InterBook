package backBook.demo.DAO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private long bookid;
    private int page;
    private String author;
//    private byte [] picture;
//    private String picture;
    private String story;
    private String title;
    private String publisher;
    private String theme;
    private int age;
    private int price;
    private String language;
    private String publication_date;


    public Book(long bookid, int page, String author, String story, String title, String publisher,String theme,int age, int price, String language,
                String publication_date){
        this.bookid = bookid;
        this.author = author;
        this.story = story;
        this.title = title;
        this.publisher = publisher;
        this.theme = theme;
        this.age = age;
        this.price = price;
        this.language = language;
        this.publication_date = publication_date;
    }

    public long getBookId() {
        return bookid;
    }

//    public byte [] getPicture() {
//        return picture;
//    }

    public int getPage() {
        return page;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookId(long bookid) {
        this.bookid = bookid;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStory() {
        return story;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPage(int page) {
        this.page = page;
    }

//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTheme(String theme){
        return theme;
    }
    public int getAge(int age){
        return age;
    }
    public int get(int price) {return price;}



    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }
}
