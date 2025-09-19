package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;

import javax.swing.table.*;
import com.sist.vo.*;
import com.sist.commons.ImageChange;
import com.sist.dao.*;
public class MyPageForm extends JPanel{
    JLabel la1;
    JTable table;
    DefaultTableModel model;
    ControllerPanel cp;
    public MyPageForm(ControllerPanel cp)
    {
    	this.cp=cp;
    	la1=new JLabel("찜목록");
    	String[] col={"번호","","업체명"};
    	Object[][] row=new Object[0][3];
    	model=new DefaultTableModel(row,col)
   	    {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0,columnIndex).getClass();
			}
   		  
   	    };
   	    table=new JTable(model);
   	    JScrollPane js=new JScrollPane(table);
   	    
   	    setLayout(null);
   	    la1.setBounds(300, 15, 200, 30);
   	    add(la1);
   	    js.setBounds(300, 55, 450, 300);
   	    add(js);
    	
    }
    public void print()
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	FoodDAO dao=FoodDAO.newInstance();
    	List<JjimVO> list=dao.jjimListData(cp.myId);
    	try
    	{
    		for(JjimVO vo:list)
    		{
    			URL url=new URL(vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 35, 35);
				Object[] d= {
					String.valueOf(vo.getJno()),
					new ImageIcon(img),
					vo.getName()
				};
				model.addRow(d);
    		}
    	}catch(Exception ex) {}
    }
    
}
