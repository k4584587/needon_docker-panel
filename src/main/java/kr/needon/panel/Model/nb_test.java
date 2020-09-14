package kr.needon.panel.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(of = "nb_test")
@Data
@Entity
@DynamicUpdate
@Table(name = "nb_test")
public class nb_test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String test;

}
