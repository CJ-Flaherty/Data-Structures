
public class Message {
	private String encoded, decoded;
	
	public Message(String encoded) {
		this.encoded = encoded;
	}
	
	public void setencoded(String code) {
		this.encoded = code;
	}

	public void setdecoded(String code) {
		this.decoded = code;
	}
	
	public String getencoded(){
		return this.encoded;
		
	}
	
	public String getdecoded() {
		return this.decoded;
	}

}

