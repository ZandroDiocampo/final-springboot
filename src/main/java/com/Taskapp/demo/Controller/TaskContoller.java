package com.Taskapp.demo.Controller;


import com.Taskapp.demo.Entity.Task;
import com.Taskapp.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskContoller {

    @Autowired
    private TaskRepository taskreposit;

    @GetMapping("/")
    public String index(Model model){
        List<Task> tasks = taskreposit.findAll();
        model.addAttribute("tasks",tasks);
        return "index";
    }
    @GetMapping("/task/new")
    public String createTask(Model model){
        Task newtask = new Task();
        model.addAttribute("newtasks", newtask);
        return "create_task";
    }
    @PostMapping("/newsave")
    public String saveTask(@ModelAttribute("newtasks") Task newTask) {
        taskreposit.save(newTask);
        return "redirect:/";
    }
    @PostMapping("/myBooleanVariable")
    public String checklist(@ModelAttribute("newtasks") Task newTask) {
        taskreposit.save(newTask);
        return "redirect:/";
    }





}
