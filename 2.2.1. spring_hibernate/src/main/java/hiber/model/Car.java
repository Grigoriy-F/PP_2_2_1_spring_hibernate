package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

// @Entity — Указывает, что данный бин (класс) является сущностью.
@Entity
// @Table — указывает на имя таблицы, которая будет отображаться в этой сущности.
@Table(name = "car",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"model", "series"})})
public class Car implements Serializable {

    @Id // @Id — id колонки
    private Long id; // Используем id User в качестве идентификатора для Car
    @OneToOne // @OneToOne —  указывает на связь между таблицами «один к одному».
    @MapsId // Связываем идентификатор Car с идентификатором User
    @JoinColumn(name = "user_id")
    private User user;

    // @Column — указывает на имя колонки, которая отображается в свойство сущности
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "user=" + user +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}