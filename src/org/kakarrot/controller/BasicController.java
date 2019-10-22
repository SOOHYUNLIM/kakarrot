package org.kakarrot.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.annotation.RequestMapping;

//@WebServlet("/BasicController")
//URL�� �Ⱦ���(ȣ��뵵X) ��ɸ� ����
//������̼��� �̿��ؼ� �ش� �޼��带 ã�Ƽ� �������� �ѷ��ִ� ���� 
public class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String clientPath = req.getRequestURI();
		String methodType = req.getMethod();
		System.out.println(clientPath+" "+methodType);
		Class<?> clz = this.getClass();
		try {
			Method[] methods = clz.getDeclaredMethods();
			Method target = null;
			for (Method m : methods) {
				RequestMapping anno = m.getDeclaredAnnotation(RequestMapping.class);
				if (clientPath.equals(anno.value()) && methodType.equals(anno.type())) {
					target = m;
					break;
				}
			}
			
			String result = (String)target.invoke(this, req, resp);
			
			
			if(result.startsWith("redirect:")){
				resp.sendRedirect(result.substring(10));
			}else {
				req.getRequestDispatcher("/WEB-INF/views"+result+".jsp")
				.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
