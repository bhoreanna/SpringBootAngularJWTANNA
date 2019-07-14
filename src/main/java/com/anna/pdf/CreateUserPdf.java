package com.anna.pdf;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.anna.component.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreateUserPdf {

	PdfPTable table = null;
	static int col=0;


	public byte[] creatingPDFDocument(List<User> users) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.out.println("Application is started");

		Document document = new Document(PageSize.A4);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
			System.out.println("writer is Object created");

			document.open();
			System.out.println("Doc is open");

			document.addCreator("anna");
			List<String> coloumnList =new ArrayList<>();
			coloumnList.add("USERNAME");
			coloumnList.add("PASSWORD");
			coloumnList.add("EMAIL");
			coloumnList.add("FIRSTNAME");
			coloumnList.add("LASTNAME");

			coloumnList.add("USERROLE");

			col=coloumnList.size();
			System.out.println("no of columns are :" + col);
			
			
			table=new PdfPTable(col);
			table.setWidthPercentage(100);
			table.setSpacingBefore(11f);
			table.setSpacingAfter(11f);
			PdfPCell cell=new PdfPCell(new Paragraph("User Report details"));
			cell.setColspan(col*5);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			for(String colName:coloumnList )
			{
				PdfPCell c1=new PdfPCell(new Paragraph(""+colName));
				c1.setBorderColorTop(BaseColor.GREEN);
				
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);	
			}
			coloumnList.clear();
			
			PdfPCell c1;
			for (User obj : users) {
				System.out.println("obj: " + obj);
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getUserName())));
				c1=setColorAndtoTable(c1);
				
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getPassword())));
				c1=setColorAndtoTable(c1);
				
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getEmail())));
				c1=setColorAndtoTable(c1);
				
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getFirstName())));
				c1=setColorAndtoTable(c1);
				
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getLastName())));
				c1=setColorAndtoTable(c1);
				
				c1=new PdfPCell(new Paragraph(new Paragraph(obj.getUserRole())));
				c1=setColorAndtoTable(c1);
			}
			
			
			
			

			document.add(table);
			
			System.out.println("Table is added");


			byteArrayOutputStream.write(byteArrayOutputStream.toByteArray());
			
			System.out.println("write in byteArrayOutputStream sucess");

			document.close();
			writer.close();
			System.out.println(" byteArrayOutputStream.toByteArray() " + byteArrayOutputStream.toByteArray());
			return byteArrayOutputStream.toByteArray();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		System.out.println("application is stopped");

		return byteArrayOutputStream.toByteArray();
	}


	private PdfPCell setColorAndtoTable(PdfPCell c1) {
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBorderColor(BaseColor.BLUE);		
		table.addCell(c1);
		return c1;
	}

}
