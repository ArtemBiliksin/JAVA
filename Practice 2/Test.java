import java.util.Scanner;
//import javax.swing.*;

public class Test {
	public static void main(String [] args)
	 {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();	
		Message msg = new Message(str);
		
		
		System.out.println("�������� ���������: " + str);
		System.out.println("���������� ���� � ��������� ����� " + msg.countWords() + ";");
		System.out.println();
		
		System.out.println("�������� ���������:     " + str + ".");
		System.out.println("������������ ���������: " + msg.reverse() + ";");
		System.out.println();
		
		System.out.println("�������� ���������: " + str + ".");
		System.out.println("���������� ��������� ������� 'c' � ��������� ����� " + msg.count('c') + ";");
		System.out.println();
		
		System.out.println("�������� ���������: " + str + ".");
		System.out.println("����� � ���������: " + msg.seria());
		System.out.println();
		
		System.out.println("�������� ���������: " + str + ".");
		System.out.println("������ � ���������: " + msg.nomer());
		System.out.println();
		
		

	}
}
