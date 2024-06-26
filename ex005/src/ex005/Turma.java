package ex005;
import java.util.List;
import java.util.ArrayList;

public class Turma {
	private List<Aluno> alunos;
	private String curso;
	
	public Turma(String curso) {
		this.alunos = new ArrayList<>();
		this.curso = curso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public void adicionarAlunos(Aluno aluno) {
		alunos.add(aluno);
	}
	
    public Aluno alunoComMaiorMedia() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno alunoMaiorMedia = alunos.get(0);
        
        for (int i = 1; i < alunos.size(); i++) {
            if (alunos.get(i).getMediaGlobal() > alunoMaiorMedia.getMediaGlobal()) {
                alunoMaiorMedia = alunos.get(i);
            }
        }
        return alunoMaiorMedia;
    }
    
    public Aluno alunoMaisNovo() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno alunoMaisNovo = alunos.get(0);
        
        for (int i = 1; i < alunos.size(); i++) {
            if (alunos.get(i).getAnoNascimento() > alunoMaisNovo.getAnoNascimento()) {
                alunoMaisNovo = alunos.get(i);
            }
        }
        return alunoMaisNovo;
    }
}
