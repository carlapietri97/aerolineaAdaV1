package com.ada.aerolinea.aerolineaAdaV1.controller;

import com.ada.aerolinea.aerolineaAdaV1.model.*;
import com.ada.aerolinea.aerolineaAdaV1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aerolinea/ada/v1")

public class MainController {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    //GET

    @GetMapping(path = "/base/all")
    public @ResponseBody
    Iterable<Base> getAllBases() {
        return baseRepository.findAll();
    }

    @GetMapping(path = "/base/{id_base}")
    public @ResponseBody
    Optional<Base> getBaseById(@PathVariable("id_base") int id_base) {
        return baseRepository.findById(id_base);
    }

    @GetMapping(path = "/pilot/all")
    public @ResponseBody
    Iterable<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }

    @GetMapping(path = "/pilot/{id}")
    public @ResponseBody
    Optional<Pilot> getPilotById(@PathVariable("id") int id) {
        return pilotRepository.findById(id);
    }

    @GetMapping(path = "/airplane/all")
    public @ResponseBody
    Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @GetMapping(path = "/airplane/{id_airplane}")
    public @ResponseBody
    Optional<Airplane> getAirplaneById(@PathVariable("id_airplane") int id_airplane) {
        return airplaneRepository.findById(id_airplane);
    }

    @GetMapping(path = "/crew/all")
    public @ResponseBody
    Iterable<Crew> getAllCrew() {

        return crewRepository.findAll();
    }

    @GetMapping(path = "/flight/all")
    public @ResponseBody
    Iterable<Flight> getAllFlights() {

        return flightRepository.findAll();
    }

    @GetMapping(path = "/user/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/user/{id_user}")
    public @ResponseBody
    Optional<User> getUserById(@PathVariable("id_user") int id_user) {
        return userRepository.findById(id_user);
    }

    @GetMapping(path = "/role/all")
    public @ResponseBody
    Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping(path = "/role/{id_role}")
    public @ResponseBody
    Optional<Role> getRoleById(@PathVariable("id_role") int id_role) {
        return roleRepository.findById(id_role);
    }

    @GetMapping(path = "/resource/all")
    public @ResponseBody
    Iterable<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @GetMapping(path = "/resource/{id_resource}")
    public @ResponseBody
    Optional<Resource> getResourceById(@PathVariable("id_resource") int id_resource) {
        return resourceRepository.findById(id_resource);
    }

    @GetMapping(path = "/role/all/user/{userId}")
    public @ResponseBody
    Collection<Integer> getAllRolesByUserId(@PathVariable("userId") int userId) {
        return roleRepository.getRolesByUserId(userId);
    }


    //POST


    @PostMapping(path = "/base/create", consumes = "application/json", produces = "application/json")
    public Base createBase(@RequestBody Base newBase) {
        return baseRepository.save(newBase);
    }

    @PostMapping(path = "/pilot/create", consumes = "application/json", produces = "application/json")
    public Pilot createPilot(@RequestBody Pilot newPilot) {
        return pilotRepository.save(newPilot);
    }

    @PostMapping(path = "/airplane/create", consumes = "application/json", produces = "application/json")
    public Airplane createAirplane(@RequestBody Airplane newAirplane) {
        return airplaneRepository.save(newAirplane);
    }

    //PUT

    @PutMapping(path = "/base/update")
    public Base updateBase(@RequestBody Base updatedBase) {
        return baseRepository.save(updatedBase);
    }

    @PutMapping(path = "/pilot/update")
    public Pilot updatePilot(@RequestBody Pilot updatedPilot) {
        return pilotRepository.save(updatedPilot);
    }

    @PutMapping(path = "/pilot/{id}/update/new_base/{id_base}")
    public Pilot updateBasePilot(@PathVariable("id") int id, @PathVariable("id_base") int id_base) {

        Pilot pilot = pilotRepository.findById(id).get();
        Base base = baseRepository.findById(id_base).get();

        pilot.setBase(base);
        pilotRepository.save(pilot);
        return pilot;
    }

    @PutMapping(path = "/airplane/update")
    public Airplane updateAirplane(@RequestBody Airplane updatedAirplane) {
        return airplaneRepository.save(updatedAirplane);
    }

    @PutMapping(path = "/airplane/{id_airplane}/update/new_base/{id_base}")
    public Airplane updateBaseAirplane(@PathVariable("id_airplane") int id, @PathVariable("id_base") int id_base) {

        Airplane airplane = airplaneRepository.findById(id).get();
        Base base = baseRepository.findById(id_base).get();

        airplane.setBase(base);
        airplaneRepository.save(airplane);
        return airplane;
    }

    //DELETE

    @DeleteMapping(path = "/base/delete/{id_base}")
    Iterable<Base> deleteBaseById(@PathVariable("id_base") int id_base) {
        baseRepository.deleteById(id_base);
        return baseRepository.findAll();
    }

    @DeleteMapping(path = "/pilot/delete/{id}")
    Iterable<Pilot> deletePilotById(@PathVariable("id") int id) {
        pilotRepository.deleteById(id);
        return pilotRepository.findAll();
    }

    // CUSTOM QUERIES

    @GetMapping(path = "/base/name/like/{city}")
    public @ResponseBody
    Iterable<Base> getBaseByNameLike(@PathVariable("city") String city) {
        return baseRepository.getBasesByNameLike(city);
    }

    @GetMapping(path = "/flight/city/like/{city}")
    public @ResponseBody
    Iterable<Flight> getFlightByOriginOrDestinationLike(@PathVariable("city") String city) {
        return flightRepository.getFlightByOriginOrDestinationLike(city);
    }

    @GetMapping(path = "/flight/date/{year}/{month}")
    public @ResponseBody
    Iterable<Flight> getFlightByDate(@PathVariable("year") int year, @PathVariable("month") int month) {
        return flightRepository.getFlightByDate(year, month);
    }


}
