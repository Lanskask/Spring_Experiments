package xmlwork;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.*;
import xmlwork.pojos.Placemark;
import xmlwork.pojos.Coord;
import xmlwork.pojos.Point;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseXml {

    List<Coord> coords = new ArrayList<>();
    List<Placemark> placemarks = new ArrayList<>();

    // ----------
    private String xmlText2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
            "<kml xmlns=\"http://www.opengis.net/kml/2.2\" " +
            "xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\"> <Document> <name>Пример KML.kml</name> <Style id=\"sn_ttm_Style\"> <IconStyle> <Icon> <href>info_purple.png</href> </Icon> </IconStyle> <LineStyle> <color>66ffaa00</color> <width>5</width> </LineStyle> </Style> <StyleMap id=\"ttm_Style\"> <Pair> <key>normal</key> <styleUrl>#sn_ttm_Style</styleUrl> </Pair> <Pair> <key>highlight</key> <styleUrl>#sh_ttm_Style</styleUrl> </Pair> </StyleMap> <Style id=\"sh_ttm_Style\"> <IconStyle> <Icon> <href>info.png</href> </Icon> </IconStyle> <LineStyle> <color>66ffaa00</color> <width>5</width> </LineStyle> </Style> <Placemark> <name>НТР</name> <details_url>http://ntrlab.ru/</details_url> <details_url_en>http://ntrlab.com/</details_url_en> <parameters> <parameter> <key>description</key> <value>Привет Мир!</value> </parameter> <parameter> <key>description_en</key> <value>Hello World</value> </parameter> </parameters> <styleUrl>#ttm_Style</styleUrl> <Point> <coordinates>37.64684,55.82817,0</coordinates> </Point> </Placemark> </Document> </kml>";

    private String xmlText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<kml xmlns=\"http://www.opengis.net/kml/2.2\" \n" +
            "     xmlns:gx=\"http://www.google.com/kml/ext/2.2\" \n" +
            "     xmlns:kml=\"http://www.opengis.net/kml/2.2\" \n" +
            "     xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
            "    <Document>\n" +
            "        <name>Пример KML.kml</name>\n" +
            "        <Style id=\"sn_ttm_Style\">\n" +
            "        <IconStyle><Icon><href>info_purple.png</href></Icon></IconStyle><LineStyle><color>66ffaa00</color><width>5</width></LineStyle>\n" +
            "        </Style>\n" +
            "        <StyleMap id=\"ttm_Style\">\n" +
            "            <Pair>\n" +
            "                <key>normal</key>\n" +
            "                <styleUrl>#sn_ttm_Style</styleUrl>\n" +
            "            </Pair>\n" +
            "            <Pair>\n" +
            "                <key>highlight</key>\n" +
            "                <styleUrl>#sh_ttm_Style</styleUrl>\n" +
            "            </Pair>\n" +
            "        </StyleMap>\n" +
            "        <Style id=\"sh_ttm_Style\">\n" +
            "        <IconStyle><Icon><href>info.png</href></Icon></IconStyle><LineStyle><color>66ffaa00</color><width>5</width></LineStyle>\n" +
            "        </Style>\n" +
            "\n" +
            "        <Placemark>\n" +
            "            <name>НТР</name>\n" +
            "            <details_url>http://ntrlab.ru/</details_url>\n" +
            "            <details_url_en>http://ntrlab.com/</details_url_en>\n" +
            "            <parameters>\n" +
            "                <parameter>\n" +
            "                    <key>description</key>\n" +
            "                    <value>Привет Мир!</value>\n" +
            "                </parameter>\n" +
            "                <parameter>\n" +
            "                    <key>description_en</key>\n" +
            "                    <value>Hello World</value>\n" +
            "                </parameter>\n" +
            "            </parameters>\n" +
            "            <styleUrl>#ttm_Style</styleUrl>\n" +
            "            <Point>\n" +
            "                <coordinates>37.64684,55.82817,0</coordinates>\n" +
            "            </Point>\n" +
            "        </Placemark>\n" +
            "\n" +
            "        <Placemark>\n" +
            "            <name>НТР</name>\n" +
            "            <details_url>http://ntrlab.ru/</details_url>\n" +
            "            <details_url_en>http://ntrlab.com/</details_url_en>\n" +
            "            <parameters>\n" +
            "                <parameter>\n" +
            "                    <key>description</key>\n" +
            "                    <value>Привет Мир!</value>\n" +
            "                </parameter>\n" +
            "                <parameter>\n" +
            "                    <key>description_en</key>\n" +
            "                    <value>Hello World</value>\n" +
            "                </parameter>\n" +
            "            </parameters>\n" +
            "            <styleUrl>#ttm_Style</styleUrl>\n" +
            "            <Point>\n" +
            "                <coordinates>37.64684,55.82817,0</coordinates>\n" +
            "            </Point>\n" +
            "        </Placemark>\n" +
            "    </Document>\n" +
            "</kml>";

    private String xmlTextTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<kml xmlns=\"http://www.opengis.net/kml/2.2\" \n" +
            "     xmlns:gx=\"http://www.google.com/kml/ext/2.2\" \n" +
            "     xmlns:kml=\"http://www.opengis.net/kml/2.2\" \n" +
            "     xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
            "    <Document>\n" +
            "        <name>Пример KML.kml</name>\n" +
            "        <Style id=\"sn_ttm_Style\">\n" +
            "        <IconStyle><Icon><href>info_purple.png</href></Icon></IconStyle><LineStyle><color>66ffaa00</color><width>5</width></LineStyle>\n" +
            "        </Style>\n" +
            "        <StyleMap id=\"ttm_Style\">\n" +
            "            <Pair>\n" +
            "                <key>normal</key>\n" +
            "                <styleUrl>#sn_ttm_Style</styleUrl>\n" +
            "            </Pair>\n" +
            "            <Pair>\n" +
            "                <key>highlight</key>\n" +
            "                <styleUrl>#sh_ttm_Style</styleUrl>\n" +
            "            </Pair>\n" +
            "        </StyleMap>\n" +
            "        <Style id=\"sh_ttm_Style\">\n" +
            "        <IconStyle><Icon><href>info.png</href></Icon></IconStyle><LineStyle><color>66ffaa00</color><width>5</width></LineStyle>\n" +
            "        </Style>\n" +
            "        <Placemark>\n" +
            "            <name>НТР</name>\n" +
            "            <details_url>http://ntrlab.ru/</details_url>\n" +
            "            <details_url_en>http://ntrlab.com/</details_url_en>\n" +
            "            <parameters>\n" +
            "                <parameter>\n" +
            "                    <key>description</key>\n" +
            "                    <value>Привет Мир!</value>\n" +
            "                </parameter>\n" +
            "                <parameter>\n" +
            "                    <key>description_en</key>\n" +
            "                    <value>Hello World</value>\n" +
            "                </parameter>\n" +
            "            </parameters>\n" +
            "            <styleUrl>#ttm_Style</styleUrl>\n" +
            "            <Point>\n" +
            "%s" +
            "            </Point>\n" +
            "        </Placemark>\n" +
            "    </Document>\n" +
            "</kml>";

    private String xmlStaff = "<?xml version=\"1.0\"?>\n" +
            "<company>\n" +
            "\t<staff id=\"1001\">\n" +
            "\t\t<firstname>yong</firstname>\n" +
            "\t\t<lastname>mook kim</lastname>\n" +
            "\t\t<nickname>mkyong</nickname>\n" +
            "\t\t<salary>100000</salary>\n" +
            "\t</staff>\n" +
            "\t<staff id=\"2001\">\n" +
            "\t\t<firstname>low</firstname>\n" +
            "\t\t<lastname>yin fong</lastname>\n" +
            "\t\t<nickname>fong fong</nickname>\n" +
            "\t\t<salary>200000</salary>\n" +
            "\t</staff>\n" +
            "</company>";

    public static void main(String[] args) {
        ParseXml parseXml = new ParseXml();
        parseXml.run();
    }

    void run() {
        this.strToXml(this.xmlText);
        this.strToXmlAllPlcMarks(this.xmlText);
//        this.strToXml(this.xmlStaff);
//        this.loopXml(this.xmlStaff);
//        this.loopXml(this.xmlText);

//        this.testBuildingXmlViaStrFormat();
        this.printArray(this.coords);
    }

    void testBuildingXmlViaStrFormat() {
        this.printArray(this.coords);
        Placemark placemark = new Placemark();
        this.coords.add(new Coord(56.2, 35.6));
        this.coords.add(new Coord(5.2, 20.1));
        this.coords.add(new Coord(8.91, 6.1));

        placemark.point = new Point(this.coords);
        placemark.point.coordinates = this.coords;

        System.out.println(this.buildNewXmlKml(placemark));
    }

    void printArray(List<Coord> list) {
        System.out.println("--- It's a List<Coord> list: ");
        for(Coord elem: list) System.out.println("lan: " + elem.lan + "; lon: " + elem.lon);
    }

    /*public static Document stringToXml(String xml) {
        Document doc;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
            doc = builder.parse(is);
        } catch (ParserConfigurationException pce) {
            System.out.println("It's a ParserConfigurationException");
        } catch (IOException ioe) {
            System.out.println("It's a IOException");
        } catch (SAXException se) {
            System.out.println("It's a SAXException");
        }
        return doc;
    }*/

    /*    public Document parseXmlFromString(String xmlString){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
            document = builder.parse(inputStream);
            return document;
        } catch (ParserConfigurationException pce) {
            throw System.out.println("It's a ParserConfigurationException");
        } catch (IOException ioe) {
            System.out.println("It's a IOException");
        } catch (SAXException se) {
            System.out.println("It's a SAXException");
        }
        return document;
    }*/

//    String buildNewXmlKml(List<Coord> coords) {
    String buildNewXmlKml(Placemark placemark) {
        StringBuilder sb = new StringBuilder();
        for(Coord coord: placemark.point.coordinates) {
            sb.append(String.format("                <coordinates>%s,%s</coordinates>\n", coord.lan, coord.lon));
        }
        sb.append("\n");
        return String.format(this.xmlTextTemplate,/* details_url,  details_url_en, *//*coordinates*/sb.toString());
    }



    public void strToXml(String xmlString) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
            Document document = dBuilder.parse(inputStream);

            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("coordinates");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    this.coords.add(this.splitCoords(nNode.getTextContent()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void strToXmlAllPlcMarks(String xmlString) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
            Document document = dBuilder.parse(inputStream);

            document.getDocumentElement().normalize();
            Placemark placemark = new Placemark();
            NodeList nListPlcmrks = document.getElementsByTagName("Placemark");

            // --------------------
            for (int temp = 0; temp < nListPlcmrks.getLength(); temp++) {
                Element namesElement = (Element) nListPlcmrks.item(temp);
//                NodeList nListNames = namesElement.getElementsByTagName("name");
                NodeList nListDetailsRu = namesElement.getElementsByTagName("details_url");
                NodeList nListDetailsEn = namesElement.getElementsByTagName("details_url_en");
                NodeList nListCoords = namesElement.getElementsByTagName("coordinates");
                NodeList nListDescrNames = namesElement.getElementsByTagName("value");

                /*if(nListNames.getLength() > 0) {
                    for (int i = 0; i < nListNames.getLength(); i++) {
                        System.out.println(nListNames.item(i).getTextContent());
                    }
                }*/

                /*placemark.setName(nListNames.item(0).getTextContent());
                placemark.setDetailsUrl(nListDetailsRu.item(0).getTextContent());
                placemark.setDetailsUrlEn(nListDetailsEn.item(0).getTextContent());*/

                placemark.setRuName(nListDescrNames.item(0).getTextContent());
                placemark.setEnName(nListDescrNames.item(1).getTextContent());
                placemark.setRuUrl(nListDetailsRu.item(0).getTextContent());
                placemark.setRuUrl(nListDetailsEn.item(0).getTextContent());

                placemark.setLat(Double.parseDouble(
                        this.splitCoordsStr(nListCoords.item(0).getTextContent())[0]
                ));
                placemark.setLon(Double.parseDouble(
                        this.splitCoordsStr(nListCoords.item(0).getTextContent())[1]
                ));
                placemark.setAlt(Double.parseDouble(
                        this.splitCoordsStr(nListCoords.item(0).getTextContent())[2]
                ));
            }
            this.placemarks.add(placemark);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // --------------------
    }

    String[] splitCoordsStr(String coordStr) {
        return coordStr.split(",");
    }

    Coord splitCoords(String coordStr) {
        String[] parts = coordStr.split(",");
        return new Coord(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
    }

    public void strToXml2(String xmlString) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
            Document document = dBuilder.parse(inputStream);
//            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            document.getDocumentElement().normalize();
            System.out.println("Root element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("coordinates");
            System.out.println("NList length: " + nList.getLength());
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
                    System.out.println("nNode content: " + nNode.getTextContent());
                    /*System.out.println(eElement.getElementsByTagName("firstname").item(0).getTextContent());
//                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("coordinates").item(0).getTextContent());*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loopXml(String xmlString) {
        try {
//            File file = new File("/Users/mkyong/staff.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
            Document doc = dBuilder.parse(inputStream);
//            Document doc = dBuilder.parse(file);
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNote(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) { // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());
                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes(); // get attributes names and values

                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes()) { // loop again if has child nodes
                    printNote(tempNode.getChildNodes());
                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
            }
        }
    }

}
