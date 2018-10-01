package gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import parser.CommonMethods;
import parser.Method;

// Class that creates and return the two tables comparing the methods in the of two log files
public class TableForComparision {
	private List<CommonMethods> commonCriticalMethodsinP1 = new ArrayList<>();
	private List<CommonMethods> commonCriticalMethodsinP2 = new ArrayList<>();
	
	public TableForComparision(List<CommonMethods>[] commonCriticalMethods) {
		commonCriticalMethodsinP1 = commonCriticalMethods[0];					// Get the critical methods that are to be shown
		commonCriticalMethodsinP2 = commonCriticalMethods[1];
	}
	
	public JTable[] createTablesForComparision(){
		///////////////////////////////////////////////// For Table 1  //////////////////////////////////////////////////////////////
		DefaultTableModel model1 = new DefaultTableModel();
		final JTable table1 = new JTable(model1);
	    model1.addColumn("Method");
	    model1.addColumn("Class Name");
	    model1.addColumn("Static Or Not");
	    model1.addColumn("Parameter");
	    model1.addColumn("Return Type");
	    model1.addColumn("Runtime in first file");
	    model1.addColumn("Runtime in second file");
	    model1.addColumn("Stack Trace in first file");
	    model1.addColumn("StackTrace in second file");
	    for(CommonMethods met: commonCriticalMethodsinP1){
			  model1.addRow(new Object[] {met.getMethodName(), met.getClass(), met.isStaticOrNot(), met.getParameters(), met.getReturnType(), met.getRunTime1(), met.getRuntime2(), "Click for StackTrace", "Click for StackTrace"}); 
		  }
	    table1.setFont(new Font("Serif", Font.PLAIN, 20));
		table1.setRowHeight(40);
		table1.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
		table1.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
		table1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table1.rowAtPoint(evt.getPoint());
		        int col = table1.columnAtPoint(evt.getPoint());
		        if (col==7) {
		        	CommonMethods cm = commonCriticalMethodsinP1.get(row); 
		        	JDialog d = new JDialog();
		        	d.setSize(500, 1000);
		            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        	try{
			        	List<String> methodStackList = new ArrayList<String>(cm.getMethodStack1());
		        		d.setTitle(cm.getMethodName()+" Stack Trace");
			            DefaultTableModel model = new DefaultTableModel();
			        	JTable t = new JTable(model);
			      	    model.addColumn("<html><font size=8>"+"StackTrace"+"</font></html>");
			      	    for(String method: methodStackList){
			    		  model.addRow(new Object[] {method});
			    	    }
			            d.add(t);
			            d.setVisible(true);
		        	}
		        	catch(NullPointerException ex){
		        		System.out.println("Here");
		        		d.add(new JLabel("StackTrace not available for this method in the log file"));
		        		d.setVisible(true);
		        	}
		        }
		        if (col==8) {
		        	CommonMethods cm = commonCriticalMethodsinP1.get(row); 
		        	JDialog d = new JDialog();
		        	d.setSize(500, 1000);
		            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        	try{
			        	List<String> methodStackList = new ArrayList<String>(cm.getMethodStack2());
		        		d.setTitle(cm.getMethodName()+" Stack Trace");
			            DefaultTableModel model = new DefaultTableModel();
			        	JTable t = new JTable(model);
			      	    model.addColumn("<html><font size=8>"+"StackTrace"+"</font></html>");
			      	    for(String method: methodStackList){
			    		  model.addRow(new Object[] {method});
			    	    }
			            d.add(t);
			            d.setVisible(true);
		        	}
		        	catch(NullPointerException ex){
		        		System.out.println("Here");
		        		d.add(new JLabel("StackTrace not available for this method in the log file"));
		        		d.setVisible(true);
		        	}
		        }
		    }
		});
		
		
		
		//////////////////////////////////////////////////// For Table 2   /////////////////////////////////////////////////////////
		DefaultTableModel model2 = new DefaultTableModel();
		final JTable table2 = new JTable(model2);
	    model2.addColumn("Method");
	    model2.addColumn("Class Name");
	    model2.addColumn("Static Or Not");
	    model2.addColumn("Parameter");
	    model2.addColumn("Return Type");
	    model2.addColumn("Runtime in second file");
	    model2.addColumn("Runtime in first file");
	    model2.addColumn("Stack Trace in second file");
	    model2.addColumn("StackTrace in first file");
	    for(CommonMethods met: commonCriticalMethodsinP2){
			  model2.addRow(new Object[] {met.getMethodName(), met.getClass(), met.isStaticOrNot(), met.getParameters(), met.getReturnType(), met.getRunTime1(), met.getRuntime2(), "Click for StackTrace", "Click for StackTrace"}); 
		  }
	    table2.setFont(new Font("Serif", Font.PLAIN, 20));
		table2.setRowHeight(40);
		table2.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
		table2.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
		table2.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table2.rowAtPoint(evt.getPoint());
		        int col = table2.columnAtPoint(evt.getPoint());
		        if (col==7) {
		        	CommonMethods cm = commonCriticalMethodsinP2.get(row); 
		        	JDialog d = new JDialog();
		        	d.setSize(500, 1000);
		            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        	try{
			        	List<String> methodStackList = new ArrayList<String>(cm.getMethodStack1());
		        		d.setTitle(cm.getMethodName()+" Stack Trace");
			            DefaultTableModel model = new DefaultTableModel();
			        	JTable t = new JTable(model);
			      	    model.addColumn("<html><font size=8>"+"StackTrace"+"</font></html>");
			      	    for(String method: methodStackList){
			    		  model.addRow(new Object[] {method});
			    	    }
			            d.add(t);
			            d.setVisible(true);
		        	}
		        	catch(NullPointerException ex){
		        		System.out.println("Here");
		        		d.add(new JLabel("StackTrace not available for this method in the log file"));
		        		d.setVisible(true);
		        	}
		        }
		        if (col==8) {
		        	CommonMethods cm = commonCriticalMethodsinP2.get(row); 
		        	JDialog d = new JDialog();
		        	d.setSize(500, 1000);
		            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        	try{
			        	List<String> methodStackList = new ArrayList<String>(cm.getMethodStack2());
		        		d.setTitle(cm.getMethodName()+" Stack Trace");
			            DefaultTableModel model = new DefaultTableModel();
			        	JTable t = new JTable(model);
			      	    model.addColumn("<html><font size=8>"+"StackTrace"+"</font></html>");
			      	    for(String method: methodStackList){
			    		  model.addRow(new Object[] {method});
			    	    }
			            d.add(t);
			            d.setVisible(true);
		        	}
		        	catch(NullPointerException ex){
		        		System.out.println("Here");
		        		d.add(new JLabel("StackTrace not available for this method in the log file"));
		        		d.setVisible(true);
		        	}
		        }
		    }
		});
		
		
		JTable[] tables = {table1, table2};
		return tables;
	}
	
	
	
	
}
