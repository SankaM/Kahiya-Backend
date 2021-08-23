package com.monda.edoctor.wahiya.service;

import com.monda.edoctor.wahiya.dto.PatientRegistrationRequest;
import com.monda.edoctor.wahiya.model.PatientEntity;
import com.monda.edoctor.wahiya.model.PatientLoginEntity;
import com.monda.edoctor.wahiya.model.PatientSessionEntity;
import com.monda.edoctor.wahiya.repository.PatientLoginRepository;
import com.monda.edoctor.wahiya.repository.PatientSessionRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service(value = "patientService")
@Transactional
public class PatientService implements UserDetailsService {
    private final BCryptPasswordEncoder bcryptEncoder;
    private final PatientLoginRepository patientLoginRepository;
    private final PatientSessionRepository patientSessionRepository;

    public PatientService(BCryptPasswordEncoder bcryptEncoder,
                          PatientLoginRepository patientLoginRepository,
                          PatientSessionRepository patientSessionRepository) {
        this.bcryptEncoder = bcryptEncoder;
        this.patientLoginRepository = patientLoginRepository;
        this.patientSessionRepository = patientSessionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        PatientLoginEntity patientLogin = patientLoginRepository.findByUserName(username);
        if (patientLogin == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(patientLogin.getUserName(), patientLogin.getPassword(), getAuthority(patientLogin.getPatientEntity()));
    }

    private Set<SimpleGrantedAuthority> getAuthority(PatientEntity patient) {
        return new HashSet<SimpleGrantedAuthority>();
    }

    public PatientEntity save(PatientRegistrationRequest request) {

        PatientLoginEntity userLogin = new PatientLoginEntity();
        userLogin.setUserName(request.getEmail());
        userLogin.setPassword(bcryptEncoder.encode(request.getPassword()));

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setEmail(request.getEmail());
        patientEntity.setName(request.getName());
        patientEntity.setAge(request.getAge());
        patientEntity.setHealthProfile(request.getHealthProfile());
        patientEntity.setImageUrl(request.getImageUrl());
        patientEntity.setMobile(request.getMobile());

        userLogin.setPatientEntity(patientEntity);
        PatientEntity savedUser = patientLoginRepository.save(userLogin).getPatientEntity();

        return savedUser;
    }

    public PatientEntity getPatientByUsername(String userName) {
        return getPatientLoginByUsername(userName).getPatientEntity();
    }

    public PatientLoginEntity getPatientLoginByUsername(String userName) {
        return patientLoginRepository.findByUserName(userName);
    }

    public void saveSession(String token, PatientLoginEntity patientLogin) {
        PatientSessionEntity patientSession = new PatientSessionEntity(patientLogin, token);
        patientSessionRepository.save(patientSession);
    }

    public boolean patientSessionHasToken(String username, String token) {
        PatientSessionEntity patientSession = patientSessionRepository.getPatientSessionEntityByTokenAndPatientLoginUserName(token.trim(), username);

        return patientSession != null;
    }

    public void updateToken(String username, String oldToken, String newToken) {
        PatientSessionEntity userSessions = patientSessionRepository.getPatientSessionEntityByTokenAndPatientLoginUserName(oldToken, username);
        userSessions.setToken(newToken);
        patientSessionRepository.save(userSessions);
    }
}
