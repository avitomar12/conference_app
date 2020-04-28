package com.pypred.conferenceapp.Controllers;

import java.util.List;

import com.pypred.conferenceapp.models.Session;
import com.pypred.conferenceapp.repositories.SessionRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;
    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);

    }
    @PostMapping 
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Also need to check for children record befor deleting.
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        //because this is put, we expect all attribute to be passes in. A patch would only need what
        //Add validation that all attributes are passed in, other wise return a 400 bad payload
Session existingSession = sessionRepository.getOne(id);
BeanUtils.copyProperties(session, existingSession, "session_id");
return sessionRepository.saveAndFlush(existingSession);

        
    }
}