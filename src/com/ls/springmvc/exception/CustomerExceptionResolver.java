package com.ls.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		String result="ϵͳ�����˹��ϣ�����ϵ����Ա";
if(e instanceof MyException) {
	result=((MyException)e).getMsg();
	
	
}
		
	ModelAndView mav=new ModelAndView();
	mav.addObject("msg",result);
	mav.setViewName("msg");
		
		return mav;
	}

}
