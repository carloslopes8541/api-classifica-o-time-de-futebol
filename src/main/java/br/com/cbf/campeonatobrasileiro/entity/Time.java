package br.com.cbf.campeonatobrasileiro.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Time {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(length = 20)
    private String nome;
    @Column(length = 4)
    private String sigla;
    @Column(length = 2)
    private String uf;
    private String estadio;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
