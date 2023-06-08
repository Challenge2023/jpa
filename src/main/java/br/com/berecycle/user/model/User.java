package br.com.berecycle.user.model;

import br.com.berecycle.post.model.Post;
import br.com.berecycle.type.model.Type;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
        name = "tb_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_num_cnh", columnNames = "num_cnh"),
                @UniqueConstraint(name = "uk_num_cnpj", columnNames = "num_cnpj"),
                @UniqueConstraint(name = "uk_num_phone", columnNames = "num_phone"),
                @UniqueConstraint(name = "uk_ds_email", columnNames = "ds_email")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_user")
    @SequenceGenerator(
            name = "sq_user",
            sequenceName = "sq_user",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "id_user")
    private Long id;

    @Column(name = "nm_user")
    private String name;

    @Column(name = "num_cep")
    private String cep;

    @Column(name = "num_phone")
    private String phone;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_pass")
    private String pass;

    @Column(name = "ds_active")
    private Integer active;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "housenumber")
    private String houseNumber = null;

    @Column(name = "num_cnh")
    private String cnh = null;

    @Column(name = "ds_vehicle")
    private String vehicle = null;

    @Column(name = "num_cnpj")
    private String cnpj = null;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public User addPost(Post post) {

        this.posts.add(post);

        return this;
    }


}
