package hotelaria;

public interface HospedeDAO {
	public boolean cadastrar(Hospede hospede);
	public boolean consultar(Hospede hospede);
	public boolean editar(Hospede hospede);
	public boolean listar(Hospede hospede);
}
