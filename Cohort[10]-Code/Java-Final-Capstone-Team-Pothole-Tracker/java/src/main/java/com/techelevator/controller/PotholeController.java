package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.SessionAuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDao;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

@Controller
public class PotholeController {
	
	@Autowired PotholeDao potholeDao;
	
	@Autowired UserDao userDao;
	
	@Autowired AuthProvider auth;
	
	@RequestMapping(method=RequestMethod.GET,  path={"/potholes"} )
	public String displayPotholes(HttpServletRequest request) {
		request.setAttribute("inspectedReported", potholeDao.getAllPotholesInspectedReported());
		return "potholes";
		}
	
	@RequestMapping(method=RequestMethod.GET,  path={"/repairedpotholes"} )
	public String displayRepairedPotholes(HttpServletRequest request) {
		request.setAttribute("repaired", potholeDao.getAllPotholesRepaired());
		return "repairedpotholes";
		}
	
	
	@RequestMapping(method=RequestMethod.GET,  path={"/empPotholes"} )
	public String displayEmpPotholes(HttpServletRequest request, ModelMap reportMap) {
		if(auth.userHasRole(new String[]{"employee"})) {
			if(!reportMap.containsAttribute("Pothole")) {
				reportMap.addAttribute("Pothole", new Pothole());
			}
			request.setAttribute("aPothole", potholeDao.getAllPotholes());
			return "empPotholes";
		} else {
		return "forbidden";
		}
	}
	
	@RequestMapping(path="/empPotholes", method=RequestMethod.POST)
	public String updateReportedPothole(@Valid @ModelAttribute("Pothole") Pothole potholeValues,
									  BindingResult result, RedirectAttributes flash, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Pothole", result);
			flash.addFlashAttribute("Pothole", potholeValues);
			return "redirect:/map";

		}
		Pothole temp = new Pothole();
		
		temp.setFormValue(potholeValues.getFormValue());
		
		
		temp.setPotholeId(potholeValues.getPotholeId());
		temp.setRepairStatus(potholeValues.getRepairStatus());
		temp.setSeverity(potholeValues.getSeverity());
		
		if(temp.getFormValue().equalsIgnoreCase("update")) {
		potholeDao.updateRepairStatus(temp);
		potholeDao.updatePotholeSeverity(temp);
		} else if(temp.getFormValue().equalsIgnoreCase("repaired")) {
			potholeDao.updateRepairStatus(temp);
			potholeDao.updatePotholeSeverity(temp);
		} else if(temp.getFormValue().equalsIgnoreCase("delete")) {
			potholeDao.deleteDuplicatePothole(temp);
		}

		
		return "redirect:/thankyou";
	}
	
	
	@RequestMapping(path="/reportPothole", method=RequestMethod.GET)
	public String displayReportPothole(ModelMap potholeMap) {
		if(auth.userHasRole(new String[]{"employee", "user"})) {
			if(!potholeMap.containsAttribute("Pothole")) {
				potholeMap.addAttribute("Pothole", new Pothole());
			}
			return "reportPothole";
		} else {
			return "forbidden";
		}
		
	}
	
	
	@RequestMapping(path="/reportPothole", method=RequestMethod.POST)
	public String submitReportPothole(@Valid @ModelAttribute("Pothole") Pothole potholeValues,
									  BindingResult result, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Pothole", result);
			flash.addFlashAttribute("Pothole", potholeValues);
			return "redirect:/reportPothole";

		}
		Pothole crater = new Pothole();
		
		crater.setLocation(potholeValues.getLocation());
		crater.setSize(potholeValues.getSize());
		crater.setDateFixed(potholeValues.getDateFixed());
		crater.setImage(potholeValues.getImage());
		crater.setPotholeId(potholeValues.getPotholeId());
		crater.setRepairStatus(potholeValues.getRepairStatus());
		crater.setLatitude(potholeValues.getLatitude());
		crater.setLongitude(potholeValues.getLongitude());
		
		potholeDao.savePothole(crater);	
		
		return "redirect:/thankyousubmission";
	}

	
	@RequestMapping(path="/thankyousubmission", method=RequestMethod.GET)
	public String displayThankyou(ModelMap map) {
		Pothole potholeCurrent = potholeDao.getAllPotholes().get(potholeDao.getAllPotholes().size() - 1);
		map.addAttribute("current", potholeDao.getAPothole(potholeCurrent.getPotholeId()));
		return "thankyousubmission";
	}
	
	@RequestMapping(path="/thankyou", method=RequestMethod.GET)
	public String displayThankYouEmployee() {
		return "thankyou";
	}
	
	
	

}
