package by.epam.oop.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.oop.substance.clothes.*;
import by.epam.oop.substance.clothes.NegativeNumberException;
import by.epam.oop.substance.motorcyclist.Motorcyclist;



public class BikersDOMBuilder extends ParserBuilder {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Logger logger = Logger.getLogger(BikersDOMBuilder.class);
	public BikersDOMBuilder(){
		// Get the DOM Builder Factory
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void buildMotorcyclistsList(String fileName) {

		String resource = fileName;
		Document document = null;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(resource));
			document = builder.parse(inputStream);
		} catch (SAXException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		// motorcyclist
		Element root = document.getDocumentElement();
		NodeList bikersList = root.getChildNodes();
		Node nodeBikersList = bikersList.item(0);
		String bufString;
		motorcyclists = new ArrayList<Motorcyclist>();
		while (nodeBikersList != null) {
			if (nodeBikersList instanceof Element) {
				// create Biker
				Motorcyclist motorcyclist = new Motorcyclist();
				bufString = nodeBikersList.getAttributes().getNamedItem("name")
						.getNodeValue();
				motorcyclist.setName(bufString);
				NodeList clothesList = nodeBikersList.getChildNodes();
				Node nodeClothesList = clothesList.item(0);
				while (nodeClothesList != null) {
					if (nodeClothesList instanceof Element) {
						String nodeName = nodeClothesList.getNodeName();
						NodeList attrList = nodeClothesList.getChildNodes();
						MotorcyclistEnum currentEnum = MotorcyclistEnum.valueOf(nodeName.toUpperCase());
						MotorcyclistEnum currentEnumAttr = null;
						switch (currentEnum) {
						case HELMET:
							Helmet helmet = new Helmet();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node helmetAttr = nodeClothesList
										.getChildNodes().item(i);
								if (helmetAttr instanceof Element) {
									String nodeHelmetAttr = helmetAttr
											.getNodeName();
									String boofString = helmetAttr
											.getTextContent().trim();
									currentEnumAttr = MotorcyclistEnum.valueOf(nodeHelmetAttr.toUpperCase());
									switch (currentEnumAttr) {
									case ID:
										try {
											helmet.setId(Integer
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case WEIGHT:
										try {
											helmet.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case PRICE:
										try {
											helmet.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											e.printStackTrace();
											logger.error(e);
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case GLASS:
										helmet.setGlass(boofString);
										break;
									case COLOR:
										helmet.setColor(boofString);
										break;
									case FIRM:
										helmet.setFirm(boofString);
										break;
									case DESIGN:
										helmet.setDesign(boofString);
										break;
									case SIZECL:
										helmet.setSize(boofString);
										break;
									default:
										break;
									}
								}
							}
							motorcyclist.addCloth(helmet);
							break;
						case BOOTS:
							Boots boots = new Boots();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node bootsAttr = nodeClothesList
										.getChildNodes().item(i);
								if (bootsAttr instanceof Element) {
									String nodeBootsAttr = bootsAttr
											.getNodeName();
									String boofString = bootsAttr
											.getTextContent().trim();
									currentEnumAttr = MotorcyclistEnum.valueOf(nodeBootsAttr.toUpperCase());
									switch (currentEnumAttr) {
									case ID:
										try {
											boots.setId(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case WEIGHT:
										try {
											boots.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case PRICE:
										try {
											boots.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case FASTENERS:
										boots.setFasteners(boofString);
										break;
									case FIRM:
										boots.setFirm(boofString);
										break;
									default:
										break;
									}
								}
							}
							motorcyclist.addCloth(boots);
							break;
						case PANTS:
							Pants pants = new Pants();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node pantsAttr = nodeClothesList
										.getChildNodes().item(i);
								if (pantsAttr instanceof Element) {
									String nodePantsAttr = pantsAttr
											.getNodeName();
									String boofString = pantsAttr
											.getTextContent().trim();
									currentEnumAttr = MotorcyclistEnum.valueOf(nodePantsAttr.toUpperCase());
									switch (currentEnumAttr) {
									case ID:
										try {
											pants.setId(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case WEIGHT:
										try {
											pants.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case PRICE:
										try {
											pants.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;

									case KNEEPROTECTION:
										pants.setKneeProtection(boofString);
										break;
									case MATERIAL:
										pants.setMadeof(boofString);
										break;
									case SIZECL:
										pants.setSize(boofString);
										break;
									default:
										break;
									}
								}
							}
							motorcyclist.addCloth(pants);
							break;
						case JACKET:
							Jacket jacket = new Jacket();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node jacketAttr = nodeClothesList
										.getChildNodes().item(i);
								if (jacketAttr instanceof Element) {
									String nodeJacketAttr = jacketAttr
											.getNodeName();
									String boofString = jacketAttr
											.getTextContent().trim();
									currentEnumAttr = MotorcyclistEnum.valueOf(nodeJacketAttr.toUpperCase());
									switch (currentEnumAttr) {
									case ID:
										try {
											jacket.setId(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case WEIGHT:
										try {
											jacket.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case PRICE:
										try {
											jacket.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case MODEL:
										jacket.setModel(boofString);
										break;
									case MATERIAL:
										jacket.setMadeof(boofString);
										break;
									case SIZECL:
										jacket.setSize(boofString);
										break;
									default:
										break;
									}
								}
							}
							motorcyclist.addCloth(jacket);
							break;
						case GLOVES:
							Gloves gloves = new Gloves();
							for (int i = 0; i < attrList.getLength(); i++) {
								Node glovesAttr = nodeClothesList
										.getChildNodes().item(i);
								if (glovesAttr instanceof Element) {
									String nodeGlovesAttr = glovesAttr
											.getNodeName();
									String boofString = glovesAttr
											.getTextContent().trim();
									currentEnumAttr = MotorcyclistEnum.valueOf(nodeGlovesAttr.toUpperCase());
									switch (currentEnumAttr) {
									case ID:
										try {
											gloves.setId(Integer.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case WEIGHT:
										try {
											gloves.setWeight(Double
													.valueOf(boofString));
										} catch (NumberFormatException e1) {
											logger.error(e1);
											e1.printStackTrace();
										} catch (NegativeNumberException e1) {
											logger.error(e1);
											e1.printStackTrace();
										}
										break;
									case PRICE:
										try {
											gloves.setPrice(Double
													.valueOf(boofString));
										} catch (NumberFormatException e) {
											logger.error(e);
											e.printStackTrace();
										} catch (NegativeNumberException e) {
											logger.error(e);
											e.printStackTrace();
										}
										break;
									case VENTILATION:
										gloves.setVentilation(boofString);
										break;
									case SIZECL:
										gloves.setSize(boofString);
										break;
									default:
										break;
									}
								}
							}
							motorcyclist.addCloth(gloves);
							break;
						default:
							break;
						}
					}
					nodeClothesList = nodeClothesList.getNextSibling();
				}
				motorcyclists.add(motorcyclist);
			}
			nodeBikersList = nodeBikersList.getNextSibling();
		}
	}
	
	@Override
	public ArrayList<Motorcyclist> getMotorcyclists(){
		return motorcyclists;
	}
}
