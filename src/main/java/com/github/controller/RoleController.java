package com.github.controller;

import com.github.mapper.RoleMapper;
import com.github.model.Role;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.service.UserService;
import com.github.util.DataTableJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "类功能描述")
@Controller
@RequestMapping("role")
public class RoleController {

	@Resource private RoleMapper roleMapper;

	@ResponseBody
	@RequestMapping({"", "/", "list"})
	public DataTableJson<Role> list(@RequestParam(required = false, defaultValue = "1") Integer page,
	                                @RequestParam(name = "limit", required = false, defaultValue = "20") Integer pageSize,
	                                Role role) {

		PageHelper.startPage(page, pageSize);
		List<Role> roleList = roleMapper.getList(role);
		DataTableJson<Role> dataTableJson = new DataTableJson<>(roleList);

		return dataTableJson;
	}

	@ApiOperation(value="删除", notes = "删除描述")
	@ResponseBody
	@GetMapping("{id}/delete")
	public Object delete(@PathVariable Integer id) {
		roleMapper.delete(id);
		return "";
	}

}
