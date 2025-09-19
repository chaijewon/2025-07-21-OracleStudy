package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.table.*;

import com.sist.commons.ImageChange;
public class KioskForm extends JPanel{
     JButton[] btns=new JButton[9];
     JButton b1,b2;
     JLabel la1,la2,la3;
     JTable table;
     DefaultTableModel model;
     ControllerPanel cp;
     String[] book={
    	"디지털 마케팅, AI로 날개를 달다",
    	"챗GPT는 거들 뿐, 생기부는 내가 쓴다",
    	"그림으로 쉽게 배우는 HTML+CSS+자바스크립트",
    	"데이터ㆍAI 시스템 아키텍트를 위한 실무 가이드",
    	"실전! 프로젝트로 배우는 딥러닝 컴퓨터비전",
    	"생성형 AI 인 액션",
    	"도커로 구축한 랩에서 혼자 실습하며 배우는 네트워크 프로토콜 입문",
    	"LLM과 RAG로 구현하는 AI 애플리케이션",
    	"시작하세요! 도커/쿠버네티스"
     };
     int[] price={
         28000,16000,27000,42000,35000,35000,32000,30000,36000
         
     };
     String[] poster= {
    		"https://wikibook.co.kr/images/cover/s/9791158396329.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396398.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396152.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396213.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396312.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396305.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396244.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396220.jpg",
    		"https://wikibook.co.kr/images/cover/s/9791158396169.jpg"
     };
     public KioskForm(ControllerPanel cp)
     {
    	 this.cp=cp;
    	 JPanel pan=new JPanel();
    	 pan.setLayout(new GridLayout(3,3,5,5));
    	 try
    	 {
    	   for(int i=0;i<9;i++)
    	   {
    		   URL url=new URL(poster[i]);
   			   Image img=ImageChange.getImage(new ImageIcon(url), 200, 150);
    		   btns[i]=new JButton(new ImageIcon(img));
    		   btns[i].setToolTipText(book[i]+"|"+price[i]);
    		   pan.add(btns[i]);
    	   }
    	 }catch(Exception ex){}
    	 setLayout(null);
    	 pan.setBounds(50, 15, 700, 450);
    	 add(pan);
     }
}
