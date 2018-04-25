package com.workshop.aplikasiportalberita.portalberita.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ModelBerita{

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<DataBerita> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setArticles(List<DataBerita> articles){
		this.articles = articles;
	}

	public List<DataBerita> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}