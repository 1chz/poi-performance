package io.github.shirohoo.poi.performance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int col1;
    private int col2;
    private int col3;
    private int col4;
    private int col5;
    private int col6;
    private int col7;
    private int col8;
    private int col9;
    private int col10;

    public Person(String name, int col1, int col2, int col3, int col4, int col5, int col6, int col7, int col8, int col9, int col10) {
        this.name = name;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
        this.col5 = col5;
        this.col6 = col6;
        this.col7 = col7;
        this.col8 = col8;
        this.col9 = col9;
        this.col10 = col10;
    }
}
