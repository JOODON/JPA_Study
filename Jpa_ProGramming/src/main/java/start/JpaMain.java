package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaTest");
        //[ Entity ]매니저 팩토리 생성
        EntityManager em = emf.createEntityManager();
        //[ Entity ] 매니저 생성
        EntityTransaction tx=em.getTransaction();
        //[트랜잭션] 생성;

        try {
            tx.begin(); //시작 
            logic(em); //로직 실행
            tx.commit();//커밋
        }catch (Exception e){
            tx.rollback(); //콜백
            System.out.println("Error message: " + e.getMessage());
        }finally {
            em.clear(); //정려
        }
        emf.close();//엔티티 매니저 팩토리 종료
    }

    private static void logic(EntityManager em) {
        String id ="id1";
        Member member=new Member();
        member.setId(id);
        member.setUserName("주동호");
        member.setAge(23);

        em.persist(member);//[실행부분]

        member.setAge(19);//[수정 부분]

        Member findMember = em.find(Member.class, id); //[찾기 부분]
        System.out.println(" findMember "+ findMember.getUserName() + " ,age = " + findMember.getAge());

        List<Member> memberList = em.createQuery("select  m from Member m ",Member.class).getResultList();

        System.out.println("memberSize" + memberList.size());

        em.remove(member);
    }

}
