package com.nfr.record.controller;

import com.google.gson.Gson;
import com.nfr.record.entity.Post;
import com.nfr.record.interfaces.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    static String extractPostRequestBody(HttpServletRequest request) {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = null;
            try {
                s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }

    @PostMapping("/create-new-post")
    private ResponseEntity<?> createNewPost(HttpServletRequest request) {
        try {
            Post post = new Gson().fromJson(extractPostRequestBody(request), Post.class);
            HashMap<String, Object> responseObject = postService.createPost(post);
            return ResponseEntity.ok(responseObject);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(new HashMap<>().put("exception", ex.getMessage()));
        }
    }
}

