package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CatDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {
 @Autowired
 CatDAO catDAO;

  // Landing Page--Category is added in Model for Spring Form---List is added
 // to retrieve all data
 @RequestMapping("/category")
 public String home(Model m) {
  m.addAttribute("isEditing", false);
  m.addAttribute("category", new Category());
  m.addAttribute("categoryList", catDAO.getAllCategory());
  m.addAttribute("msg", "");
  return "category";
 }

  // Saving Category
 @RequestMapping(value = "/save", method = RequestMethod.POST)
 public String save(@ModelAttribute("category") Category c, Model m) {
  catDAO.save(c);
  m.addAttribute("category", new Category());
  m.addAttribute("categoryList", catDAO.getAllCategory());
  m.addAttribute("msg", "category added successfully");
  return "category";
 }

  // Displaying Update Form
 @RequestMapping(value = "/update/{cat_id}", method = RequestMethod.GET)
 public String update(@PathVariable("cat_id") int cat_id, Model m) {
  Category c = catDAO.getById(cat_id);
  m.addAttribute("isEditing", true);
  m.addAttribute("category", c);
  m.addAttribute("categoryList", catDAO.getAllCategory());
  m.addAttribute("msg", "");
  return "category";
 }

  // Updating Category
 @RequestMapping(value = "/update", method = RequestMethod.POST)
 public String update(@ModelAttribute("category") Category c, Model m) {
  catDAO.update(c);
  m.addAttribute("category", new Category());
  m.addAttribute("categoryList", catDAO.getAllCategory());
  m.addAttribute("msg", "category updated successfully");
  return "category";
 }

  // Deleting Category
 @RequestMapping(value = "/delete/{cat_id}", method = RequestMethod.GET)
 public String delete(@PathVariable("cat_id") int cat_id, Model m) {
  catDAO.deleteById(cat_id);
  m.addAttribute("category", new Category());
  m.addAttribute("categoryList", catDAO.getAllCategory());
  m.addAttribute("msg", "category deleted successfully");
  return "category";
 }

}
