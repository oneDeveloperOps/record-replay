package com.nfr.record.controller;

import com.nfr.record.entity.Post;
import com.nfr.record.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create-new-post")
    private ResponseEntity<?> createNewPost(@RequestBody Post post) {
        try {
            HashMap<String, Object> responseObject = postService.createPost(post);
            return ResponseEntity.ok(responseObject);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(new HashMap<>().put("exception", ex.getMessage()));
        }
    }
}