package com.Taskapp.demo.Controller;


import com.Taskapp.demo.Entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class service {

    @Autowired
    private  TaskService postService;


    @GetMapping(value = "/task")
    public List<Task> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Task getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping(value = "/save")
    public Task createPost(@RequestBody Task post) {
        return postService.createPost(post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
    @PutMapping(value ="/update{id}")
    public Task updatePost(@PathVariable Long id,@RequestBody Task post){
        return postService.updatePost(id,post);
    }


}
