package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.Repository.EmployeeRepository;
import com.example.demo.Model.EmployeeEntity;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository Erepo;
	public String addDetails(EmployeeEntity ee) {
		Erepo.save(ee);
		return "Data added";
	}
	
	public String updateDetails(EmployeeEntity ee) {
		Erepo.saveAndFlush(ee);
		return "Data updated";
	}
	
	public String deleteDetails(int id) {
		Erepo.deleteById(id);
		return "data Deleted";
	}
	public List<EmployeeEntity> sortByField(String field){
		return Erepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Optional<EmployeeEntity> getById(int id) {
		return Erepo.findById(id);
	}
	public List<EmployeeEntity> showDetails(){
		return Erepo.findAll();
	}
	
	public List<EmployeeEntity> getWithPagination(int offset,int pageSize){
		Page<EmployeeEntity> page = Erepo.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
}