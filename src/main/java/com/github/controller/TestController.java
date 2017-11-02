package com.github.controller;

import com.github.mapper.UserMapper;
import com.github.model.Permission;
import com.github.model.Role;
import com.github.model.User;
import com.github.repository.PermissionRepository;
import com.github.repository.RoleRepository;
import com.github.repository.UserRepository;
import com.github.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(description = "描述该类的作用")
@Controller
@RequestMapping("t")
public class TestController {

	@Resource private UserMapper userMapper;
	@Resource private UserService userService;
	@Resource private RoleRepository roleRepository;
	@Resource private UserRepository userRepository;
	@Resource private PermissionRepository permissionRepository;

	@ResponseBody
	@GetMapping({"", "/"})
	public Object index() {

//		User user = new User();
//		user.setName("iMiracle");
//		user.setClassName("className");
//		userRepository.save(user);
//
//		List<User> userList = userRepository.findAll();
//		System.err.println(userList);
//
//		userList = userMapper.getAll();
//		System.err.println(userList);
//
//		userList = userMapper.getAllXml();
//		System.err.println(userList);

//		Permission permission = new Permission();
//		permission.setName("a");
//
//		Set<Permission> permissionSet = new HashSet<>();
//		Permission permission1 = new Permission();
//		permission1.setName("b");
//		permissionSet.add(permission1);
//
//		Permission permission2 = new Permission();
//		permission2.setName("c");
//		permissionSet.add(permission2);
//
//		permission.setPermissionSet(permissionSet);
//		permissionRepository.save(permission);

//		List<Permission> permissionList = permissionRepository.getRolePermissionList(1);


//		User user = new User();
//		user.setName("iMiracle");
//
//		Role r1 = new Role();
//		r1.setName("role1");
//		roleRepository.save(r1);
//		Role r2 = new Role();
//		r2.setName("role2");
//		roleRepository.save(r2);
//
//		user.getRoleSet().add(r1);
//		user.getRoleSet().add(r2);
//		userRepository.save(user);



		return permissionRepository.getUserPermissionTree(1);
	}

	@ApiOperation(value = "这是一个demo接口", notes = "user demo")
	@ResponseBody
	@GetMapping("demo")
	public List<User> demo() {

		List<User> userList = userMapper.getAll();

		return userList;
	}

}
