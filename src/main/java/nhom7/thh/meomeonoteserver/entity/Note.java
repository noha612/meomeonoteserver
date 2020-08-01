package nhom7.thh.meomeonoteserver.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "note")
@Data
public class Note implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "password")
    private String password;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "timer")
    private String timer;

    @Column(name = "created")
    private String created;

    @Column(name = "last_modified")
    private String lastModified;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "status")
    private int status;
}
