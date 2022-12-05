package by.epam.oop.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam.oop.comparator.ClothComparator;
import by.epam.oop.substance.clothes.Cloth;
import by.epam.oop.substance.motorcyclist.Motorcyclist;

public class Operations {
	public static ArrayList<Cloth> getClothesByPriceGap(Motorcyclist biker,
			double minPrice, double maxPrice) {
		ArrayList<Cloth> clothes = new ArrayList<Cloth>();
		for (Cloth cloth : biker.getClothList()) {
			if (cloth.getPrice() <= maxPrice && cloth.getPrice() >= minPrice) {
				clothes.add(cloth);
			}
		}
		return clothes;
	}

	public static List<Motorcyclist> sortAmmunitionByWeight(
			List<Motorcyclist> bikers) {
		Comparator<Cloth> comparator = new ClothComparator();
		for (Motorcyclist motorcyclist : bikers) {
			Collections.sort(motorcyclist.getClothList(), comparator);
		}
		return bikers;
	}
	/*вынести все операции в отдельный пакет и класс*/
	public static double getFullWeight(Motorcyclist biker) {
		double fullWeight = 0;
		for (Cloth cloth : biker.getClothList()) {
			fullWeight += cloth.getWeight();
		}
		return fullWeight;
	}

	public static double getFullPrice(Motorcyclist biker) {
		double fullPrice = 0;
		for (Cloth cloth : biker.getClothList()) {
			fullPrice += cloth.getPrice();
		}
		return fullPrice;
	}


}
