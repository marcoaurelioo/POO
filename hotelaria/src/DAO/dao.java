package DAO;
import java.util.ArrayList;

public interface dao<T> {
  public boolean cadastrar(T object);
  public T consultar(T object);
  public boolean editar(T hospede);
  public ArrayList<T> listar(T object);
}
