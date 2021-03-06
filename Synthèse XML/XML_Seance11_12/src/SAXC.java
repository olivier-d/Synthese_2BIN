import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXC extends DefaultHandler {

	private boolean estCoureuse;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(estCoureuse) {
			System.out.println(new String(ch,start,length));
		}
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(estCoureuse) {
			this.estCoureuse = false;
			System.out.println("-----------------------------------------");
		}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if(qName.equals("coureur") && atts.getValue("sexe").equals("femme")) {
			this.estCoureuse = true;
		}
	}
	
}
