package com.spring.boot.rest.webservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.webservice.model.News;

@RestController
@RequestMapping(path = "v1")
public class NewsController {

	List<String> validApiKeys = Arrays.asList("key1", "key2", "key3", "key4");

	@GetMapping("/name")
	public String appName() {
		return "<h3>News Web App</h3>";
	}

	@GetMapping("/news")
	public LinkedHashMap<String, Object> getNews(@RequestParam String author, @RequestParam String apiKey) {
		System.out.println("Author: " + author);
		System.out.println("API Key: " + apiKey);

		LinkedHashMap<String, Object> newsMap = new LinkedHashMap<String, Object>();
		newsMap.put("status", "OK");

		if (!apiKey.isEmpty() && validApiKeys.contains(apiKey)) {
			newsMap.put("total", 0);
			// newsMap.put("articles", new String[]{"Article1", "Article2", "Article3"});

			News news1 = new News("John", "News Article1", "Description of News Arvicle1");
			News news2 = new News("Jennie", "News Article2", "Description of News Arvicle2");
			News news3 = new News("Denny", "News Article3", "Description of News Arvicle3");
			News news4 = new News("Dave", "News Article4", "Description of News Arvicle4");
			News news5 = new News("Justing", "News Article5", "Description of News Arvicle5");
			News news6 = new News("Denny", "News Article6", "Description of News Arvicle6");

			ArrayList<News> newsList = new ArrayList<News>();
			newsList.add(news1);
			newsList.add(news2);
			newsList.add(news3);
			newsList.add(news4);
			newsList.add(news5);
			newsList.add(news6);

			List<News> filteredList = newsList;

			if (!author.isEmpty()) {
				filteredList = newsList.stream().filter(news -> news.getAuthor().equalsIgnoreCase(author))
						.collect(Collectors.toList());
			}

			newsMap.put("total", filteredList.size());
			newsMap.put("articles", filteredList);
		} else {
			if (apiKey.isEmpty()) {
				newsMap.put("status", "error");
				newsMap.put("errorCode", 101);
				newsMap.put("errorMessage", "API Key Missing");
			} else {
				newsMap.put("status", "error");
				newsMap.put("errorCode", 201);
				newsMap.put("errorMessage", "Invalid API Key");
			}
		}
		return newsMap;
	}
}
