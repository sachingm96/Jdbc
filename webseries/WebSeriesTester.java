package com.sachin.webseries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.sachin.webseries.constant.Genre;
import com.sachin.webseries.constant.StreamedIn;
import com.sachin.webseries.dao.WebSeriesDAO;
import com.sachin.webseries.dao.WebSeriesDAOImpl;
import com.sachin.webseries.dto.WebSeriesDTO;

public class WebSeriesTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Collection<WebSeriesDTO> coll = new ArrayList<WebSeriesDTO>();
//		WebSeriesDTO dto =new WebSeriesDTO("tubelight", 2, 1, StreamedIn.YOUTUBE, Genre.COMEDY, 18);
//		WebSeriesDTO dto1 =new WebSeriesDTO("Dark", 30, 3, StreamedIn.NETFLIX, Genre.SCI_FI, 18);
//		WebSeriesDTO dto2 =new WebSeriesDTO("Hostel dayz", 14, 2, StreamedIn.AMAZON_PRIME, Genre.COMEDY, 18);
//		WebSeriesDTO dto3 =new WebSeriesDTO("Ghoul", 4, 1, StreamedIn.NETFLIX, Genre.HORROR, 18);
//		WebSeriesDTO dto4 =new WebSeriesDTO("Special Ops", 20, 1, StreamedIn.HOTSTAR, Genre.ACTION, 18);
//		WebSeriesDTO dto5 =new WebSeriesDTO("Ben10", 20, 4, StreamedIn.AMAZON_PRIME, Genre.CHILDREN, 7);
//		
		WebSeriesDAO dao =new WebSeriesDAOImpl();
//		dao.save(dto);
//		dao.save(dto1);
//		dao.save(dto2);
//		dao.save(dto3);
//		dao.save(dto4);
//		dao.save(dto5);

		System.out.println(dao.total());
		System.out.println("---------------------------------");
		
		System.out.println(dao.findMaxSeason());
		System.out.println("---------------------------------");
		
		System.out.println(dao.findMinSeason());
		System.out.println("---------------------------------");
		
		Collection<WebSeriesDTO> set = dao.findAllSortNameDesc();
		set.forEach(m->System.out.println(m));
		System.out.println("---------------------------------");
		
		Optional<WebSeriesDTO> one=dao.findOne(g->g.getName().equals("tubelight"));
		if(one.isPresent()) {
			WebSeriesDTO  optional=one.get();
			System.out.println(optional);
		}
		System.out.println("---------------------------------");
		
		Collection<WebSeriesDTO> pre=dao.findAll(m->m.getNoOfEpisodes()>10);
		pre.forEach(k->System.out.println(k));
		System.out.println("---------------------------------");
		
		Collection<WebSeriesDTO> saveall = dao.saveAll(coll);
		System.out.println(saveall);
	}

}
