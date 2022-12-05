package by.epam.oop.comparator;

import java.util.Comparator;

import by.epam.oop.substance.clothes.*;
public class ClothComparator implements Comparator<Cloth>{

	@Override
	public int compare(Cloth o1, Cloth o2) {
		double weight1 = o1.getWeight();
		double weight2 = o2.getWeight();
		if(weight1 < weight2){
			return -1;
		}else if (weight1 == weight2){
			return 0;
		}else{
			return 1;
		}
	}


}
