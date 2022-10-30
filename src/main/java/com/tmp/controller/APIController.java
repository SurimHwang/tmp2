package com.tmp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tmp.dto.BoardContentDTO;
import com.tmp.service.BoardServices;

@RestController
public class APIController {

	@Autowired
	private BoardServices BoardServices;

	@RequestMapping("/restTest")
	public void restTest(HttpServletRequest request, Model model)
			throws IOException, ParserConfigurationException, SAXException {

		StringBuilder urlBuilder = null;
		
		for (int j = 10; j <= 12; j++) {
			try {
	        //파일 인코딩
	        	request.setCharacterEncoding("UTF-8");
	            String browser = request.getHeader("User-Agent");
	            
		        if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
		        
		        	urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
			        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=cPDtdnIKMv2LdwRrLO5qDHQfQh4BF0%2FR6CxgqNLvy3o4hWB3KyWef0W%2FXVPd2z8hut7UpMZtJrl%2Bt9oNKcJ8gg%3D%3D"); /*Service Key*/
			        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
			        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*지역코드*/
			        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8")+"="+URLEncoder.encode("2021","UTF-8") + URLEncoder.encode(Integer.toString(j), "UTF-8")); /*계약월*/
		       
		        } 
		    } catch (UnsupportedEncodingException ex) {
	            System.out.println("UnsupportedEncodingException");
		    }
	       
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        
	        String url_ = urlBuilder.toString();
	        System.out.println(url_);
	        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	        Document document = dBuilder.parse(url_);
	
	         NodeList childList = document.getElementsByTagName("item");
		  
		     for(int i = 0; i < childList.getLength(); i++) {
	    		Node item = childList.item(i);
	    		if(item.getNodeType() == Node.ELEMENT_NODE) { // 노드의 타입이 Element일 경우(공백이 아닌 경우)
	    			Element element = (Element) item;
	    			BoardContentDTO dto = new BoardContentDTO();

					dto.setPrice(Integer.parseInt(getTagValue("거래금액", element).trim().replace(",", "")));
	    			dto.setApartName(getTagValue("아파트", element));
	    			dto.setFloor(Integer.parseInt(getTagValue("층", element)));
	    			dto.setArea(Float.parseFloat(getTagValue("전용면적", element)));
	    			String dt = getTagValue("년",element) + "-" + getTagValue("월",element) +"-" + getTagValue("일",element); 
	    			Date d = Date.valueOf(dt);
	    			dto.setDate(d);
	    			dto.setAddress("서울시 종로구");
	    			
//	    			dtos.add(dto);
	    			BoardServices.insertbdContent(dto);
	    			
	    		} else {
	    			System.out.println("공백 입니다.");
	    		}
		     }
	      
//	        BufferedReader rd;
//	        
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"ISO-8859-1"));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"ISO-8859-1"));
//	        }
//	        
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
	        conn.disconnect();
	        //System.out.println(sb.toString());
		}
	 }
	

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}