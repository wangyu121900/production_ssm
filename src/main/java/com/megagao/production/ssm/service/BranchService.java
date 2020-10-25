package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.Custom;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface BranchService {
	public List< Branch> find();
	
	/**
	 * 分页插件查询
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	EUDataGridResult getList(int page, int rows) throws Exception;
	
	EUDataGridResult searchBranchById(int page,int rows,String id) throws Exception;
	
	Branch load(String id) throws Exception;
	
	EUDataGridResult searchBranchByShortName(int page,int rows,String short_name) throws Exception;
	
	EUDataGridResult searchBranchByName(int page,int rows,String name) throws Exception;
	
	CustomResult insert(Branch branch)throws Exception;

	Branch get(String string) throws Exception;

	CustomResult updateAll(Branch branch);
	
	CustomResult delete(String id);

	CustomResult deleteBatch(String[] ids);
	
}
