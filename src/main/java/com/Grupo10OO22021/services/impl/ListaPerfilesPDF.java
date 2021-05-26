package com.Grupo10OO22021.services.impl;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.Grupo10OO22021.entities.Perfil;
import com.Grupo10OO22021.helpers.ViewRouteHelper;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component(ViewRouteHelper.PERFIL_INDEX)
public class ListaPerfilesPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Perfil> listaPerfil=(List<Perfil>) model.get("perfil");
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 40, 20);
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda= null;
		
		Font fuenteTitulo= FontFactory.getFont("Helvetica",16,Color.BLACK);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD ,12,Color.BLUE);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);
		
		celda = new PdfPCell(new Phrase ("LISTADO DE PERFILES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color (211,44,9));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(20);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaPerfiles= new PdfPTable(1);
		
		
		tablaPerfiles.setWidths(new float[] {2f});
		
		celda = new PdfPCell(new Phrase("NOMBRE PERFIL", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPerfiles.addCell(celda);
		
		
		
		
		for (Perfil rol : listaPerfil) {
			
			
			celda = new PdfPCell(new Phrase(rol.getNombreRol(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPerfiles.addCell(celda);
		
			
		}
		document.add(tablaTitulo);
		document.add(tablaPerfiles);
		
	}
	

}
