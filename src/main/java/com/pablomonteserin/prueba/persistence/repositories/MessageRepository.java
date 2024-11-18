package com.pablomonteserin.prueba.persistence.repositories;


import com.pablomonteserin.prueba.persistence.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.midi.Receiver;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByReceiverId(Integer id );
}
