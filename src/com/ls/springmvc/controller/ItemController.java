package com.ls.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ls.springmvc.exception.MyException;
import com.ls.springmvc.pojo.Item;
import com.ls.springmvc.pojo.QueryVo;
import com.ls.springmvc.service.ItemService;
import com.ls.springmvc.service.imp.ItemserviceImp;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemservice;
	

	@RequestMapping(value = {"itemList","itemList2"},method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView itemList() {
		
		ModelAndView mav=new ModelAndView();
	
		List<Item> itemList = itemservice.getItemList();
		
		mav.addObject("itemList",itemList);
		mav.setViewName("itemList");
		System.out.println("ItemController.itemList");
		return mav;

	}
	//返回模型视图modelandview
//	@RequestMapping("itemEdit")
//	public ModelAndView itemEdit(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
//		ModelAndView mav=new ModelAndView();
//		String idString = request.getParameter("id");
//		System.out.println(request);
//		System.out.println(response);
//		System.out.println(session);
//		
//		Item item = itemservice.getItemById(new Integer(idString));
//		mav.addObject("item",item);
//		mav.setViewName("itemEdit");
//
//		return mav;
//
//	}
//    	//返回数据模型model modelmap
//	@RequestMapping("itemEdit")
//	public String itemEdit(Model model,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
//
//		String idString = request.getParameter("id");
//	
//		
//		Item item = itemservice.getItemById(new Integer(idString));
////		model.addAttribute("item", item);
//		modelMap.addAttribute("item", item);
//		return "itemEdit";
//
//	}
//	
	@RequestMapping("itemEdit")
	public String itemEdit(Model model,@RequestParam(value ="id",required = true,defaultValue ="1") Integer ids) {
		
		Item item = itemservice.getItemById(ids);
		model.addAttribute("item", item);
		return "itemEdit";

	}
	
	@RequestMapping("updateItem")
	public String itemEdit(Model model,Item item,MultipartFile pictureFile) throws Exception {
		String picname = UUID.randomUUID().toString();
		
		String oriName = pictureFile.getOriginalFilename();
		
		oriName.substring(oriName.lastIndexOf("."));
		
		
		
		File file=new File("C:\\Users\\lolo\\Pictures\\Camera Roll\\DesktopBackground\\"+picname+oriName);
		
		pictureFile.transferTo(file);
		item.setPic(picname+oriName);
		
		itemservice.upDateItem(item);
		model.addAttribute("item", item);
		model.addAttribute("msg", "更新成功");
//		return "forward:itemList.action";
		return "itemEdit";
	}
//	@RequestMapping("queryItem")
//	public String queryItem(QueryVo queryVo,Model model) {
////		模拟查询
//		if(queryVo.getItem()!=null ) {
//			System.out.println(queryVo.getItem());
//		}
//		  List<Item> itemList = itemservice.getItemList();
//		model.addAttribute("itemList", itemList);
//		return  "itemList";
//	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo queryVo,Integer[] ids,Model model) {
//		模拟查询
		if(queryVo.getItem()!=null ) {
			System.out.println(queryVo.getItem());
		}
		if(ids!=null&&ids.length>0) {
			for(Integer id: ids) {
				System.out.println(id);
			}
			if(queryVo.getItems()!=null&& queryVo.getItems().size()>0) {
				for (Item item : queryVo.getItems()) {
					System.out.println(item);
					
				}
			}
		}
		
		  List<Item> itemList = itemservice.getItemList();
		model.addAttribute("itemList", itemList);
		return  "itemList";
	}
	
	
	@RequestMapping("QueryVoid")
	public void QueryVoid(HttpServletRequest request,HttpServletResponse response) throws Exception {
//			
//		request.setAttribute("msg", "这个是request页面的返回值");
//		request.getRequestDispatcher("/WEB-INF/jsp/msg.jsp").forward(request, response);
//			
//		response.sendRedirect("/itemList.action");
//	
//		response.setContentType("test/xml:charset=utf-8");
		
		if (true) {
			
			throw new  MyException("你查找的商品不存在");
			
		}
		
		response.setCharacterEncoding("utf-8");

		PrintWriter writer = response.getWriter();
		
		
		writer.print("打印这天resporse消息");
	}
	
//	@RequestMapping("getItem")
//	@ResponseBody
//	public Item getItem(  ) {
////		System.out.print(items);
////		
//		Item item = itemservice.getItemById(1);
////		item.setName("赵红");
//		return item;
//	}
//		
	
	@RequestMapping("getItem")
	@ResponseBody
	public Item getItem(@RequestBody Item items) {
		System.out.print(items);
		
//		Item item = itemservice.getItemById(1);
		items.setName("赵红");
		return items;
		
	}
	@RequestMapping("item/{id}")
	
	public String itemQuery(@PathVariable("id") Integer ids,Model model) {
		
		Item item = itemservice.getItemById(ids);
		model.addAttribute("item",item);
		return "itemEdit";
		
		
	}
	
}
