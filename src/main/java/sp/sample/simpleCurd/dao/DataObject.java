package sp.sample.simpleCurd.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items")
public class DataObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String item;
}
