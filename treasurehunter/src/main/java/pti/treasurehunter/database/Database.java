package pti.treasurehunter.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import pti.treasurehunter.model.User;

@Repository
public class Database {
	
	private SessionFactory sessionFactory;
	
	public Database() {
		Configuration cfg = new Configuration();
		cfg.configure();

		this.sessionFactory = cfg.buildSessionFactory();
	}
	
	

	public User getUserByNameAndPassword(String userName, String password) {
		User user = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery <User> query=
				session.createSelectionQuery("Select u FROM User u WHERE u.userName = ?1 AND u.password = ?2", User.class);
		
		query.setParameter(1, userName);
		query.setParameter(2, password);
		
		List <User> users = query.getResultList();
		
		if(users.size() != 0) {
			user = users.get(0);
		}
		
		tx.commit();
		session.close();
		return user;
	}



	public User getUserById(int userId) {
		
		User user = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		user = session.get(User.class, userId);
		
		tx.commit();
		session.close();
		return user;
	}



	public void updateRecord(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.merge(user);
		
		tx.commit();
		session.close();
		
	}



	public void decreaseLives(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.merge(user);
		
		tx.commit();
		session.close();
		
	}

}
