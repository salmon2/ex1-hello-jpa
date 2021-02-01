package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        //팩토리 웹 서버 한개만
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");
        //고객의 요청이 올때마다 썻다가 버렸다가. 쓰레드간 공유 절대 안됨
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            저장
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("hello");
//
//            em.persist(member);

//            수정
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("member = " + findMember);
//            findMember.setName("HelloJPA");

//            검색 리스트 쿼리 만들기
            //                                        멤버 객체를 다들고와
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member: result) {
//                System.out.println("member = " + member.getName());
//            }
//
//            //비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJpa");
//
//            //영속
//            System.out.println("===before===");
//            em.persist(member);
//            System.out.println("===after===");
//
//            Member findMember = em.find(Member.class, 100L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());


//            인설트 쿼리는 모은다음 commit 시점에 날린다.
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("============");

//            변경 감지
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ");
//            System.out.println("=======");

            Member member = new Member(200L, "member200");
            em.persist(member);
            //바로 쿼리 날라감
            em.flush();

            System.out.println("=======");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
fdfd
        emf.close();
    }
}
