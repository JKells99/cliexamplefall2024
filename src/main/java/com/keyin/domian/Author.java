package com.keyin.author;

import com.keyin.book.Book;
import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String authorName;



    public Author() {
    }

    public Author(Long authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }




}
