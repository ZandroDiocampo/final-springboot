package com.Taskapp.demo.Repository;

import com.Taskapp.demo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
