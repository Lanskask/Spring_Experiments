package xmlwork;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.Format;

public class BuildXmlDoc {
    public static void main(String[] args) {
        BuildXmlDoc.buildXml2();
        BuildXmlDoc buildXmlDoc = new BuildXmlDoc();
        buildXmlDoc.run();
    }

    void run() {
//        this.buildXml();
    }

    public static void buildXml2() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            // ------------
            // <kml xmlns="http://www.opengis.net/kml/2.2"
            //      xmlns:gx="http://www.google.com/kml/ext/2.2"
            //      xmlns:kml="http://www.opengis.net/kml/2.2"
            //      xmlns:atom="http://www.w3.org/2005/Atom">
            Element rootElement = doc.createElement("kml");
            rootElement.setAttribute("xmlns", "http://www.opengis.net/kml/2.2");
            rootElement.setAttribute("xmlns:gx", "http://www.google.com/kml/ext/2.2");
            rootElement.setAttribute("xmlns:kml", "http://www.opengis.net/kml/2.2");
            rootElement.setAttribute("xmlns:atom", "http://www.w3.org/2005/Atom");
            doc.appendChild(rootElement);

                //     <Document>
                Element document = doc.createElement("Document");
                rootElement.appendChild(document);

                    //region <name>Пример KML.kml</name>
                    Element name1 = doc.createElement("name");
                    name1.setTextContent("Пример KML.kml");
                    document.appendChild(name1);
                    //endregion

                    // region <Style id="sn_ttm_Style">
                    // <Style id="sn_ttm_Style">
                    //     	<IconStyle>
                    //     		<Icon>
                    //     			<href>info_purple.png</href>
                    //     		</Icon>
                    //     	</IconStyle>
                    //    	<LineStyle>
                    //    		<color>66ffaa00</color>
                    //    		<width>5</width>
                    //  	</LineStyle>
                    // </Style>
                    Element style1 = doc.createElement("Style");
                    style1.setAttribute("id", "sn_ttm_Style");

                        Element iconStyle1 = doc.createElement("IconStyle");
                            Element icon1 = doc.createElement("Icon");
                                Element href1 = doc.createElement("href");
                                href1.setTextContent("info_purple.png");
                            icon1.appendChild(href1);
                        iconStyle1.appendChild(icon1);
                        Element lineStyle1 = doc.createElement("LineStyle");
                            Element color1 = doc.createElement("color");
                            color1.setTextContent("66ffaa00");
                            Element width1 = doc.createElement("width");
                            width1.setTextContent("5");
                            lineStyle1.appendChild(color1);
                            lineStyle1.appendChild(width1);
                        style1.appendChild(iconStyle1);
                        style1.appendChild(lineStyle1);
                    document.appendChild(style1);
                    //endregion <Style id="sn_ttm_Style">

                    //region <StyleMap id="ttm_Style">
                    //<StyleMap id="ttm_Style">
                    //    <Pair>
                    //        <key>normal</key>
                    //        <styleUrl>#sn_ttm_Style</styleUrl>
                    //    </Pair>
                    //    <Pair>
                    //        <key>highlight</key>
                    //        <styleUrl>#sh_ttm_Style</styleUrl>
                    //    </Pair>
                    //</StyleMap>
                    Element styleMap = doc.createElement("StyleMap");
                    style1.setAttribute("id", "ttm_Style");

                        Element pair1 = doc.createElement("Pair");
                            Element key1 = doc.createElement("key");
                              key1.setTextContent("normal");
                            Element styleUrl1 = doc.createElement("styleUrl");
                              styleUrl1.setTextContent("#sn_ttm_Style");
                            pair1.appendChild(key1);
                            pair1.appendChild(styleUrl1);
                        Element pair2 = doc.createElement("Pair");
                            Element key2 = doc.createElement("key");
                              key2.setTextContent("highlight");
                            Element styleUrl2 = doc.createElement("styleUrl");
                              styleUrl2.setTextContent("#sh_ttm_Style");
                            pair2.appendChild(key2);
                            pair2.appendChild(styleUrl2);
                        styleMap.appendChild(pair1);
                        styleMap.appendChild(pair2);
                    document.appendChild(styleMap);
                    //endregion

                    //region <Style id="sh_ttm_Style">
                    //<Style id="sh_ttm_Style">
                    //    <IconStyle>
                    //        <Icon>
                    //            <href>info.png</href>
                    //        </Icon>
                    //    </IconStyle>
                    //    <LineStyle>
                    //        <color>66ffaa00</color>
                    //        <width>5</width>
                    //    </LineStyle>
                    //</Style>
                    Element style2 = doc.createElement("Style");
                    style2.setAttribute("id", "sh_ttm_Style");

                        Element iconStyle2 = doc.createElement("IconStyle");
                            Element icon2 = doc.createElement("Icon");
                                Element href2 = doc.createElement("href");
                                href2.setTextContent("info.png");
                            icon1.appendChild(href2);
                        iconStyle1.appendChild(icon2);
                        Element lineStyle2 = doc.createElement("LineStyle");
                            Element color2 = doc.createElement("color");
                            color2.setTextContent("66ffaa00");
                            Element width2 = doc.createElement("width");
                            width2.setTextContent("5");
                            lineStyle2.appendChild(color2);
                            lineStyle2.appendChild(width2);
                        style2.appendChild(iconStyle2);
                        style2.appendChild(lineStyle2);
                    document.appendChild(style1);
                    //endregion

                    //region <Placemark>
                    //<Placemark>
                    //    <name>НТР</name>
                    //    <details_url>http://ntrlab.ru/</details_url>
                    //    <details_url_en>http://ntrlab.com/</details_url_en>
                    //    <styleUrl>#ttm_Style</styleUrl>
                    //    <Point>
                    //        <coordinates>37.64684,55.82817,0</coordinates>
                    //    </Point>
                    //</Placemark>
                    Element placemark = doc.createElement("Placemark");
                    Element name2 = doc.createElement("name");
                    name2.setTextContent("НТР");
                    Element details_url = doc.createElement("details_url");
                      details_url.setTextContent("НТР");
                    Element details_url_en = doc.createElement("details_url_en");
                      details_url_en.setTextContent("НТР");
                    Element styleUrl = doc.createElement("styleUrl");
                      styleUrl.setTextContent("v");
                    Element Point = doc.createElement("Point");
                        Element coordinates = doc.createElement("coordinates");
                        coordinates.setTextContent("37.64684,55.82817,0");
                        Point.appendChild(coordinates);
                    //endregion

            // ------------
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

//            StreamResult result = new StreamResult(new File("/Users/myXml/ScoreDetail.xml"));
            StreamResult result = new StreamResult(new File("D:\\Users\\smurtazin\\0_WORK\\Spring_Experiments\\ScoreDetail.xml"));
            transformer.transform(source, result);
            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();}
    }

    public static void buildXml3() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            // ------------
            Element rootElement = doc.createElement("kml");
            rootElement.setAttribute("xmlns", "http://www.opengis.net/kml/2.2");
            rootElement.setAttribute("xmlns:gx", "http://www.google.com/kml/ext/2.2");
            rootElement.setAttribute("xmlns:kml", "http://www.opengis.net/kml/2.2");
            rootElement.setAttribute("xmlns:atom", "http://www.w3.org/2005/Atom");
            doc.appendChild(rootElement);

            Element browser = doc.createElement("BROWSER");
            browser.setAttribute("version", "0.1");
            rootElement.appendChild(browser);
            browser.appendChild(doc.createTextNode("chrome"));
            rootElement.appendChild(browser);

            Element base = doc.createElement("BASE");
            base.appendChild(doc.createTextNode("http:fut"));
            rootElement.appendChild(base);

            Element employee = doc.createElement("EMPLOYEE");
            rootElement.appendChild(employee);

            Element empName = doc.createElement("EMP_NAME");
            empName.appendChild(doc.createTextNode("Anhorn, Irene"));
            employee.appendChild(empName);

            Element actDate = doc.createElement("ACT_DATE");
            actDate.appendChild(doc.createTextNode("20131201"));
            employee.appendChild(actDate);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

//            StreamResult result = new StreamResult(new File("/Users/myXml/ScoreDetail.xml"));
            StreamResult result = new StreamResult(new File("D:\\Users\\smurtazin\\0_WORK\\Spring_Experiments\\ScoreDetail.xml"));
            transformer.transform(source, result);
            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();}
    }

    /*    void buildXml() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
        Document document = dBuilder.newDocument(); //.parse(inputStream);
        document.

        Document doc = new Document();
        Element root = new Element("CONFIGURATION");

        Element child1 = new Element("BROWSER");
        child1.addContent("chrome");
        Element child2 = new Element("BASE");
        child1.addContent("http:fut");
        Element child3 = new Element("EMPLOYEE");
        child3.addContent(new Element("EMP_NAME").addContent("Anhorn, Irene"));

        root.addContent(child1);
        root.addContent(child2);
        root.addContent(child3);

        doc.setRootElement(root);

        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        outter.output(doc, new FileWriter(new File("myxml.xml")));
    }*/
}
