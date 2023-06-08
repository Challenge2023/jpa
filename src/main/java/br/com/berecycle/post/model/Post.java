package br.com.berecycle.post.model;

import br.com.berecycle.type.model.Type;
import br.com.berecycle.user.model.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "tb_post",
        uniqueConstraints = {
            @UniqueConstraint(name = "fk_user_post", columnNames = "id_user"),
        }
)

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_post")
    @SequenceGenerator(
            name = "sq_post",
            sequenceName = "sq_post",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "id_post")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id_user",
            foreignKey = @ForeignKey(
                    name = "fk_post_user",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private User user;

    @Column(name = "nm_post")
    private String name;

    @Column(name = "num_phone")
    private String phone;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_local")
    private String local;

    @Column(name = "ds_post")
    private String description;

    @Column(name = "ds_active")
    private Integer active;

    @Enumerated(EnumType.STRING)
    private Type type;


}
