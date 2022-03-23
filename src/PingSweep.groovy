

class PingSweeper {
	static boolean ping(String ip) throws UnknownHostException, IOException {
		boolean state = false
		try {
			InetAddress inet = InetAddress.getByName(ip)
			state = inet.isReachable(1000)
		}catch (UnknownHostException e){
			e.printStackTrace()
		}catch(IOException e){
			e.printStackTrace()
		}
		return state
	}
	static void Traceroute(boolean state, String command){
		if (state ) {
			try {
				Process process = Runtime.getRuntime().exec(command)
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(process.getInputStream()))
				String line
				while ((line = reader.readLine()) != null) {
					System.out.println(line)
				}
				reader.close()
			} catch (IOException e) {
				e.printStackTrace()
			}
		}else{
			println("Host Not Reachable")
		}
	}

}
	static void main(String[] args){
		String ip = "52.89.84.245"
		String command = "traceroute 52.89.84.245"
		boolean state = PingSweeper.ping(ip)
		PingSweeper.Traceroute(state, command)
	}
