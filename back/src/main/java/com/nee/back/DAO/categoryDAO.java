package com.nee.back.DAO;

import java.util.List;

import com.nee.back.DTO.category;

public interface categoryDAO {
	
	List<category> list();
	category get(int id);

}
