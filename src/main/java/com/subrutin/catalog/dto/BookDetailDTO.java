package com.subrutin.catalog.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long bookId;

    private String authorName;

    private String bookTitle;

    private String bookDescription;

}
