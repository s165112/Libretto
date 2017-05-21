package it.polito.tdp.libretto.db;

import it.polito.tdp.libretto.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EsameDAO dao = new EsameDAO();
		
		Esame e1 = dao.find("03FYZ");
		System.out.println(e1);
		
		Esame e2 = dao.find("9999");
		System.out.println(e2);
		
		Esame e3 = new Esame("99qqq", "Corso di prova", "A scelta");
		dao.create(e3);
		System.out.println(e3);
		
	}

}
