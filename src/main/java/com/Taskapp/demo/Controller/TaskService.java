package com.Taskapp.demo.Controller;

import com.Taskapp.demo.Entity.Task;
import com.Taskapp.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class TaskService {
    @Autowired
    private final TaskRepository postRepository;

    public TaskService(TaskRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Task> getAllPosts() {
        return postRepository.findAll();
    }

    public Task getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Task createPost(Task post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    public Task updatePost(Long id, Task post){
        Task existingTask = getPostById(id);
        existingTask.setTitle(post.getTitle());
        existingTask.setDescription(post.getDescription());
        existingTask.setCompleted(post.isCompleted());
      return  postRepository.save(existingTask);
    }


}
