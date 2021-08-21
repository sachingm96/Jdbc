package com.sachin.webseries.dto;

import java.io.Serializable;

import com.sachin.webseries.constant.Genre;
import com.sachin.webseries.constant.StreamedIn;

public class WebSeriesDTO implements Serializable {

	private int id;
	private String name;
	private int noOfEpisodes;
	private int totalSeason;
	private StreamedIn streamedIn;
	private Genre genre;
	private int ageLimit;

	public WebSeriesDTO() {
		// TODO Auto-generated constructor stub
	}

	public WebSeriesDTO(int id, String name, int noOfEpisodes, int totalSeason, StreamedIn streamedIn, Genre genre,
			int ageLimit) {
		this.id = id;
		this.name = name;
		this.noOfEpisodes = noOfEpisodes;
		this.totalSeason = totalSeason;
		this.streamedIn = streamedIn;
		this.genre = genre;
		this.ageLimit = ageLimit;
	}

	public WebSeriesDTO( String name, int noOfEpisodes, int totalSeason, StreamedIn streamedIn, Genre genre,
			int ageLimit) {
		
		this.name = name;
		this.noOfEpisodes = noOfEpisodes;
		this.totalSeason = totalSeason;
		this.streamedIn = streamedIn;
		this.genre = genre;
		this.ageLimit = ageLimit;
	}
	
	@Override
	public String toString() {
		return "WebSeriesDTO [id=" + id + ", name=" + name + ", noOfEpisodes=" + noOfEpisodes + ", totalSeason="
				+ totalSeason + ", streamedIn=" + streamedIn + ", genre=" + genre + ", ageLimit=" + ageLimit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ageLimit;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + noOfEpisodes;
		result = prime * result + ((streamedIn == null) ? 0 : streamedIn.hashCode());
		result = prime * result + totalSeason;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebSeriesDTO other = (WebSeriesDTO) obj;
		if (ageLimit != other.ageLimit)
			return false;
		if (genre != other.genre)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfEpisodes != other.noOfEpisodes)
			return false;
		if (streamedIn != other.streamedIn)
			return false;
		if (totalSeason != other.totalSeason)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEpisodes() {
		return noOfEpisodes;
	}

	public void setNoOfEpisodes(int noOfEpisodes) {
		this.noOfEpisodes = noOfEpisodes;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	public StreamedIn getStreamedIn() {
		return streamedIn;
	}

	public void setStreamedIn(StreamedIn streamedIn) {
		this.streamedIn = streamedIn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

}
