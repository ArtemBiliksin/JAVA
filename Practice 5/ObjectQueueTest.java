import java.io.*;


public class ObjectQueueTest {
    public static void main(String[] arg) {

        try{
            File myFile = new File("C:\\Users\\Artem.Biliksin\\Desktop\\Java1\\Practice\\Practice. Full\\src\\Practice5\\f.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter writer = new FileWriter("C:\\Users\\Artem.Biliksin\\Desktop\\Java1\\Practice\\Practice. Full\\src\\Practice5\\g.txt");

            String line = null;
            while ((line = reader.readLine()) != null){
                ObjectQueue<Character> queue = new ObjectQueue();
                for(int i = 0; i < line.length(); i++){
                    if('0' <= line.charAt(i) && line.charAt(i) <= '9'){
                        queue.push(line.charAt(i));
                    }
                }
                line += " -> ";
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    line += queue.pull();
                }
                line += " " + size + "\n";
                writer.write(line);
            }

            reader.close();
            writer.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
