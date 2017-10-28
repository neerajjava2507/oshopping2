package com.nee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nee.back.DAO.categoryDAO;
import com.nee.back.DTO.category;

@Controller
public class PageController {

	@Autowired
	private categoryDAO cateDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of category

		mv.addObject("categories", cateDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// method to load all category 

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of category

		mv.addObject("categories", cateDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	//show category by id

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showProductByCategory(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		
		// category to fetch a single category 
		
		category cate =null;
		
		cate = cateDAO.get(id);
		
		mv.addObject("title", cate.getName());


		// passing the list of category
		mv.addObject("categories", cateDAO.list());
		
        // passing single object of category
		mv.addObject("cate", cate);

		mv.addObject("userClickproductbycategory", true);
		return mv;
	}

	// @RequestMapping(value= {"/test"})
	// public ModelAndView test(@RequestParam(value="greeting",required=false)String
	// greeting){
	//
	// if(greeting==null) {
	//
	// greeting ="Hello there";
	//
	// }
	//
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }

	// @RequestMapping(value= {"/test/{greeting}"})
	// public ModelAndView test(@PathVariable(value="greeting",required=false)String
	// greeting){
	//
	// if(greeting==null) {
	//
	// greeting ="Hello there";
	//
	// }
	//
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }

}
