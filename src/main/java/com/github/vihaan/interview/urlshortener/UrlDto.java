package com.github.vihaan.interview.urlshortener;

public class UrlDto {
    private String url;

    public UrlDto (String url) {
        this.url = url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl () {
        return url;
    }
}
