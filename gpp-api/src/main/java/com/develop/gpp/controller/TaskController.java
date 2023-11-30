package com.develop.gpp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.gpp.domain.entity.Task;
import com.develop.gpp.domain.entity.dto.TaskDTO;
import com.develop.gpp.domain.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
public class TaskController {
    
	@Autowired
    private  TaskService service;

    @GetMapping
    public List<Task> findAll(HttpServletRequest request) {
        return service.findAll(request);
    }

    @PostMapping
    public Task save(HttpServletRequest request, @RequestBody TaskDTO dto) {
        return service.save(request, dto);
    }

    @PutMapping("{id}")
    public Task updateStatus(HttpServletRequest request, @PathVariable Long id) {
        return service.updateTask(request, id);
    }
}
