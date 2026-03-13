package com.macurexdashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macurexdashboard.common.CommonConstant;
import com.macurexdashboard.common.UserConstants;
import com.macurexdashboard.dto.ResponseDTO;
import com.macurexdashboard.service.MacurexDashboardService;

@RestController
@RequestMapping("/api/macurex")
public class MacurexDashboardController extends BaseController {
	public static final Logger LOGGER = LoggerFactory.getLogger(MacurexDashboardController.class);

	@Autowired
	MacurexDashboardService macurexDashboardService;

	@GetMapping("/getPurchaseDashboardDetails")
	public ResponseEntity<ResponseDTO> getPurchaseDashboardDetails(@RequestParam String formDate,
			@RequestParam String toDate, @RequestParam String under) {
		String methodName = "getPurchaseDashboardDetails()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<Map<String, Object>> mapp = new ArrayList<>();

		try {
			mapp = macurexDashboardService.getPurchaseDashboardDetails(formDate, toDate, under);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}

		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PurchaseDetails retrieved successfully");
			responseObjectsMap.put("purchaseDetailsVO", mapp);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Failed to retrieve PurchaseDetails",
					errorMsg);
		}

		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getMaintenanceDetails")
	public ResponseEntity<ResponseDTO> getMaintenanceDetails(@RequestParam String formDate,
			@RequestParam String toDate) {
		String methodName = "getMaintenanceDetails()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<Map<String, Object>> mapp = new ArrayList<>();

		try {
			mapp = macurexDashboardService.getMaintenanceDetails(formDate, toDate );
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}

		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "MaintenanceDetails retrieved successfully");
			responseObjectsMap.put("maintenanceDetailsVO", mapp);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Failed to retrieve MaintenanceDetails",
					errorMsg);
		}

		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
}
