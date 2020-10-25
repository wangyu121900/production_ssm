package com.megagao.production.ssm.controller.system;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.Custom;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.BranchService;

@Controller
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "branch_list";
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = branchService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = branchService.deleteBatch(ids);
		return result;
	}	
	
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page,Integer rows)throws Exception{
		
		EUDataGridResult result = branchService.getList(page, rows);
		return result;
	}

	@RequestMapping("/search_branch_by_id")
	@ResponseBody
	public EUDataGridResult searchBranchById(Integer page,Integer rows,String searchValue)throws Exception{
		
		EUDataGridResult result = branchService.searchBranchById(page, rows,searchValue);
		return result;
	}
	
	@RequestMapping("/search_branch_by_short_name")
	@ResponseBody
	public EUDataGridResult searchBranchByShortName(Integer page,Integer rows,String searchValue)throws Exception{
		searchValue = new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		EUDataGridResult result = branchService.searchBranchByShortName(page, rows,searchValue);
//		searchValue = new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		return result;
	}
	
	@RequestMapping("/search_branch_by_name")
	@ResponseBody
	public EUDataGridResult searchBranchByName(Integer page,Integer rows,String searchValue)throws Exception{
		searchValue = new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		EUDataGridResult result = branchService.searchBranchByName(page, rows,searchValue);
//		searchValue = new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		return result;
	}
	
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "branch_add";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Branch branch, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(branchService.get(branch.getId()) != null){
			result = new CustomResult(0, "该机构编号已经存在，请更换机构编号！", null);
		}else{
			result = branchService.insert(branch);
		}
		return result;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "branch_edit";
	}
	
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Branch branch, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return branchService.updateAll(branch);
	}
}
