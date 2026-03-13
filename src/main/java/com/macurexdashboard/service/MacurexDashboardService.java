package com.macurexdashboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MacurexDashboardService {

	List<Map<String, Object>> getPurchaseDashboardDetails(String formDate, String toDate, String under);

	List<Map<String, Object>> getMaintenanceDetails(String formDate, String toDate);

}
