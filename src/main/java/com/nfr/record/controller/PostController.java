package com.nfr.record.controller;

import com.nfr.record.entity.Post;
import com.nfr.record.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create-new-post")
    private ResponseEntity<Post> createNewPost(@RequestBody Post post) {
        try {
            Post newPost = postService.createPost(post);
            return ResponseEntity.ok(newPost);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}