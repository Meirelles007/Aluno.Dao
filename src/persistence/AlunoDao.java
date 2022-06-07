package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import model.Aluno;

public class AlunoDao implements IAlunoDisciplina<Aluno> {
	private SessionFactory sf;

	public AlunoDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Aluno aluno) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(aluno);
		transaction.commit();
	}

	@Override
	public void update(Aluno aluno) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(aluno);
		transaction.commit();
	}

	@Override
	public void delete(Aluno aluno) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(aluno);
		transaction.commit();
	}

	@Override
	public Aluno selectOne(Aluno aluno) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		aluno = entityManager.find(Aluno.class, aluno.getRa());
		return aluno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * from aluno");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> alunosResultSet = query.getResultList();
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Object[] o : alunosResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa((o[0].toString()));
			aluno.setEmail(o[1].toString());
			aluno.setNome((o[2].toString()));
			aluno.setPosicaoVestibular(Integer.parseInt(o[3].toString()));
			alunos.add(aluno);
		}
		
		return alunos;
	}

}
