package com.example.katas.data.mappers

import com.example.katas.data.model.entities.GeneroDto as DataGenero
import com.example.katas.domain.model.Genero as DomainGenero

// Mapper para convertir DataGenero a DomainGenero
fun DataGenero.toDomainModel():DomainGenero {
    return   DomainGenero(
        id = this.id,
        name = this.name
    )
}
// Mapper para convertir una lista de DataGenero a una lista de DomainGenero
fun List<DataGenero>.toDomainModelList(): List<DomainGenero>{
    return  this.map { it.toDomainModel() }
}


