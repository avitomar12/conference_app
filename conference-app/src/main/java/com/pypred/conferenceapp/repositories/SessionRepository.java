package com.pypred.conferenceapp.repositories;

import com.pypred.conferenceapp.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}