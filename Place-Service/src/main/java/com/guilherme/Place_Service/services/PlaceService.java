package com.guilherme.Place_Service.services;

import com.guilherme.Place_Service.dtos.PlaceDTO;
import com.guilherme.Place_Service.models.PlaceModel;
import com.guilherme.Place_Service.repositories.PlaceRepository; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    //Método para criar um lugar
    public PlaceModel createPlace(PlaceDTO placeDTO){
        PlaceModel placeModel = new PlaceModel();
        placeModel.setName(placeDTO.name());
        placeModel.setSlug(placeDTO.slug());
        placeModel.setCity(placeDTO.city());
        placeModel.setState(placeDTO.state());

        return placeRepository.save(placeModel);
    }

    //Método para atualizar um lugar pelo ID
    public Optional<PlaceModel> updatePlace(Long id, PlaceDTO placeDTO){
        Optional<PlaceModel> optionalPlaceModel = placeRepository.findById(id);

        //Verifica se um valor está presente no Optional
        if (optionalPlaceModel.isPresent()) {
            PlaceModel placeModel = optionalPlaceModel.get();
            placeModel.setName(placeDTO.name());
            placeModel.setSlug(placeDTO.slug());
            placeModel.setCity(placeDTO.city());
            placeModel.setState(placeDTO.state());
            return Optional.of(placeRepository.save(placeModel));
        }
        return Optional.empty(); // Indica que o lugar não foi encontrado
    }

    //Método para buscar um lugar pelo ID
    public Optional<PlaceModel> searchPLace(Long id){
        return placeRepository.findById(id);
    }

    //Método para listar os lugares
    public List<PlaceModel> listPlaces(){
        return placeRepository.findAll();
    }
}
