package modelo;

public class BeanCoche {
    private long id;
    private String modelo;
    private String matricula;
    private long id_persona; //id del dueño de la persona

    public BeanCoche() {
    }

    public BeanCoche(long id, String modelo, String matricula, long id_persona) {
        this.id = id;
        this.modelo = modelo;
        this.matricula = matricula;
        this.id_persona = id_persona;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }
}
