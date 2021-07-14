package lab_9;
import java.util.HashSet;
import java.util.Iterator;

public class UniqueWords extends Words {
	public UniqueWords(String arg) {
        super(arg);
        validateWords(arg);
    }

    public void append(String s){
        for (String word : toArray(s)){
            if (!isIn(word))
                setString(arg + " " + word);
        }
    }

    public void append(UniqueWords uwds){
        for (String s : toArray(uwds.arg)){
            if (!isIn(s)) append(s);
        }
    }

    public void append(Words wds){
        for (String s : toArray(wds.arg)){
            if (!isIn(s)) append(s);
        }
    }

    public UniqueWords common(String s){
        return new UniqueWords(getUniqueWords(s));
    }

    public UniqueWords common(UniqueWords uwds){
        return new UniqueWords(getUniqueWords(uwds.arg));
    }

    public UniqueWords common(Words wds){
        return new UniqueWords(getUniqueWords(wds.arg));
    }

    private String getUniqueWords(String s){
        String[] words = toArray(s);
        String commonWords = "";
        for (int i = 0; i < words.length; i++){
            if (isIn(words[i])){
                if (i > 0)
                    commonWords += " " + words[i];
                else
                    commonWords += words[i];
            }
        }
        return commonWords;
    }

    public boolean isIn(String s){
        String[] args = toArray(arg);
        for (String word : args){
            if (s.equals(word)) return true;
        }
        return false;
    }

    private void validateWords(String words){
        String[] other = toArray(words);
        HashSet<String> unique = new HashSet<String>();
        for (String word : other)
            unique.add(word);

        Iterator<String> it = unique.iterator();
        String finalWords = it.next();
        while (it.hasNext())
            finalWords = finalWords + " " + it.next();

        setString(finalWords);
    }

    public boolean equals(Object ob){
        if (ob == this) return true;
        if (!(ob instanceof UniqueWords)) return false;
        UniqueWords otherWords = (UniqueWords) ob;
        String[] thisArr = getSortedWordsArray(arg);
        String[] otherArr = getSortedWordsArray(otherWords.arg);
        if (thisArr.length != otherArr.length) return false;
        for (int i = 0; i < thisArr.length; i++){
            if (!thisArr[i].equals(otherArr[i])) return false;
        }
        return true;
    }

}



