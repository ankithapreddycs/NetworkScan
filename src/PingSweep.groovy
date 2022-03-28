import com.fasterxml.jackson.databind.util.JSONPObject
import groovyjarjarantlr4.v4.misc.Graph
import netscape.javascript.JSObject
import org.xml.sax.InputSource
import org.xml.sax.SAXException

import javax.swing.text.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

class PingSweeper {
	static boolean ping(String ip) throws UnknownHostException, IOException {
		boolean state = false
		try {
			Process process = Runtime.getRuntime().exec(ip)
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
			if((reader.readLine()) != null){
				state = true
			}else {
				System.out.println("Host not reachable")
			}
			return state
		}catch (UnknownHostException e){
			e.printStackTrace()
		}catch(IOException e){
			e.printStackTrace()
		}
		return state
	}
	static String Traceroute(boolean state, String command){
		if (state) {
			try {
				Process process = Runtime.getRuntime().exec(command)
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(process.getInputStream()))
				String line
				while ((line = reader.readLine()) != null) {
					String[] data = System.out.println(line)
				//	System.out.println(data)
				}
				reader.close()
			} catch (IOException e) {
				e.printStackTrace()
			}
		}else{
			println("Host Not Reachable")
		}

	}

	/*static Document xml(String[] data)throws SAXException, ParserConfigurationException,IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance()
		DocumentBuilder builder = factory.newDocumentBuilder()
		return builder.parse(new InputSource(new StringReader(String[] data)))
	}*/

}
	static void main(String[] args){
		String ip = "ping 172.105.57.246"
		String command = "traceroute 172.105.57.246"
		boolean state = PingSweeper.ping(ip)
		String[] data = PingSweeper.Traceroute(state, command)
	}
