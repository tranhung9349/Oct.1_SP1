package da.qlcn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    private Date createdDate;
    @OneToOne
    private User user;
}
