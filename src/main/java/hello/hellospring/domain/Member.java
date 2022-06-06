package hello.hellospring.domain;

import javax.persistence.*;

/**
 * @Entity 를 사용하면 JPA가 관리하는  Entity가 된다.
 */
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
