package com.pablomonteserin.prueba.controllers;

import com.pablomonteserin.prueba.dtos.MessagesDTO;
import com.pablomonteserin.prueba.persistence.entities.Message;
import com.pablomonteserin.prueba.persistence.entities.User;
import com.pablomonteserin.prueba.persistence.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController {

@Autowired
    private MessageRepository messageRepository;
    @PostMapping("/")
    public void saveMessage(@RequestBody MessagesDTO dto) {
        List<Integer> userIds = dto.getUserIds();
        User sender = new User();
        sender.setId(dto.getSenderId());
        userIds.forEach(id -> {
            Message message = new Message();
            User receiver = new User();
            receiver.setId(id);
            message.setMessage(dto.getMessage());
            message.setSender(sender);
            message.setReceiver(receiver);
            messageRepository.save(message);
        });
    }

    @GetMapping("/{userId}")
    public List<Message> getMessages(@PathVariable("userId") Integer userId) {
        List<Message> messages =  messageRepository.findByReceiverId(userId);
 messages.stream().forEach(message -> message.setMessage(message.getMessage() + "uuuuuuuuu"));
return messages;
    }
}
