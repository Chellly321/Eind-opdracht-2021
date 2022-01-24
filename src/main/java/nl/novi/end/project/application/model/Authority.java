package nl.novi.end.project.application.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityKey.class)
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;


}
