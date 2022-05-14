package repository;

import domain.Accident;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        if (user.getUserIdx() == null) {
            em.persist(user); //새로 가입
        }
        else{
            em.merge(user); // update
        }
    }

    public User findOne(Long userIdx) {
        return em.find(User.class, userIdx);
    }

    public List<User> findAll() {
        return em.createQuery(
                "select u from User u", User.class)
                .getResultList();
    }

    public List<User> findCheckUwUserList(UserSearch userSearch) {
        String jpql = "select a from Accident a join a.user u";
        boolean isFirstCondition = true;

        if (userSearch.getLawsuitStatus() != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            }
            else{
                jpql += " and";
            }

            jpql += "a.lawsuitStatus = :lawsuitStatus";
        }

        //만약 이름 검색한다면 여기 회원 검색 추가


        TypedQuery<User> query = em.createQuery(jpql, User.class)
                .setMaxResults(1000);
        if (userSearch.getLawsuitStatus() != null) {
            query = query.setParameter("lawsuitStatus", userSearch.getLawsuitStatus());
        }
        // 회원 추가

        return query.getResultList();
    }

    public List<User> findDelinquentList() {
        //수정
        return null;
    }

    public List<User> findMaturityUserList() {
        //수정
        return null;
    }
}
