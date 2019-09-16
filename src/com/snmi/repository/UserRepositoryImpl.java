package com.snmi.repository;

import com.snmi.enums.UpdateTypes;
import com.snmi.model.User;
import com.snmi.hibernate.HibernateUtilities;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

/**
 * User repository implementation
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserRepositoryImpl implements UserRepository {

    /**
     * Constants
     */
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TOTAL = "total";
    private static final String GOAL = "goal";
    private static final String READ_ALL_USERS = "readAllUsers";
    private static final String READ_BY_ID = "readUserById";
    private static final String READ_BY_NAME = "readUserByName";
    private static final String UPDATE_NAME_BY_ID = "updateNameById";
    private static final String UPDATE_TOTAL_BY_ID = "updateTotalById";
    private static final String UPDATE_GOAL_BY_ID = "updateGoalById";
    private static final String DELETE_BY_ID = "deleteUserById";
    private static final String ILLEGAL_QUERY_MESSAGE = "Not implemented query!";

    /**
     * Create user
     * @param user take the user
     * @return the created user
     */
    @Override
    public User createUser(User user) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    /**
     * Read all users in the database
     * @return users list
     */
    @Override
    public List<User> readAllUsers() {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(READ_ALL_USERS);
        List<User> users = query.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    /**
     * Read and paging users
     * @param start take the start point
     * @param show take how many records you want to show
     * @return users list
     */
    @Override
    public List<User> pagingAllUsers(int start, int show) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(READ_ALL_USERS).setFirstResult(start).setMaxResults(show);
        List<User> users = query.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    /**
     * Read specific user by id
     * @param id take the id
     * @return the founded user
     */
    @Override
    public User readUserById(int id) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(READ_BY_ID).setInteger(ID, id);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    /**
     * Read specific user by name
     * @param name take the name
     * @return users list with these names
     */
    @Override
    public List<User> readUserByName(String name) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(READ_BY_NAME).setString(NAME, name);
        List<User> users = query.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    /**
     * Update specific user by id
     * @param id take the id
     * @param name take the name
     * @param goal take the goal
     * @param total take the total
     * @param updateTypes take update type
     * @return loaded user
     */
    @Override
    public User updateUser(int id, String name, int goal, int total, UpdateTypes updateTypes) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query loadQuery = session.getNamedQuery(READ_BY_ID).setInteger(ID, id);
        User user = (User) loadQuery.uniqueResult();
        Query updateQuery = manageUpdateQuery(session, id, name, goal, total, updateTypes);
        updateQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    /**
     * Delete specific user by id
     * @param id take the id
     */
    @Override
    public void deleteUser(int id) {
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Query userQuery = session.getNamedQuery(DELETE_BY_ID).setInteger(ID, id);
        userQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Managing the update query by update type
     * @param session take the session object
     * @param id take the id
     * @param name take the name
     * @param goal take the goal
     * @param total take the total
     * @param updateTypes take the update type
     * @return the query we need for an update
     */
    private Query manageUpdateQuery(Session session, int id, String name, int goal, int total, UpdateTypes updateTypes) {
        switch (updateTypes) {
            case NAME:
                return session.getNamedQuery(UPDATE_NAME_BY_ID).setString(NAME, name).setInteger(ID, id);
            case TOTAL:
                return session.getNamedQuery(UPDATE_TOTAL_BY_ID).setInteger(TOTAL, total).setInteger(ID, id);
            case GOAL:
                return session.getNamedQuery(UPDATE_GOAL_BY_ID).setInteger(GOAL, goal).setInteger(ID, id);
            default:
                throw new IllegalArgumentException(ILLEGAL_QUERY_MESSAGE);
        }
    }
}
