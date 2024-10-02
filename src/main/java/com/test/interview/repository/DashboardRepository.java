package com.test.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.interview.model.Dashboard;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {}