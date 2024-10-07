package com.test.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        for (Dashboard dashboard : dashboardRepository.findAll()) {
            System.out.println(dashboard.toString());
        }
        return dashboardRepository.findAll();
    }

    @GetMapping("/dashboards/{id}")
    public Dashboard getDashboardById(@PathVariable Long id) {
        return dashboardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dashboard not found with ID: " + id));
    }

    @PostMapping("/add")
    public String addDashboard(@RequestBody Dashboard board) {
        dashboardRepository.save(board);
        return "Board added: " + board.toString();
    }

    @PutMapping("/update")
    public String updateDashboard(@RequestBody Dashboard board) {
        Dashboard existingDashboard = dashboardRepository.findById(board.getId())
                .orElseThrow(() -> new RuntimeException("Dashboard not found with ID: " + board.getId()));
        if (board.getTitle() != null) {
            existingDashboard.setTitle(board.getTitle());
        }
        existingDashboard.setUpdatedAt(board.getUpdatedAt());
        dashboardRepository.save(existingDashboard);

        return "Board updated: " + existingDashboard.toString();
    }

}
