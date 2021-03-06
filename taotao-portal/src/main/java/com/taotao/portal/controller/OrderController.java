package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	// @RequestMapping("/order-cart")
	// public String showOrderCart() {
	// return "order-cart";
	// }

	@RequestMapping("/order-cart")
	public String showOrderCart(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// 取购物车商品列表
		List<CartItem> list = cartService.getCartItemList(request, response);
		// 传递给页面
		model.addAttribute("cartList", list);

		return "order-cart";
	}

	/**
	 * 创建订单
	 * 
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping("/create")
	public String createOrder(Order order, Model model,
			HttpServletRequest request) {
		// 取token中的用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		if (user != null) {
			//补全用户信息
			order.setUserId(user.getId());
			order.setBuyerNick(user.getUsername());
		}
		String orderId = orderService.createOrder(order);
		model.addAttribute("orderId", orderId);
		model.addAttribute("payment", order.getPayment());
		model.addAttribute("date",
				new DateTime().plusDays(3).toString("yyyy-MM-dd"));
		return "success";
	}
}
