package com.microsoft.hackathon.copilotdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/* 
* Create a GET operation to return the value of a key passed as query parameter. 
* If the key is not passed, return "key not passed".
* If the key is passed, return "hello <key>".
* 
*/
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String getValue(@RequestParam(value = "key", required = false) String key) {
        if (key == null || key.isEmpty()) {
            return "key not passed";
        } else {
            return "hello " + key;
        }
    }

    @GetMapping("/countword")
    public Object countWord(@RequestParam(value = "path") String path) {
        try {
            Path p = Paths.get(path);
            if (!p.isAbsolute()) {
                p = Paths.get("").toAbsolutePath().resolve(path).normalize();
            }
            if (!Files.exists(p)) {
                return Map.of("error", "file not found", "path", path);
            }
            String content = Files.readString(p);
            int words = 0;
            if (!content.isBlank()) {
                String[] toks = content.trim().split("\\s+");
                words = toks.length;
            }
            return Map.of("path", path, "wordCount", words);
        } catch (Exception e) {
            return Map.of("error", e.getMessage());
        }
    }
}


