package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import com.sist.vo.*;
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
    
    
}
