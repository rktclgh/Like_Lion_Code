package myweb01.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity //DB랑 매핑할거임
@Table(name= "users") //테이블 이름을 users라고 할거임
public class User {
    @Id// 기본키 지정하겠다 Pk
    @GeneratedValue(strategy = GenerationType.AUTO)// id 자동증가 하겠다.
    @Column// 해당 필드가 DB의 컬럼으로 명시  name, length nullable= true /false

    private int id;

//    @Column(name ="username", length = 50, nullable = false) // 이렇게도 줄 수 있다!
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
