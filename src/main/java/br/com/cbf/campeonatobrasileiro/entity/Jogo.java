package br.com.cbf.campeonatobrasileiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer golsTime1;
    private  Integer golsTime2;
    private  Integer publicoPagante;
    private LocalDateTime dataJogo;
    private  Integer rodada;
    private  Boolean encerrado;

    @ManyToOne
    @JoinColumn(name = "time1")
    private  Time time1;

    @ManyToOne
    @JoinColumn(name = "time2")
    private  Time time2;


    public Jogo() {
    }


    public LocalDateTime getData() {
        return dataJogo;
    }

    public Integer getRodada() {
        return rodada;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getTime1() {
        return time1;
    }

    public void setGolsTime1(Integer golsTime1) {
        this.golsTime1 = golsTime1;
    }

    public void setGolsTime2(Integer golsTime2) {
        this.golsTime2 = golsTime2;
    }

    public Integer getPublicoPagante() {
        return publicoPagante;
    }

    public void setPublicoPagante(Integer publicoPagante) {
        this.publicoPagante = publicoPagante;
    }

    public void setDataJogo(LocalDateTime dataJogo) {
        this.dataJogo = dataJogo;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }


    public Boolean getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(Boolean encerrado) {
        this.encerrado = encerrado;
    }

    public Integer getGolsTime1() {
        return golsTime1;
    }

    public Integer getGolsTime2() {
        return golsTime2;
    }


    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
