public class ShuffleCipher {
   private int shuffle;
   
   public ShuffleCipher(int shuffle){
      this.shuffle = shuffle;
   }
   
   public String shuffleMessage(String message, boolean encode){
      for(int i = 0; i < shuffle; ++i){
         if(encode){
            message = shuffle(message);
         }else{
            message = unshuffle(message);
         }
      }
      return message;
   }
   
   private String shuffle(String message){
      String split1, split2, encodedMessage = "";
      int loop = (message.length() % 2 == 0) ? message.length() / 2 : message.length() / 2 + 1;
      
      split1 = message.substring(0, message.length() / 2);
      split2 = message.substring(message.length() / 2);
      for(int i = 0; i < loop; ++i) {
         if(i < split1.length()) {
            encodedMessage += split1.charAt(i);
         }
         encodedMessage += split2.charAt(i);
      }
      return encodedMessage;
   }
   
   private String unshuffle(String message){
      String decodedMessage = "";
      int loop = (message.length() % 2 == 0) ? message.length() : message.length() - 1;
      
      for(int i = 0; i < loop; ++i) {//1st, 3rd, etc.
         decodedMessage += message.charAt(i);
         ++i;
      }
      
      for(int i = 1; i < loop; ++i) {//2nd, 4th, etc.
         decodedMessage += message.charAt(i);
         ++i;
      }

      if(message.length() % 2 == 1) { //adding last char for odd length message
         decodedMessage += message.charAt(message.length() - 1);
      }
      
      return decodedMessage;
   }
}