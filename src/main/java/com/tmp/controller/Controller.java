package com.tmp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tmp.dto.BoardDTO;

@RestController
public class Controller {
	
    @RequestMapping("/restTest")
    public String restTest(HttpServletRequest request, Model model) throws IOException, ParserConfigurationException, SAXException {
         
    	for(int j=1; j<=12; j++) {
	    	StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=cPDtdnIKMv2LdwRrLO5qDHQfQh4BF0%2FR6CxgqNLvy3o4hWB3KyWef0W%2FXVPd2z8hut7UpMZtJrl%2Bt9oNKcJ8gg%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*지역코드*/
	        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD=2015","UTF-8") + j);
		        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        
	        String url_ = urlBuilder.toString();
	        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	        Document document = dBuilder.parse(url_);
	
	         //Element root = document.getDocumentElement();
		 
	        List<BoardContentDTO> boardlist = BoardServices.selectAll();
	        
		    NodeList childList = document.getElementsByTagName("item");
		    System.out.println("---------------------------");
		  
		    for(int i = 0; i < childList.getLength(); i++) {
	    		Node item = childList.item(i);
	    		if(item.getNodeType() == Node.ELEMENT_NODE) { // 노드의 타입이 Element일 경우(공백이 아닌 경우)
	    			Element element = (Element) item;
	//    			System.out.println(item.getNodeName());
	//    			System.out.println(item.getTextContent());
	    			
	    			
	    			System.out.println("거래금액(만원): "+ getTagValue("거래금액", element));
	    			//System.out.println("거래유형: "+getTagValue("거래유형", element));
	    			System.out.println("아파트: "+getTagValue("아파트", element));
	    			System.out.println("층: "+getTagValue("층", element));
	    			System.out.println("전용면적(㎡): "+getTagValue("전용면적", element));
	    			System.out.println("년: "+getTagValue("년", element));
	    			System.out.println("월: "+getTagValue("월", element));
	    			System.out.println("일: "+getTagValue("일", element));
	    			System.out.println("건축년도: "+getTagValue("건축년도", element));
	    			System.out.println("도로명: "+getTagValue("도로명", element));
	    			System.out.println("도로명건물본번호코드: "+getTagValue("도로명건물본번호코드", element));
	    			System.out.println("도로명건물부번호코드: "+getTagValue("도로명건물부번호코드", element));
	    			System.out.println("도로명시군구코드: "+getTagValue("도로명시군구코드", element));
	    			System.out.println("도로명일련번호코드: "+getTagValue("도로명일련번호코드", element));
	    			System.out.println("도로명지상지하코드: "+getTagValue("도로명지상지하코드", element));
	    			System.out.println("도로명코드: "+getTagValue("도로명코드", element));
	    			System.out.println("지번: "+getTagValue("지번", element));
	    			System.out.println("지역주소: 서울시 종로구"); //+getTagValue("지역코드", element));
	    			System.out.println("법정동: "+getTagValue("법정동", element));
	    			System.out.println("법정동본번코드: "+getTagValue("법정동본번코드", element));
	    			System.out.println("법정동부번코드: "+getTagValue("법정동부번코드", element));
	    			System.out.println("법정동시군구코드: "+getTagValue("법정동시군구코드", element));
	    			System.out.println("법정동읍면동코드: "+getTagValue("법정동읍면동코드", element));
	    			System.out.println("법정동지번코드: "+getTagValue("법정동지번코드", element));
	    			System.out.println("일련번호: "+getTagValue("일련번호", element));
	    			System.out.println("중개사소재지: "+getTagValue("중개사소재지", element));
	//    			System.out.println("해제사유발생일: "+getTagValue("해제사유발생일", element));
	//    			System.out.println("해제여부: "+getTagValue("해제여부", element));
	    			System.out.println("---------------------------------");
	    		} else {
	    			System.out.println("공백 입니다.");
	    		}
	    	 }
	      
	        BufferedReader rd;
	        
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
    	}    
	    return "selectone";
    	
	 }
    private static String getTagValue(String sTag, Element eElement) {
    	 NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
    	        Node nValue = (Node) nlList.item(0);
    	 return nValue.getNodeValue();
    	  }
}