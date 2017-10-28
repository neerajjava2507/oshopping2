package com.nee.back.DAOIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nee.back.DAO.categoryDAO;
import com.nee.back.DTO.category;


@Repository("cateDAO")
public class categoryDAOimpl implements categoryDAO {
	
	private static List<category> categories = new ArrayList<>();
	
	
	static {
		
		//adding first category
		
		category cate = new category();
		  cate.setId(1);
		  cate.setName("Mobile");
		  cate.setDiscription("Mobile discription");
		  cate.setImgurl("cat_1.jpg");
		  
		  categories.add(cate);
		  
		  //adding second category
		  
		  category cate2 = new category();
		  cate2.setId(2);
		  cate2.setName("Laptop");
		  cate2.setDiscription("Laptop discription");
		  cate2.setImgurl("cat2_1.jpg");
		  
		  categories.add(cate2);
		  
            //adding second category
		  
		   cate2 = new category();
		  cate2.setId(3);
		  cate2.setName("Televison");
		  cate2.setDiscription("Televison discription");
		  cate2.setImgurl("cat3_1.jpg");
		  
		  categories.add(cate2);
		  
		
	}

	@Override
	public List<category> list(){
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public category get(int id) {
	
		for(category cate : categories) {
			
			if(cate.getId()==id) {
				return cate;
				
			}
			
		}
		
		return null;
	}

}
