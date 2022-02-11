package fr.formation.inti.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import fr.formation.inti.entity.User;

@Service("userDao")
public class UserDao extends GenericDaoHibernate<User, Integer> implements IUserDao {

	public User findByLoginAndPassword(String login, String password) {
		Query<User> query = getCurrentSession().createQuery(
				"from " + User.class.getName() + " u where u.login= :login and u.password = :pass", User.class);
		query.setParameter("login", login);
		query.setParameter("pass", password);

		return query.getSingleResult();
	}

}
