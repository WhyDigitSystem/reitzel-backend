package com.macurexdashboard.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macurexdashboard.repo.EInvoiceRepo;

@Service
public class MacurexDashboardServiceImpl implements MacurexDashboardService {

	@Autowired
	EInvoiceRepo eInvoiceRepo;

	@Override
	public List<Map<String, Object>> getPurchaseDashboardDetails(String formDate,String toDate,String under) {
		Set<Object[]> chCode = eInvoiceRepo.getPurchaseDashboardDetails( formDate, toDate, under);
		return getPurchaseDashboardDetails(chCode);
	}

	private List<Map<String, Object>> getPurchaseDashboardDetails(Set<Object[]> chCode) {
		List<Map<String, Object>> List1 = new ArrayList<>();
		for (Object[] ch : chCode) {
			Map<String, Object> map = new HashMap<>();
			map.put("purchaseName", ch[0] != null ? ch[0].toString() : ""); 
			map.put("type", ch[1] != null ? ch[1].toString() : "");
			map.put("value", ch[2] != null ? new BigDecimal(ch[2].toString()) : BigDecimal.ZERO);
			List1.add(map);
		}
		return List1;

	}
	
	@Override
	public List<Map<String, Object>> getMaintenanceDetails(String formDate,String toDate) {
		Set<Object[]> chCode = eInvoiceRepo.getMaintenanceDetails( formDate, toDate);
		return getMaintenanceDetails(chCode);
	}

	private List<Map<String, Object>> getMaintenanceDetails(Set<Object[]> chCode) {
		List<Map<String, Object>> List1 = new ArrayList<>();
		for (Object[] ch : chCode) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", ch[0] != null ? ch[0].toString() : ""); 
			map.put("noOfBreakDown", ch[1] != null ? new BigDecimal(ch[1].toString()) : BigDecimal.ZERO);
			map.put("open", ch[2] != null ? new BigDecimal(ch[2].toString()) : BigDecimal.ZERO);
			map.put("close", ch[3] != null ? new BigDecimal(ch[3].toString()) : BigDecimal.ZERO);
			List1.add(map);
		}
		return List1;

	}
}
