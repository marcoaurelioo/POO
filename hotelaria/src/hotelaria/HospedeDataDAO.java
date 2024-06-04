package hotelaria;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class HospedeDataDAO implements HospedeDAO{
	public boolean cadastrar(Hospede hospede) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("Hospede.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(hospede.getCpf() + ", " + hospede.getNome() + ", " + hospede.getEmail());
			bufferedWriter.newLine();
			bufferedWriter.close();	
		} catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean consultar(Hospede hospede) {
	    try (FileReader fileReader = new FileReader("Hospede.txt");
	         BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] data = line.split(","); 

	            if (data.length >= 1 && data[0].trim().equals(hospede.getCpf())) { 
	                if (data.length >= 2 && data[1].trim().equals(hospede.getNome())) { 
	                    return true; 
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false; 
	}
}
