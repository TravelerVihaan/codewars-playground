package com.github.vihaan.interview.urlshortener.storage;

import java.net.URL;

public interface UrlStorage {

    URL save(URL urlToSave);

    URL find(URL shortenedUrl);
}
