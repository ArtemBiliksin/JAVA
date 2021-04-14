
public class Message {
	
	String str = "";
	
	
	//����������� �������� ���, ������� ����������� ��� �������� �������.
	//��� ���, ������� �����������, ����� �� ������ ����� new ����� ����� ������.
	public Message(String str) {
		this.str = str;
	}
	
	
	// ���������� ���������� ����
	// ����� � ��� ������������������ �� ���� (������� ��� ����������), ������ ������� ����� ���� ������.
	public int countWords(){
		//String regex = "[^�-��-�a-zA-Z_-]";
		String regex = "[^�-��-�a-zA-Z-]";
		String[] words = str.split(regex);
		int countWords = 0;
		for (int i = 0; i < words.length; i++) {			
			if (!words[i].equals("-") && !words[i].equals("")) {
				countWords++;
			}
		}		
		return countWords;
	}
	
	
	// ���������� ������������ ������
	public String reverse() {
		String tmpStr = "";
		for (int i = str.length() - 1; i > -1; i--) {
			tmpStr = tmpStr + str.charAt(i);
		}		
		return tmpStr;
	}
	
	
	// ���������� ���-�� ��������� ������� � ������
	public int count(char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count ++;				
			}
		}
		return count;
	}
	
	
	// ���������� ����� (����� ��������� ����� ����� ������� ����� ���������, 
	// �� ����� ����� � �� ����, ����� ����� ����� �������� ��������, 
	// �������� �����, �����). ������.	
	// ������ ������� ����� 6655 �����, ���������� 6655; ������ ������� ����� ��,
	// ���������� ��.	
	public String seria() {		
		String result = "";
		String[] words = str.split(" +");
		for (int i = 0; i < words.length; i++) {
			if (words[i].toLowerCase().equals("�����")) {
				result += words[i+1] + "; ";
				i++;
			}
		}
		if (result.equals("")) {
			result = "����� �� �������";
		}
		return result;
	}
	
	// ���������� ����� (����� ��������� ����� �, �� ����� � ����� ������� � �� ����).
	// ������. ������ ������� ����� 6655  �1111 �����, ���������� 1111; 
	// ������ ������� ����� �� � 2345, ���������� 2345.	
	public String nomer() {		
		String result = "";
		String strCopy = str; 
		int index = strCopy.indexOf('�') + 1;	
		
		while(index > 0){			
			strCopy = strCopy.substring(index);
			int i = 0;
			
			while (strCopy.charAt(i) == ' '){				
				i++;
			}
			
			while (strCopy.charAt(i) != ' ') {				
				result += strCopy.charAt(i);
				i++;
			}
			
			result += "; ";			
			strCopy = strCopy.substring(i);
			index = strCopy.indexOf('�') + 1;
		}
		
		if (result.equals("")) {
			result = "������ �� �������;";
		}
		return result;
	}	
	
      
}

/*

// ���������� ����� (����� ��������� ����� ����� ������� ����� ���������, 
// �� ����� ����� � �� ����, ����� ����� ����� �������� ��������, 
// �������� �����, �����). ������.	
// ������ ������� ����� 6655 �����, ���������� 6655; ������ ������� ����� ��,
// ���������� ��.	
public String seria() {
	int strLength = str.length();
	String result = "����� �� �������";		
	String[] words =  str.split("[��][��][��][��][��] +");
	int lenWords = words.length;		
	if(lenWords > 1){
		result = "";
		for(int i = 0; i < lenWords; i++) {
			int index = words[i].indexOf(' ');
			if (index > 0){
				result = result + words[i].substring(0, index) + "; ";
			}				
		}
	}
	if (result.equals(" ")) {
		result = "����� �� �������";
	}
	return result;
}
	



// ���������� ����� (����� ��������� ����� �, �� ����� � ����� ������� � �� ����).
// ������. ������ ������� ����� 6655  �1111 �����, ���������� 1111; 
// ������ ������� ����� �� � 2345, ���������� 2345.	
public String nomer() {
	String[] words = str.split("� *");
	int lenWords = words.length;
	String result = "������ �� �������";		
	if(lenWords > 1) {
		result = "";
		for (int i = 0; i < lenWords; i++) {
			int index = words[i].indexOf(' ');
			if (index > 0) {
				result = result + words[i].substring(0, index) + "; ";
			}
		}			
	}
	if (result.equals("")) {
		result = "������ �� �������";
	}
	return result;
}

*/