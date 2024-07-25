package com.guilherme.Place_Service.controllers;

import com.guilherme.Place_Service.dtos.PlaceDTO;
import com.guilherme.Place_Service.models.PlaceModel;
import com.guilherme.Place_Service.services.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    final PlaceService placeService;
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    //Endpoint da criação de um lugar
    @PostMapping("/create")
    public ResponseEntity<PlaceModel> createPlace(@RequestBody PlaceDTO placeDTO){
        PlaceModel createdPlace = placeService.createPlace(placeDTO);
        return ResponseEntity.ok(createdPlace);
    }

    //Endpoint para atualizar um lugar pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<PlaceModel> updatePlace(@PathVariable Long id,@RequestBody PlaceDTO placeDTO){
        Optional<PlaceModel> updatedPlace = placeService.updatePlace(id, placeDTO);

        //Indica que o lugar não foi encontrado
        if (updatedPlace.isPresent()){
            return ResponseEntity.ok(updatedPlace.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para buscar um lugar pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<PlaceModel> searchPlace(@PathVariable Long id){
        Optional<PlaceModel> placeModel = placeService.searchPLace(id);

        if (placeModel.isPresent()){
            return ResponseEntity.ok(placeModel.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para Listar os lugares
    @GetMapping("/list-places")
    public ResponseEntity<List<PlaceModel>> listPlaces(){
        List<PlaceModel> places = placeService.listPlaces();
        return ResponseEntity.ok(places);
    }

}