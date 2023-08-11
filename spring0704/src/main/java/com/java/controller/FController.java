package com.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FController {
	
	//---xml 파일 가져오기--------------------------------------------------------
	
	@RequestMapping("/ajax_xml")
	@ResponseBody   //데이터로 돌려줄거다!
	public String ajax_xml(int page) throws Exception {  // throws Exceptinon : 파일 입출력 / print연결 / 오라클 연결할때 쓴다
		System.out.println("ajax_xml 요청페이지 : " + page);
		
		String service_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";
		String serviceKey = "pUNvBNVlFmsyaWJelU8KnsAkFiB2pOuoENlu3rlO8bfH%2Fo7BJvbLtB3Rt6RWubPxOcdptWqUHuxC1uFFBMMDTg%3D%3D";
		
		 StringBuilder urlBuilder = new StringBuilder(service_url); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        
         
         urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*페이지번호*/
        
         
         URL url = new URL(urlBuilder.toString());
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Content-type", "application/json");
         System.out.println("Response code: " + conn.getResponseCode());
         BufferedReader rd;
         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
             sb.append(line);
         }
         rd.close();
         conn.disconnect();
         System.out.println(sb.toString());
 		 
		//공공데이터 리턴
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----json파일 가져오기-------------------------------------------------------

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/index2")
	public String index2() {
		return "index2";
	}

	@RequestMapping("/map")
	public String map() {
		return "map";
	}
	
	//공공데이터 가져오기
	@RequestMapping("/ajax_data")
	@ResponseBody   //데이터로 돌려줄거다!
	public String ajax_data(int page) throws Exception {  // throws Exceptinon : 파일 입출력 / print연결 / 오라클 연결할때 쓴다
		System.out.println("요청페이지 : " + page);
		//<!--공공데이터포털에서 가져옴---------------------------------------------------
		
		String service_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";
		String serviceKey = "pUNvBNVlFmsyaWJelU8KnsAkFiB2pOuoENlu3rlO8bfH%2Fo7BJvbLtB3Rt6RWubPxOcdptWqUHuxC1uFFBMMDTg%3D%3D";
		
		 StringBuilder urlBuilder = new StringBuilder(service_url); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        
         
         urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*페이지번호*/
        
         
         URL url = new URL(urlBuilder.toString());
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Content-type", "application/json");
         System.out.println("Response code: " + conn.getResponseCode());
         BufferedReader rd;
         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
             sb.append(line);
         }
         rd.close();
         conn.disconnect();
         System.out.println(sb.toString());
	 	//------------------------------------------------------------------------
 		 
		//공공데이터 리턴
		return sb.toString();
	}
	
	
	
	
	
	//공공데이터 검색 가져오기
	@RequestMapping("/ajax_search")
	@ResponseBody   //데이터로 돌려줄거다!
	public String ajax_search(String s_word) throws Exception {  // throws Exceptinon : 파일 입출력 / print연결 / 오라클 연결할때 쓴다
		System.out.println("ajax_search : " + s_word);
		//<!--공공데이터포털에서 가져옴---------------------------------------------------
		
		String service_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1";
		String serviceKey = "pUNvBNVlFmsyaWJelU8KnsAkFiB2pOuoENlu3rlO8bfH%2Fo7BJvbLtB3Rt6RWubPxOcdptWqUHuxC1uFFBMMDTg%3D%3D";
		
		 StringBuilder urlBuilder = new StringBuilder(service_url); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        
         
         urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(s_word, "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*페이지번호*/
        
         
         URL url = new URL(urlBuilder.toString());
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Content-type", "application/json");
         System.out.println("Response code: " + conn.getResponseCode());
         BufferedReader rd;
         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
             sb.append(line);
         }
         rd.close();
         conn.disconnect();
         System.out.println(sb.toString());
	 	//------------------------------------------------------------------------
 		 
		//공공데이터 리턴
		return sb.toString();
	}//ajax_search
	
	
	
	
	
	
	
	
	
	
	
	
	
}
