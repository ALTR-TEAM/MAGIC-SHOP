package Ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ecommerce.dao.ProductDao;

@Controller
@RequestMapping(value = "product")
public class ProductController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductDao productModel  = new ProductDao();
		modelMap.put("products", productModel.findAll());
		return "product/index";
	}

}
