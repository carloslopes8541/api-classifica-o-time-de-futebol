package br.com.cbf.campeonatobrasileiro.rest;

import br.com.cbf.campeonatobrasileiro.dto.ClassificacaoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoFinalizadoDto;
import br.com.cbf.campeonatobrasileiro.services.JogoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogoRestController {

    @Autowired
    JogoServico jogoServico;

    @PostMapping(value = "/gerar-jogos")
    public ResponseEntity<Void> gerarJogos() {
        jogoServico.gerarJogos(LocalDateTime.now());
        return ResponseEntity.ok().build();

    }
     @GetMapping
    public ResponseEntity<List<JogoDTO>> obterJogos(){
        return ResponseEntity.ok().body(jogoServico.listarJogos());
    }

    @PostMapping(value = "/finalizar/{id}")
    public ResponseEntity<JogoDTO> finalizar(@PathVariable Integer id, @RequestBody JogoFinalizadoDto jogoDTO) throws Exception{
        return  ResponseEntity.ok().body(jogoServico.finalizar(id,jogoDTO));
    }

    @GetMapping(value = "/classificacao")
    public ResponseEntity<ClassificacaoDTO> classificacao() {
        return ResponseEntity.ok().body(jogoServico.obterClassificacao());
    }

    @GetMapping(value = "/jogo/{id}")
    public ResponseEntity<JogoDTO> obterJogo(@PathVariable Integer id){
        return ResponseEntity.ok().body(jogoServico.obterJogo(id));
    }
}
