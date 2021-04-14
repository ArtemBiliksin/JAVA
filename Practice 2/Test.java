import java.util.Scanner;
//import javax.swing.*;

public class Test {
	public static void main(String [] args)
	 {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();	
		Message msg = new Message(str);
		
		
		System.out.println("Исходное сообщение: " + str);
		System.out.println("Количество слов в сообщении равно " + msg.countWords() + ";");
		System.out.println();
		
		System.out.println("Исходное сообщение:     " + str + ".");
		System.out.println("Перевернутое сообщение: " + msg.reverse() + ";");
		System.out.println();
		
		System.out.println("Исходное сообщение: " + str + ".");
		System.out.println("Количество вхождений символа 'c' в сообщение равно " + msg.count('c') + ";");
		System.out.println();
		
		System.out.println("Исходное сообщение: " + str + ".");
		System.out.println("Серии в сообщении: " + msg.seria());
		System.out.println();
		
		System.out.println("Исходное сообщение: " + str + ".");
		System.out.println("Номера в сообщении: " + msg.nomer());
		System.out.println();
		
		

	}
}
