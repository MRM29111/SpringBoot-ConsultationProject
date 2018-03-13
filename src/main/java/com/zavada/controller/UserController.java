package com.zavada.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zavada.domain.CreateAdvRequest;
import com.zavada.domain.EditUserRequest;
import com.zavada.domain.UserProfileRequest;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enumeration.Bodytype;
import com.zavada.entity.enumeration.Color;
import com.zavada.entity.enumeration.FuelType;
import com.zavada.mapper.UserMapper;
import com.zavada.repository.UserRepository;
import com.zavada.service.UserService;
import com.zavada.service.impl.CustomUserDetailsServiceImpl;
import com.zavada.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/user")
@SessionAttributes("editModel")
public class UserController {
	
		
		@Autowired UserService userService;
		
		@GetMapping
		public String showUserProfile(Model model, Principal principal) throws IOException {
		System.out.println("Secured user name: " + principal.getName());
		UserEntity entity = userService.findUserByEmail(principal.getName());	
		
		if(entity==null) return "redirect:/";
		
		UserProfileRequest request = UserMapper.entityToUserProfile(entity);
		model.addAttribute("userProfile", request);
		model.addAttribute("imageSrc", CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
		return "user/profile";
	}
		
		@GetMapping("/edit/{userId}")
		public String efitUserProfile(@PathVariable("userId") int userId,
				Model model, Principal principal)
		{
			UserEntity entity = userService.findUserByEmail(principal.getName());
			if(userId !=entity.getId()) return"redirect:/user";
			EditUserRequest request = UserMapper.entityToEditUser(entity);
			model.addAttribute("editModel", request);
			return "user/edit";
		}
		
		@PostMapping("/edit/{userId}")
		public String saveEditedProfile(
				@ModelAttribute("editModel") EditUserRequest request,
				@PathVariable("userId") int userId
				) throws IOException {
			if(request.getFile().isEmpty()) {
				return "redirect:/user/edit/" +  userId;
			}
			
			UserEntity entity = UserMapper.editRequestToEntity(request);
			userService.editUser(entity);
			CustomFileUtils.createFolder("user_"  + entity.getId());
			CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
			
			return "redirect:/user";
		}
		//---Advertisement
		@GetMapping("/{userId}/create")
		public String createAdvertisemant(@PathVariable("userId") int userId, Model model,
				Principal principal) {
			UserEntity entity=userService.findUserByEmail(principal.getName());
			CreateAdvRequest advRequest = new CreateAdvRequest();
			advRequest.setEntity(entity);
			model.addAttribute("title", "Create Advertisement");
			model.addAttribute("advModel", advRequest);
			model.addAttribute("colors",Color.values());
			model.addAttribute("fuelTypes", FuelType.values());
			model.addAttribute("bodyTypes", Bodytype.values());
			return "user/create-adv";
		} 
		
		@PostMapping("/{userId}/creqte")
		public String creqteAdvertisementForm(
				@ModelAttribute("advModel") CreateAdvRequest request
				) {
			
			return "redirect:/user";
		}
}
