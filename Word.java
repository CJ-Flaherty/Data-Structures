
public class Word{

	private String word; //the string associate with this Word object
	private String[] replaceoptions = new String[2500];
	private String replace;
	private String defreplace = this.word;
	private boolean ignore = false;
	private int linenumber; //not used
	private int index = 0;

	public Word(String w)
	{
		word = w;
		defreplace = this.word;
	}
	
	public void setWord(String w)
	{
		word = w;
	}
	
	public String getWord()
	{
		return word;
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	public void setReplace(String s) {
		replace = s;
	}
	
	public String getReplace() {
		return replace;
	}
	
	public void setReplaceOptions(String[] s) {
		replaceoptions = s;
	}
	
	public String[] getReplaceOptions() {
		return replaceoptions;
	}
	
	public void setIgnore(boolean tf) {
		ignore = tf;
	}
	
	public boolean getIgnore() {
		return ignore;
	}
	public void setLineNumber(int i) {
		linenumber = i;
	}
	public int getLineNumber() {
		return linenumber;
	}
	public void addSuggestion(String s) {
		replaceoptions[index] = s;
		index++;
	}
	
	public String getDefReplace() {
		//used if the word was not misspelled
		return defreplace;
	}
	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	
	/*
	 * equals method that compares two words
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}	
	
	

}
