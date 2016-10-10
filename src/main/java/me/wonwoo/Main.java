package me.wonwoo;

import me.wonwoo.model.Team;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by wonwoo on 2016. 10. 10..
 */
public class Main {

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

  @Test
  public void jinqTest() {
    JinqJPAStreamProvider streams = new JinqJPAStreamProvider(entityManagerFactory);
    EntityManager em = entityManagerFactory.createEntityManager();


    try {

//      streams.streamAll(em, Team.class)

//      List<Team> members = streams
//        .streamAll(em, Team.class)
//        .joinList(Team::getMembers)
//        .select(Pair::getOne)
//        .toList();

//      final List<Team> teams = streams.streamAll(em, Team.class)
//        .toList();
//      System.out.println(teams);
//
//
//      final Member member = streams
//        .streamAll(em, Member.class)
//        .where(m -> m.getName().equals("wonwoo"))
//        .getOnlyValue();
//      System.out.println(member);
//
//      final Member member1 = streams
//        .streamAll(em, Member.class)
//        .where(m -> m.getName().equals("wonwoo"))
//        .findFirst().get();
//      System.out.println(member1);
//
//      final List<Member> members = streams
//        .streamAll(em, Member.class)
//        .where(m -> m.getAge() < 20)
//        .toList();
//      System.out.println(members);

//      final Member member1 = streams
//        .streamAll(em, Member.class)
//        .where(i -> i.getName().equals("wonwoo"))
//        .getOnlyValue();
//      System.out.println(member1.getTeam());

//    final String member = streamsstream
//      .streamAll(em, Member.class)
//      .where(m -> m.getName().equals("wonwoo"))
//      .select(Member::getName)
//      .findFirst().get();
//    System.out.println(member);

//      String name = "wonwoo";
//      int age = 20;
//
//      JPAJinqStream<Member> stream = streams
//        .streamAll(em, Member.class);
//      if (name != null)
//        stream = stream.where( p -> p.getName().equals(name) );
//
//      if (age != 0) {
//        stream = stream.where( p -> p.getAge() < age );
//      }
//      System.out.println(stream.toList());

      List<Team> teams =
        streams.streamAll(em, Team.class)
          .where(i -> i.getId().equals(1L) || i.getId().equals(2L))
          .joinFetchList(Team::getMembers)
          .toList();
      System.out.println(teams);

////
////
//      for (Team c : teams) {
//        System.out.println("Cities in country: " + c.getName());
//
//        for (Member team : c.getMembers()) {
//          System.out.println("   " + team.getName());
//        }
//      }


    } finally {
      entityManagerFactory.close();
    }
  }
}
