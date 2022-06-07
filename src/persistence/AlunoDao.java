package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
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
	public List<Aluno> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
