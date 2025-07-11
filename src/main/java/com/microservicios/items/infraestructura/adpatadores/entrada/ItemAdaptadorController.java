package com.microservicios.items.infraestructura.adpatadores.entrada;

import com.microservicios.items.aplicacion.puertos.entrada.ItemPuertoEntrada;
import com.microservicios.items.infraestructura.adpatadores.entrada.dto.ItemRequestDto;
import com.microservicios.items.infraestructura.adpatadores.entrada.dto.ItemResponseDto;
import com.microservicios.items.infraestructura.adpatadores.entrada.mapper.ItemWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@RestController
public class ItemAdaptadorController  {

    public  final ItemPuertoEntrada puertoEntrada;
    public  final ItemWebMapper mapper;


    public ItemAdaptadorController(ItemPuertoEntrada puertoEntrada, ItemWebMapper mapper) {
        this.puertoEntrada = puertoEntrada;
        this.mapper = mapper;
    }

    @GetMapping("/items")
    public List<ItemResponseDto> listarProductos(){
        return mapper.toListResponseDto(puertoEntrada.obtenerTodosLosItems());
    }
    @GetMapping("items/{id}")
    public ResponseEntity<ItemResponseDto >listarPorId(@PathVariable Long id){
        return puertoEntrada.obtenerItemPorId(id)
                .map(mapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("items")
    public ResponseEntity<ItemResponseDto> creatItem(@Valid@RequestBody ItemRequestDto itemRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponseDto(puertoEntrada.crearItem(mapper.toDomain(itemRequestDto))));
    }
    @PutMapping ("items/{id}")
    public ResponseEntity<ItemResponseDto> modificarItem(@Valid@RequestBody Long id,ItemRequestDto itemRequestDto){
        if (itemRequestDto.getId()==null ||!id.equals(itemRequestDto.getId())){
            itemRequestDto.setId(id);
        }
        return ResponseEntity.ok(mapper.toResponseDto(puertoEntrada.crearItem(mapper.toDomain(itemRequestDto))));
        }
    @DeleteMapping("items/{id}")
    public void eliminarItem(Long id){
        puertoEntrada.eliminarItem(id);
    }


}
