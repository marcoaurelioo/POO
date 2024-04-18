package hotelaria;

class Funcionario extends Pessoa {
    private String cargoFuncionario;

    public Funcionario(String nome, String email, String cargoFuncionario) {
        super(nome, email);
        this.cargoFuncionario = cargoFuncionario;
    }

	public String getCargoFuncionario() {
		return cargoFuncionario;
	}

	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

   
}