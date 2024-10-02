package com.test.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.interview.model.Dashboard;
import com.test.interview.repository.DashboardRepository;

@RestController
public class DashboardController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/dashboards")
    public List<Dashboard> getDashboards() {
        System.out.println("Fetching dashboards...");
        for (Dashboard dashboard : dashboardRepository.findAll()){
            System.out.println(dashboard.toString());
        }
        return dashboardRepository.findAll();
    }

    @PostMapping("/save")
    public String addDashboard(@RequestBody Dashboard board) { 
        dashboardRepository.save(board);        
        return "Saving: board: " + board.toString();
    }
}