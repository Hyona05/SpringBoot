package com.example.mohir2.web.rest;

import com.example.mohir2.entity.PostData;
import com.example.mohir2.model.Post;
import com.example.mohir2.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostResource {
    private  final PostService postService;
    public PostResource(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Post post){
        Post result = postService.save(post);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/posts/comments")
    public ResponseEntity update(@RequestBody Post post){
        Post result = postService.save(post);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/posts/params")
    public  ResponseEntity getAllByParam(@RequestParam Long postId){
        List<Post> result = postService.findAllByQueryParam(postId);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/posts/paging")
    public ResponseEntity getAllByPaging(Pageable pageable){
        Page<PostData> result = postService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/posts")
    public ResponseEntity getAll(){
        Object result = postService.findAll();
        return ResponseEntity.ok(result);
    }
}
