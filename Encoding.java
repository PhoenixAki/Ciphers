import java.util.Scanner;
import java.util.InputMismatchException;

public class Encoding{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      String userInput, encodedMessage, decodedMessage;
      int shift = 1, shuffle = 1;
      
      System.out.print("Please enter the string you would like to encode.\nEncoding is done via substitution, shuffle, then another substitution: ");
      userInput = keyboard.nextLine();
      
      try{
         System.out.print("Please enter the value by which you would like to shift the letters: ");
         shift = keyboard.nextInt();
         System.out.print("Please enter the number of times you would like to shuffle the message: ");
         shuffle = keyboard.nextInt();
         keyboard.nextLine();
      }catch(InputMismatchException e){
         System.out.println("Invalid input - message will be shifted the default number of times (1 shift, 1 shuffle).");
      }
      
      ShiftCipher shiftCipher = new ShiftCipher(shift);
      ShuffleCipher shuffleCipher = new ShuffleCipher(shuffle);
      
      //substitution, shuffle, then another substitution
      encodedMessage = shiftCipher.shift(userInput, true);
      encodedMessage = shuffleCipher.shuffleMessage(encodedMessage, true);
      encodedMessage = shiftCipher.shift(encodedMessage, true);
      System.out.println("Result of encoding " + userInput + ": " + encodedMessage);
      
      System.out.println(encodedMessage + " will now be decoded to its original state. Decoding is done in the same way as encoding, but reversed.");
      
      decodedMessage = shiftCipher.shift(encodedMessage, false);
      decodedMessage = shuffleCipher.shuffleMessage(decodedMessage, false);
      decodedMessage = shiftCipher.shift(decodedMessage, false);
      System.out.println("Result of decoding " + encodedMessage + ": " + decodedMessage);
   }
}