package com.example.mohir2.service;

import com.example.mohir2.entity.PostData;
import com.example.mohir2.model.Post;
import com.example.mohir2.repository.PostDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostDataService {
    public PostDataRepository postDataRepository;

    public PostDataService(PostDataRepository postDataRepository) {
        this.postDataRepository = postDataRepository;
    }

    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }
    public List<PostData> saveAll(Post[] posts){
        List<PostData> postDataList = new ArrayList<>();
        for (Post post:posts) {
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setBody(post.getBody());
            postData.setUserId(post.getUserId());
            postData.setTitle(postData.getTitle());
            postDataList.add(postData);
        }
        return postDataRepository.saveAll(postDataList);
    }

     @Transactional(readOnly = true)
    public Page<PostData> findAll(Pageable pageable){
        return  postDataRepository.findAll(pageable);
    }
}
