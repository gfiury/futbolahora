/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.PartidoDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Guillermo
 */
@Local
public interface FutbolPartidoBeanLocal {
    
    List<PartidoDto> getPartidos();
    
    PartidoDto findPartidoById(Long id);
}
