package com.yc.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.test.biz.IGoodsInfoBiz;
import com.yc.test.biz.impl.GoodsInfoBizImpl;

import sun.nio.cs.ext.TIS_620;

@WebServlet("/goods")
public class GoodsInfoController extends BasicServlet {
	private static final long serialVersionUID = 5282344671417625882L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("finds".equals(op)) {
			finds(request,response);
		}else if("findByPage".equals(op)) {
			findByPage(request,response);
		}else if("findByCondition".equals(op)) {
			findByCondition(request,response);
		}else if("findIndex".equals(op)) {
			findIndex(request,response);
		}else if("findByGno".equals(op)) {
			fingByGno(request,response);
		}
	}
	private void fingByGno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gno = request.getParameter("gno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response,200,"", goodsInfoBiz.findByGno(gno));
	}
	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response,200,"", goodsInfoBiz.findIndex());
		
	}
	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");

		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response,goodsInfoBiz.findByCondition(tno,gname,page, rows) );

		
	}
	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response,goodsInfoBiz.findByPage(page, rows) );

	}
	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response,goodsInfoBiz.finds(page, rows) );

	
		
	}

}
