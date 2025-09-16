package com.sist.client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class FoodFind extends JPanel{
     JComboBox<String> box;
     JTextField tf;
     JButton btn;
     DefaultTableModel model;
     JTable table;
     TableColumn column;
     ControllerPanel cp;
     public FoodFind(ControllerPanel cp)
     {
    	 this.cp=cp;
    	 box=new JComboBox<String>();
    	 box.addItem("업체명");
    	 box.addItem("음식종류");
    	 box.addItem("주소");
    	 String[] col={"번호","","맛집명"};
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
				return getValueAt(columnIndex,0).getClass();
			}
    		  
    	 };
    	 
    	 table=new JTable(model);
    	 JScrollPane js=new JScrollPane(table);
    	 for(int i=0;i<col.length;i++)
     	{
     		DefaultTableCellRenderer rend=
     				new DefaultTableCellRenderer();
     		column=table.getColumnModel().getColumn(i);
     		if(i==0)
     		{
     			column.setPreferredWidth(35);
     			rend.setHorizontalAlignment(JLabel.CENTER);
     		}
     		else if(i==1)
     		{
     			column.setPreferredWidth(80);
     		}
     		else if(i==2)
     		{
     			column.setPreferredWidth(350);
     		}
     		
     		column.setCellRenderer(rend);
     	}
     	table.getTableHeader().setReorderingAllowed(false);
     	table.getTableHeader().setResizingAllowed(false);
     	table.setRowHeight(30);
     	tf=new JTextField(10);
     	btn=new JButton("검색");
     	JPanel p=new JPanel();
     	p.add(box);p.add(tf);p.add(btn);
     	setLayout(null);
     	p.setBounds(200, 15, 350, 35);
     	add(p);
     	js.setBounds(200, 60, 650, 500);
     	add(js);
    	 
     }
}
