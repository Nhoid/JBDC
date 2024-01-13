package JBDC.UserClass;

import java.sql.Timestamp;
import java.util.Objects;

public class Usuarios {
    private Integer id;
    private String name;
    private String email;
    private java.sql.Timestamp created_at;
    public Usuarios(String name) {
        this.name = name;
        this.email = name+"@gmail.com";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return Objects.equals(id, usuarios.id) && Objects.equals(name, usuarios.name) && Objects.equals(email, usuarios.email) && Objects.equals(created_at, usuarios.created_at);
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
