package by.epam.oop.main;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.oop.logic.Operations;
import by.epam.oop.parser.BikersDOMBuilder;
import by.epam.oop.parser.ParserBuilder;
import by.epam.oop.print.PrintResults;
import by.epam.oop.substance.clothes.Cloth;
import by.epam.oop.substance.motorcyclist.*;


public class Main {
	static {
		new DOMConfigurator().doConfigure("resources/log4j.xml",
				LogManager.getLoggerRepository());
	}
	static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		PrintResults printRes = new PrintResults();
		ParserBuilder parser = new 	BikersDOMBuilder();
		parser.buildMotorcyclistsList("resources/bikers.xml");
		ArrayList<Motorcyclist> motorcyclists =  parser.getMotorcyclists();
		printRes.printMotorcyclists(motorcyclists);
		
		System.out.println("\nGet sorted list of motorcyclist's clothes by price gap:");
		Motorcyclist motorcyclist = motorcyclists.get(0);
		ArrayList<Cloth> clothes = Operations.getClothesByPriceGap(motorcyclist, 30, 160);
		printRes.printMotorcyclistsCloth(clothes);
		
		System.out.println("\nGet sorted list of motorcyclists' clothes by weight:");
		Operations.sortAmmunitionByWeight(motorcyclists);
		printRes.printMotorcyclists(motorcyclists);
	}

}
