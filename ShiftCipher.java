public class ShiftCipher {
   private int shift;
   
   public ShiftCipher(int shift){
      this.shift = shift;
   }
   
   public String shift(String message, boolean encode){
      String newMessage = "";
      
      if(encode){
         for(int i = 0; i < message.length(); ++i) {
            newMessage += shiftChar(message.charAt(i), true);
         }
      }else{
         for(int i = 0; i < message.length(); ++i) {;
            newMessage += shiftChar(message.charAt(i), false);
         }
      }
      return newMessage;
   }
   
   private char shiftChar(char currentChar, boolean encode){
      int charAscii = (int)currentChar;
      
      if(encode){
         if(charAscii + shift > 126){
            charAscii -= 93;
            charAscii += shift;
         }else{
            charAscii += shift;
         }
      }else{
        if(charAscii - shift < 33){
            charAscii += 93;
            charAscii -= shift;
         }else{
            charAscii -= shift;
         }
      }
      return (char)charAscii;
   }
}