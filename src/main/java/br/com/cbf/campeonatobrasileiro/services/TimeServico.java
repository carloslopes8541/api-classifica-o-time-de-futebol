package br.com.cbf.campeonatobrasileiro.services;



import br.com.cbf.campeonatobrasileiro.dto.TimeDTO;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeServico {

    @Autowired
    private TimeRepository repository;
    private TimeDTO time;


    public TimeDTO cadastrarTime(TimeDTO time) throws Exception {
        Time entity = toEntity(time);
        if (time.getId() == null){
            Integer newId = Math.toIntExact(repository.count() + 1);
            entity.setId(newId);
         entity = repository.save(entity);
        return toDto(entity);
        }else{
            throw new  Exception("time já existe");
        }

    }

    private Time toEntity(TimeDTO time) {
        Time entity = new Time();
        entity.setId(time.getId());
        entity.setEstadio(time.getEstadio());
        entity.setSigla(time.getSigla());
        entity.setNome(time.getNome());
       entity.setUf(time.getUf());
        return entity;

    }

    public TimeDTO toDto(Time entity) {
        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setEstadio(entity.getEstadio());
        dto.setSigla(entity.getSigla());
        dto.setNome(entity.getNome());
        dto.setUf(entity.getUf());
        return dto;
    }

    public List<TimeDTO> listarTimes(){
        return repository.findAll().stream().map(entity ->toDto(entity)).collect(Collectors.toList());
    }



    public TimeDTO obterTime(Integer id){
        return toDto(repository.findById(id).get());
    }


    public List<Time> findAll() {
        return repository.findAll();
    }
}
