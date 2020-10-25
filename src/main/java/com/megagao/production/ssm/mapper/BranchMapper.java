package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.COrder;
import com.megagao.production.ssm.domain.Custom;

public interface BranchMapper {
	public List<Branch> find();

	public List<Branch> searchBranchById(String id);
	
	public Branch load(String id);

	public List<Branch> searchBranchByShortName(String short_name);

	public List<Branch> searchBranchByName(String name);
	

	public int deleteByPrimaryKey(String id);
	
	public int deleteBatch(String[] ids);
	
	public int insert(Branch branch)throws Exception;
	public int update(Branch branch);

}
