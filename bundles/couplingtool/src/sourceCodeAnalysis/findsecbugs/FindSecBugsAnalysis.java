package sourceCodeAnalysis.findsecbugs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.AbstractResult;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;

public class FindSecBugsAnalysis implements CodeAnalysis {

	private static final String BUG_ENTRY_TAG = "BugInstance";
	private static final String METHOD_TAG = "Method";
	private static final String METHOD_NAME_KEY = "name";
	private static final String SOURCE_LINE_TAG = "SourceLine";
	private static final String CATEGORY_KEY = "category";
	private static final String CATEGORY_SECURITY = "SECURITY";
	private static final String PATTERN_KEY = "type";
	private static final String START_LINE_KEY = "start";
	private static final String END_LINE_KEY = "end";
	private static final String CLASS_NAME_KEY = "classname";

	private String sourceCodeAnalyisOutputLocation = "";
	
	@Override
	public List<AbstractResult> runCodeAnalysis(String sourceCodeFilePath,
			PatternWeaknessMapper patternWeaknessMapper, String sourceCodeAnalyisOutputLocation) {
		return domParsing(sourceCodeAnalyisOutputLocation, patternWeaknessMapper);
	}

	private List<AbstractResult> domParsing(String sourceCodeAnalyisOutputLocation, PatternWeaknessMapper patternWeaknessMapper) {
		List<AbstractResult> results = new ArrayList<AbstractResult>();

		
		Document document = null;
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Path path = Path.of(sourceCodeAnalyisOutputLocation).toAbsolutePath();
			File file = path.toFile();
			document = builder.parse(file);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodeList = document.getElementsByTagName(BUG_ENTRY_TAG);

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				if (!element.getAttribute(CATEGORY_KEY).equals(CATEGORY_SECURITY)) {
					continue;
				}

				String patternName = element.getAttribute(PATTERN_KEY);
				NodeList childNodes = node.getChildNodes();

				String className = "";
				String methodName = "";
				String startLine = "";
				String endLIne = "";

				for (int j = 0; j < childNodes.getLength(); j++) {
					Node childNode = childNodes.item(j);

					if (childNode.getNodeType() == Node.ELEMENT_NODE) {
						Element childElement = (Element) childNode;

						if (childElement.getTagName().equals(METHOD_TAG)) {
							className = childElement.getAttribute(CLASS_NAME_KEY);
							methodName = childElement.getAttribute(METHOD_NAME_KEY);
						}

						if (childElement.getTagName().equals(SOURCE_LINE_TAG)) {
							startLine = childElement.getAttribute(START_LINE_KEY);
							endLIne = childElement.getAttribute(END_LINE_KEY);
						}
					}
				}

				Weakness weakness = null;
				try {
					weakness = patternWeaknessMapper.mapToolPatternToWeakness(patternName);
				} catch (PatternViolationClassException | GenerationException | InputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (weakness == null) {
					continue;
				} else {
					AbstractResult result = new AbstractResult(weakness, methodName, className, Integer.parseInt(startLine),
							Integer.parseInt(endLIne));
					results.add(result);
				}

			}

		}

		return results;
	}

	public String getSourceCodeAnalyisOutputLocation() {
		return sourceCodeAnalyisOutputLocation;
	}

	public void setSourceCodeAnalyisOutputLocation(String sourceCodeAnalyisOutputLocation) {
		this.sourceCodeAnalyisOutputLocation = sourceCodeAnalyisOutputLocation;
	}
}
