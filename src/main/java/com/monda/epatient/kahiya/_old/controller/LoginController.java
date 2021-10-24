//package com.monda.epatient.wahiya._old.controller;
//
//import com.monda.epatient.wahiya._old.config.security.JwtTokenHandler;
//import com.monda.epatient.wahiya._old.dto.LoginRequest;
//import com.monda.epatient.wahiya._old.dto.LoginResponse;
//import com.monda.epatient.wahiya._old.dto.PatientRegistrationRequest;
//import com.monda.epatient.wahiya._old.exception.LoginException;
////import com.monda.edoctor.wahiya.model.DoctorEntity;
////import com.monda.edoctor.wahiya.service.DoctorEntityService;
//import com.monda.epatient.wahiya._old.model.PatientEntity;
//import com.monda.epatient.wahiya._old.model.PatientLoginEntity;
//import com.monda.epatient.wahiya._old.service.PatientService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/v1")
//public class LoginController {
//
////    @Autowired
////    private DoctorEntityService doctorEntityService;
//    @Autowired
//    private PatientService patientService;
//    @Autowired
//    private JwtTokenHandler jwtTokenUtil;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping(value = "/doctor/login")
//    @ResponseStatus(code = HttpStatus.OK)
//    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws LoginException {
////        DoctorEntity doctorEntity = doctorEntityService.validateLogin(loginRequest);
////        return LoginResponse.builder().doctorId(String.valueOf(doctorEntity.getDoctorId()))
////                .doctorName(doctorEntity.getName())
////                .userName(loginRequest.getUserName())
////                .location(doctorEntity.getAddress3())
////                .imageUrl(doctorEntity.getImageLink())
////                .build();
//        return null;
//    }
//
//    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PatientEntity> saveUser(@RequestBody PatientRegistrationRequest userRegistrationReq) {
//        PatientEntity save = patientService.save(userRegistrationReq);
//        return ResponseEntity.ok(save);
//    }
//
//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PatientEntity> generateToken(@RequestBody LoginRequest loginUser, HttpServletResponse response) {
//        PatientEntity user = patientService.getPatientByUsername(loginUser.getUserName());
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginUser.getUserName(),
//                        loginUser.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        final String token = jwtTokenUtil.generateToken(authentication);
//        PatientLoginEntity userLogin = patientService.getPatientLoginByUsername(loginUser.getUserName());
//        patientService.saveSession(token, userLogin);
//        response.setHeader("token", token);
//
//        return ResponseEntity.ok(userLogin.getPatientEntity());
//    }
//}
