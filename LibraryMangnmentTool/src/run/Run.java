package run;


import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;

import common.service.DialogService;
import common.service.Factory;
import page.DashboardPage;

public class Run {

	public static void main(String[] args) {
		try {
			if(new FileReader("resources/hibernate.json")!=null){
			Factory factory =  new Factory();
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new DashboardPage("LibraryManagnmentTool","");
				}
			});
			}
		} catch (FileNotFoundException e) {
				EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new DashboardPage("LibraryManagnmentTool","newUser");
					}
				});
		}
		
	}

}
