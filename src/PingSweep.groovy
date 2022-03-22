

class PingSweeper {
	static void main(String[] args){
		String command = "ping 172.217.31.206"
		try{
			Process process = Runtime.getRuntime().exec(command)
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()))
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println(line)
			}
			reader.close()
		}catch(IOException e){
			e.printStackTrace()
		}
	}


}
