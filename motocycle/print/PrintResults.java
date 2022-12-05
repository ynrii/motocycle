package by.epam.oop.print;

import java.util.ArrayList;

import by.epam.oop.logic.Operations;
import by.epam.oop.substance.clothes.Cloth;
import by.epam.oop.substance.motorcyclist.Motorcyclist;

public class PrintResults {
	
	public void printMotorcyclists(ArrayList<Motorcyclist> motorcyclists){
		for (Motorcyclist motorcyclist : motorcyclists) {
			System.out.println("Motorcyclist's name: " + motorcyclist.getName());
			System.out.println("Full weight of clothes: " + Operations.getFullWeight(motorcyclist));
			System.out.println("Full price of clothes: " + Operations.getFullPrice(motorcyclist));
			printMotorcyclistsCloth(motorcyclist);
			System.out.println();
		}
	}
	
	public void printMotorcyclistsCloth(Motorcyclist motorcyclist){
		ArrayList<Cloth> clothes = (ArrayList<Cloth>) motorcyclist.getClothList();
		for (Cloth cloth : clothes) {
			System.out.println(cloth);
		}
	}
	
	public void printMotorcyclistsCloth(ArrayList<Cloth> clothes ){
		for (Cloth cloth : clothes) {
			System.out.println(cloth);
		}
	}
	
	
}
