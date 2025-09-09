package com.sist.main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BoardInsert extends JPanel{
     JLabel la1,la2,la3,la4,la5;
     JTextField tf1,tf2;
     JTextArea ta;
     JPasswordField pf;
     JButton b1,b2;
     private BoardMainFrame bm;
     public BoardInsert(BoardMainFrame bm)
     {
    	 this.bm=bm;
    	 la1=new JLabel("글쓰기",JLabel.CENTER);
     	 la1.setFont(new Font("맑은 고딕",Font.BOLD,40));
     	 
     	 la2=new JLabel("이름",JLabel.CENTER);
     	 la3=new JLabel("제목",JLabel.CENTER);
     	 la4=new JLabel("내용",JLabel.CENTER);
     	 la5=new JLabel("비밀번호",JLabel.CENTER);
     	 
     	 tf1=new JTextField();
     	 tf2=new JTextField();
     	 pf=new JPasswordField();
     	 
     	 ta=new JTextArea();
     	 JScrollPane js=new JScrollPane(ta);
     	 
     	 b1=new JButton("글쓰기");
     	 b2=new JButton("취소");
     	 
     	 setLayout(null);
     	 la1.setBounds(10, 15, 610, 50);
    	 add(la1);
    	 
    	 la2.setBounds(30, 75, 80, 30);
    	 tf1.setBounds(115,75, 100, 30);
    	 add(la2);add(tf1);
    	 
    	 la3.setBounds(30, 110, 80, 30);
    	 tf2.setBounds(115,110, 350, 30);
    	 add(la3);add(tf2);
    	 
    	 la4.setBounds(30, 145, 80, 30);
    	 js.setBounds(115,145, 350, 150);
    	 add(la4);add(js);
    	 
    	 la5.setBounds(30, 300, 80, 30);
    	 pf.setBounds(115,300, 100, 30);
    	 add(la5);add(pf);
     	 
    	 JPanel p=new JPanel();
    	 p.add(b1);p.add(b2);
    	 p.setBounds(30, 340,435 , 35);
    	 add(p);
     }
}
