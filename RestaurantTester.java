package com.sachin.restaurant;

import java.util.Collection;

import com.sachin.restaurant.constant.RestaurantType;
import com.sachin.restaurant.dao.RestaurantDAO;
import com.sachin.restaurant.dao.RestaurantDAOImpl;
import com.sachin.restaurant.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {

		RestaurantDTO dto = new RestaurantDTO("navya", "basveshwaranagar", "parota", true, RestaurantType.FAST_FOOD);
		RestaurantDTO dto1 = new RestaurantDTO("hindusthan", "honnali", "chicken lolipop", true, RestaurantType.FAMILY);
		RestaurantDTO dto2 = new RestaurantDTO("abbalagere", "shivamogga", "biriyani", false,
				RestaurantType.CASUAL_DINING);

		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);

		System.out.println(dao.findByName("hindusthan"));

		Collection<RestaurantDTO> collection = dao.findByType(RestaurantType.FAST_FOOD);
		collection.forEach(ref -> System.out.println(ref));

		System.out.println(dao.updateTypeByName(RestaurantType.CASUAL_DINING, "dhaba"));

		System.out.println(dao.deleteByTypeAndName(RestaurantType.FAST_FOOD, "navya"));
	}

}
