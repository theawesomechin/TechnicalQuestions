
public class StringCompression {
    public static void main(String[] args){
        System.out.println(compressString("aabccccaaa"));
        System.out.println(compressString("aAaAAAAaaabybccccaaa"));
        
    }
    
    public static String compressString(String unAlteredString){
        String compressedString = "";
        int originalStringLength = unAlteredString.length();
        for(int i = 0; i < originalStringLength; i++){
            char checkDup = unAlteredString.charAt(i);
            int countOfDup = 1;
            compressedString += unAlteredString.charAt(i);
            try{
                while(i+1 < originalStringLength && checkDup == unAlteredString.charAt(i+1)){
                    ++i;
                    countOfDup++;
                }
            }
            catch(StringIndexOutOfBoundsException e){
                System.out.println("End Of String exception caught");
            }
            finally{
            compressedString += countOfDup;
            }
        }
        if(originalStringLength == compressedString.length()){
            return unAlteredString;
        }
        else
            return compressedString;
    }
}
