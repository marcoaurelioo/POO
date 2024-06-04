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
	
	public boolean consultar(Hospede Hospede) {
		try {

			}

		}
		catch (IOException e) {
			
		}
		return true;
	}

}
}
