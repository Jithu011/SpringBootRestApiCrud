package com.nexential.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nexential.crud.dao.UserRepository;
import com.nexential.crud.entity.User;
import com.nexential.crud.pageSettings.PageSettings;
import com.nexential.crud.sort.SortSettings;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		User oldUser=null;
		Optional<User> optionaluser = userRepository.findById(user.getId());
		if(optionaluser.isPresent()) {
			oldUser=optionaluser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		}
		else {
			return new User();
		}
		return oldUser;
		
	}
	public String deleteUserById(int id) {
		userRepository.deleteById(id);;
		return "User got deleted";
	}
	public Page<User> getUserPage(PageSettings pageSetting) {

	        Pageable userPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage());
	        return userRepository.findAll(userPage);
	    }
	public List<User> getPageSorted(SortSettings sortSetting){
		Sort userSort = sortSetting.buildSort();
		return userRepository.findAll(userSort);
	}
}
