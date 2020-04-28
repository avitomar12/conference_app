package com.pypred.conferenceapp.repositories;

import com.pypred.conferenceapp.models.Speaker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}