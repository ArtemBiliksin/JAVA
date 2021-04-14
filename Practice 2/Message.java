
public class Message {
	
	String str = "";
	
	
	//конструктор содержит код, который выполняется при создании объекта.
	//Это код, который запускается, когда вы пишете слово new перед типом класса.
	public Message(String str) {
		this.str = str;
	}
	
	
	// возвращает количество слов
	// Слово — это последовательность из букв (русских или английских), внутри которой могут быть дефисы.
	public int countWords(){
		//String regex = "[^а-яА-Яa-zA-Z_-]";
		String regex = "[^а-яА-Яa-zA-Z-]";
		String[] words = str.split(regex);
		int countWords = 0;
		for (int i = 0; i < words.length; i++) {			
			if (!words[i].equals("-") && !words[i].equals("")) {
				countWords++;
			}
		}		
		return countWords;
	}
	
	
	// возвращает перевернутую строку
	public String reverse() {
		String tmpStr = "";
		for (int i = str.length() - 1; i > -1; i--) {
			tmpStr = tmpStr + str.charAt(i);
		}		
		return tmpStr;
	}
	
	
	// возвращает кол-во вхождений символа в строку
	public int count(char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count ++;				
			}
		}
		return count;
	}
	
	
	// возвращает серию (серия находится после слова «серия» между пробелами, 
	// но серии может и не быть, слово серия может различно написано, 
	// например Серия, сеРИя). Пример.	
	// Строка Паспорт СеРия 6655 выдан, возвращает 6655; строка Паспорт сеРия АА,
	// возвращает АА.	
	public String seria() {		
		String result = "";
		String[] words = str.split(" +");
		for (int i = 0; i < words.length; i++) {
			if (words[i].toLowerCase().equals("серия")) {
				result += words[i+1] + "; ";
				i++;
			}
		}
		if (result.equals("")) {
			result = "серии не найдено";
		}
		return result;
	}
	
	// возвращает номер (номер находится после №, но после № может пробела и не быть).
	// Пример. Строка Паспорт СеРия 6655  №1111 выдан, возвращает 1111; 
	// строка Паспорт сеРия АА № 2345, возвращает 2345.	
	public String nomer() {		
		String result = "";
		String strCopy = str; 
		int index = strCopy.indexOf('№') + 1;	
		
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
			index = strCopy.indexOf('№') + 1;
		}
		
		if (result.equals("")) {
			result = "номера не найдено;";
		}
		return result;
	}	
	
      
}

/*

// возвращает серию (серия находится после слова «серия» между пробелами, 
// но серии может и не быть, слово серия может различно написано, 
// например Серия, сеРИя). Пример.	
// Строка Паспорт СеРия 6655 выдан, возвращает 6655; строка Паспорт сеРия АА,
// возвращает АА.	
public String seria() {
	int strLength = str.length();
	String result = "серии не найдено";		
	String[] words =  str.split("[сС][еЕ][рР][иИ][яЯ] +");
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
		result = "серии не найдено";
	}
	return result;
}
	



// возвращает номер (номер находится после №, но после № может пробела и не быть).
// Пример. Строка Паспорт СеРия 6655  №1111 выдан, возвращает 1111; 
// строка Паспорт сеРия АА № 2345, возвращает 2345.	
public String nomer() {
	String[] words = str.split("№ *");
	int lenWords = words.length;
	String result = "номера не найдено";		
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
		result = "номера не найдено";
	}
	return result;
}

*/