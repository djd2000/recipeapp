package com.djd2000.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author david
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping({ "", "/", "index", "index.html" })
	public String getIndexPage() {
		return "index";
	}

}
