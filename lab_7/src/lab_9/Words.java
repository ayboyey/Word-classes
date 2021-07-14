package lab_9;

import java.util.Arrays;

public class Words {
	 protected String arg = "";

	    public Words(String arg){
	        if (!(arg == null)){
	            this.arg = arg;
	            setString(cleanWords(arg));
	        }
	    }

	    public boolean equals(Object other){
	        if (other == this) return true;
	        if (!(other instanceof Words) || (other instanceof UniqueWords)) return false;
	        Words otherWords = (Words) other;
	        String[] thisArr = getSortedWordsArray(arg);
	        String[] otherArr = getSortedWordsArray(otherWords.arg);
	        if (thisArr.length != otherArr.length) return false;
	        for (int i = 0; i < thisArr.length; i++){
	            if (!thisArr[i].equals(otherArr[i])) return false;
	        }
	        return true;
	    }

	    public void clear(){
	        setString("");
	    }

	    public void append(String s){
	        setString(arg + " " + s);
	    }

	    public void append(Words wrd){
	        setString(arg + " " + wrd.arg);
	    }

	    public String[] maxLenWords(){
	        return minMaxWords(true);
	    }

	    public String[] minLenWords(){
	        return minMaxWords(false);
	    }

	    private String[] minMaxWords(boolean max){
	        String[] arrArg = toArray(arg);
	        int len = max ? 0 : Integer.MAX_VALUE;
	        int howMany = 0;
	        for (String s : arrArg){
	            if ((max ? s.length() > len : s.length() < len))  len = s.length();
	        }
	        for (String s : arrArg){
	            if (s.length() == len) howMany++;
	        }

	        String[] arr = new String[howMany];
	        int index = 0;
	        for (String s : arrArg){
	            if (s.length() == len) {
	                arr[index] = s;
	                index++;
	            }
	        }
	        return arr;
	    }

	    public String[] getSortedWordsArray(String words){
	        String[] other = toArray(words);
	        Arrays.sort(other);
	        return other;
	    }

	    public String[] toArray(String words){
	        return words.split("[\\s\\.?!:,]+");
	    }

	    protected String cleanWords(String words){
	        String[] other = toArray(words);
	        String clean = other[0];
	        for (int i = 1; i < other.length; i++)
	            clean = clean + " " + other[i];
	        return clean;
	    }

	    public void setString(String s){
	        arg = s;
	    }

	    @Override
	    public String toString(){
	        return Arrays.toString(toArray(arg));
	    }
	}


