package MetThePet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 3, max =30, message = "Post Author size must be at least 3 characters and max 30 characters")
    private String postAuthor;
    @Size(min = 3, max =50, message = "Post Title size must be at least 3 characters and max 50 characters")
    private String postTitle;
    @Size(min = 3, max =100, message = "Add picture from memory")
    private String addPic;
    @Size(min = 3, max =100, message = "Add movie from memory")
    private String addMovie;
    @Column(length = 1000)
    private String picText;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

//    @ManyToMany
//    private List<Comment> comments=new ArrayList<>();
//    public void addComment(Comment comment){
//        comments.add(comment);
//    }
}
