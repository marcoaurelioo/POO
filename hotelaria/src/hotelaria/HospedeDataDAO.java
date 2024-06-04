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
			
			bufferedWriter.write(hospede.getCpf() + ", " + hospede.getNome() + ", " + hospede.getEmail() + ", " + hospede.getEnderecoCompleto());
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

	//TESTE
	public boolean editar(Hospede hospede) {
        String tempFile = "temp.txt";
        String filePath = "Hospede.txt";
        boolean houveEdicao = false;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(tempFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             Scanner scanner = new Scanner(System.in)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 1 && data[0].trim().equals(hospede.getCpf())) { // Encontrou o CPF
                    if (data.length >= 2 && data[1].trim().equals(hospede.getNome())) { // Encontrou o nome
                        System.out.println("Novo nome:");
                        String novoNome = scanner.nextLine().trim();
                        System.out.println("Novo email:");
                        String novoEmail = scanner.nextLine().trim();
                        System.out.println("Novo endereço:");
                        String novoEndereco = scanner.nextLine().trim();

                        // Edita as informações
                        bufferedWriter.write(hospede.getCpf() + ", " + novoNome + ", " + novoEmail + ", " + novoEndereco);
                        bufferedWriter.newLine();
                        houveEdicao = true;
                    } else {
                        // Mantém a linha original no arquivo temporário
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                } else {
                    // Mantém a linha original no arquivo temporário
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Substitui o arquivo original pelo temporário
        File originalFile = new File(filePath);
        File temp = new File(tempFile);
        if (temp.renameTo(originalFile)) {
            System.out.println("Edição concluída com sucesso.");
        } else {
            System.out.println("Falha ao editar o hóspede.");
        }

        return houveEdicao;
    }
}
