package com.company;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {

    Map<String, String> tinyURLMap = new HashMap<>();
    private final String tinyUrlPrefix = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = tinyUrlPrefix + longUrl.hashCode();
        tinyURLMap.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyURLMap.get(shortUrl);

    }

}
