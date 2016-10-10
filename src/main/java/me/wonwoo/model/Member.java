package me.wonwoo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 4. 24..
 */
@Entity
@Data
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private int age;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TEAM_ID")
  private Team team;
}
