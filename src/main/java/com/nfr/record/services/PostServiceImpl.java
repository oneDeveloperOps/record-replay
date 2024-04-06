package com.nfr.record.services;

import com.nfr.record.entity.Post;
import com.nfr.record.interfaces.PostService;
import com.nfr.record.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) throws Exception {
        return postRepository.save(post);
    }
}
