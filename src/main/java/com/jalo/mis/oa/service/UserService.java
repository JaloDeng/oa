package com.jalo.mis.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalo.mis.oa.entity.UserEntity;
import com.jalo.mis.oa.model.User;
import com.jalo.mis.oa.repository.UserRepository;

/**
 * Service : user
 * @author Jalo
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}
	
	public UserEntity findOne(Long id) {
		return userRepository.findOne(id);
	}
	
	public UserEntity saveOrUpdate(User model) {
		UserEntity entity = new UserEntity();

		if (model.getId() != null) {
			entity.setId(model.getId());
		}
		entity.setName(model.getName());
		entity.setMail(model.getMail());
		
		return userRepository.saveAndFlush(entity);
	}
	
	public Long delete(Long id) {
		userRepository.delete(id);
		return id;
	}
}
