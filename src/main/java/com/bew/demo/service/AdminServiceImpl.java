package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.AdminRepository;
import com.bew.demo.dto.AdminDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Admin;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<AdminDTO> findAll(){
		List<AdminDTO> adminDTO;
		List<Admin> admins = adminRepository.findAll();
		adminDTO = new ArrayList<>();
		for(Admin admin: admins) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			adminDTO.add(mapper.map(admin, AdminDTO.class));
		}
		// TODO Auto-generated method stub
		return adminDTO;
	}

	@Override
	public AdminDTO findById(Integer idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAdmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		admin = (mapper.map(adminDTO, Admin.class));
    	adminRepository.save(admin);
	}

	@Override
	public void updateAdmin(AdminDTO adminDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Admin admin;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		admin = (mapper.map(adminDTO, Admin.class));
		adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(Integer idAdmin) throws EmptyResultException {
		// TODO Auto-generated method stub
		adminRepository.deleteById(idAdmin);
	}

}
