package com.sist.client;
import javax.swing.*;

import com.sist.commons.ImageChange;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import java.awt.*;
import java.net.URL;
import java.util.List;
public class HomeForm extends JPanel{
   ControllerPanel cp;
   JPanel pan=new JPanel();
   JLabel[] imgs=new JLabel[12];
   JLabel pageLa=new JLabel("0 page / 0 pages",JLabel.CENTER);
   JButton b1,b2;
   FoodDAO dao=FoodDAO.newInstance();
   int curpage=1;
   int totalpage=0;
   public HomeForm(ControllerPanel cp)
   {
	   this.cp=cp;
	   setLayout(null);
	   //pan.setBackground(Color.cyan);
	   pan.setLayout(new GridLayout(3,4,5,5));
	   pan.setBounds(30, 15, 700, 500);
	   add(pan);
	   print();
   }
   public void print()
   {
	   totalpage=dao.foodTotalPage();
	   // 데이터 읽기 
	   List<FoodVO> list=dao.foodListData(curpage);
	   for(int i=0;i<list.size();i++)
	   {
		   FoodVO vo=list.get(i);
		   try
		   {
			   URL url=new URL(vo.getPoster());
			   Image image=ImageChange.getImage(new ImageIcon(url), 170, 180);
			   imgs[i]=new JLabel(new ImageIcon(image));
			   imgs[i].setToolTipText(vo.getName()+"^"+vo.getFno());
			   pan.add(imgs[i]);
		   }catch(Exception ex) {}
	   }
   }
}







