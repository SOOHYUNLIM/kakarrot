package org.kakarrot.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.annotation.RequestMapping;
import org.kakarrot.dao.BoardDAO;
import org.kakarrot.dao.BoardDAOImpl;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.Paging;


// board뒤에 뭐가오든 이 Servlet이 실행됨 
@WebServlet("/board/*")
public class BoardController extends BasicController {
	private static final long serialVersionUID = 1L;
	
	// board뒤에 /list가 오면 실행되는 메서드 
	@RequestMapping(value="/board/list", type="GET")
	String getList(HttpServletRequest req, HttpServletResponse resp) {
		Paging p = new Paging();
		String pageStr = req.getParameter("page")!=null ? req.getParameter("page"): "1";
		p.setPage(Integer.parseInt(pageStr));
		
		BoardDAO bd = new BoardDAOImpl();
		List<BoardVO> list = bd.selectList(p);
		
		req.setAttribute("list", list);
		
		return "/board/list";
	}
	
	@RequestMapping(value="/board/post", type="GET")
	String getPost(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO bd = new BoardDAOImpl();
		
		BoardVO bv = bd.selectOne(Long.parseLong(req.getParameter("bno")));
		
		req.setAttribute("postData", bv);
		
		return "/board/post";
	}
	
	@RequestMapping(value="/board/register", type="GET")
	String getRegister(HttpServletRequest req, HttpServletResponse resp) {
		return "/board/register";
	}
	
	@RequestMapping(value="/board/register", type="POST")
	String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		BoardVO vo = new BoardVO();
		
		vo.setTitle(req.getParameter("title"));
		vo.setContent(req.getParameter("content"));
		vo.setWriter(req.getParameter("writer"));
		
		BoardDAO bd = new BoardDAOImpl();
		System.out.println(bd.insert(vo));
		
		return "redirect:/list";
	}
  

}
