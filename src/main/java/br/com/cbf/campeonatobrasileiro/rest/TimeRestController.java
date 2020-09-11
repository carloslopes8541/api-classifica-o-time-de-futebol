package br.com.cbf.campeonatobrasileiro.rest;

import br.com.cbf.campeonatobrasileiro.dto.TimeDTO;
import br.com.cbf.campeonatobrasileiro.services.TimeServico;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {

    @Autowired
    private TimeServico timeServico;

    @GetMapping
    public ResponseEntity<List<TimeDTO>> GetTimes() {
        return ResponseEntity.ok().body(timeServico.listarTimes());

    }

    @ApiOperation(value ="obtem dados de um time ")
    @GetMapping(value = {"id"})
    public  ResponseEntity<TimeDTO> GetTime(@PathVariable Integer id){
        return ResponseEntity.ok().body(timeServico.obterTime(id));
    }

    @PostMapping
    public ResponseEntity<TimeDTO> cadastrarTime(@Valid @RequestBody TimeDTO time) throws Exception {
        return ResponseEntity.ok().body(timeServico.cadastrarTime(time));
    }
}
